package com.zt.controller;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.zt.entity.EnterpriseInv;
import com.zt.entity.Investmenter;
import com.zt.es.entity.EsArticle;
import com.zt.es.entity.EsEnterpriseInfo;
import com.zt.es.service.EsArticleService;
import com.zt.es.service.EsEnterpriseInfoService;
import com.zt.mongo.entity.Article;
import com.zt.mongo.service.ArticleService;
import com.zt.utils.ClassReflection;
import com.zt.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("myController")
public class MyController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private EsArticleService esArticleService;

    @Autowired
    private EsEnterpriseInfoService esEnterpriseInfoService;

    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
        List<Article> articles = articleService.findListByPageRtList(1, 2);
        articles.forEach(article -> {
            EsArticle esArticle = new EsArticle();
            try {
                ClassReflection.reflectionAttr(article, esArticle);
                System.out.println(esArticle.toString());
                esArticleService.add(esArticle);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
        return articles.size();
    }

    @RequestMapping("/saveEnterpriseInfo")
    @ResponseBody
    public Object saveEnterpriseInfo(@RequestParam("file") MultipartFile file, @RequestParam("encode") String encode) {
//        MultipartFile file = null;
        InputStream fis = null;
        try {
            fis = file.getInputStream();
            JSONArray jsonArray = Utils.readCsv(fis, encode);
            System.out.println(jsonArray.toString());
            List<EnterpriseInv> enterpriseInvs = Lists.newArrayList();
            for (Iterator iterator = jsonArray.iterator(); iterator.hasNext(); ) {
                JSONArray ja = (JSONArray) iterator.next();
                String enterpriseName = ja.getString(0);
                String investmenter = ja.getString(1);
                String invType = ja.getString(2);
                EnterpriseInv ei = new EnterpriseInv(enterpriseName, investmenter, invType);
                enterpriseInvs.add(ei);
            }
            Map<String, Map<String, List<EnterpriseInv>>> map = enterpriseInvs.stream()
                    .collect(
                            groupingBy(EnterpriseInv::getEnterpriseName
                                    , groupingBy(EnterpriseInv::getInvType)));
            List<EsEnterpriseInfo> esEnterpriseInfos = Lists.newArrayList();
            for (Map.Entry<String, Map<String, List<EnterpriseInv>>> entry : map.entrySet()) {
                String enterpriseName = entry.getKey();
                String enterpriseAbbr = getAbbreviation(enterpriseName);
                Map<String, List<EnterpriseInv>> val = entry.getValue();
                List<Investmenter> investmenters = Lists.newArrayList();
                for (Map.Entry<String, List<EnterpriseInv>> entry1 : val.entrySet()) {

                    String invType = entry1.getKey();
                    List<String> invList = entry1.getValue().stream()
                            .map(EnterpriseInv::getInvestmenter)
                            .collect(toList());
                    Investmenter investmenter = new Investmenter(invList, invType);
                    investmenters.add(investmenter);
                }

                EsEnterpriseInfo esEnterpriseInfo = new EsEnterpriseInfo(enterpriseName, enterpriseAbbr, investmenters);
//                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(esEnterpriseInfo));
//                System.out.println(jsonObject);
//                esService.save(SysConst.INDEX, SysConst.ENTERPRISEINFO, jsonObject);
                esEnterpriseInfos.add(esEnterpriseInfo);
            }
            esEnterpriseInfoService.batchAdd(esEnterpriseInfos);
        } catch(IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String getAbbreviation(String enterpriseName) {
        String result = null;
        if (enterpriseName.endsWith("有限责任公司")) {
            result = enterpriseName.substring(0, enterpriseName.lastIndexOf("有限责任公司"));
        } else if (enterpriseName.endsWith("股份有限公司")) {
            result = enterpriseName.substring(0, enterpriseName.lastIndexOf("股份有限公司"));
        } else if (enterpriseName.endsWith("有限公司")) {
            result = enterpriseName.substring(0, enterpriseName.lastIndexOf("有限公司"));
        } else {
            result = enterpriseName;
        }
        return result;
    }

}

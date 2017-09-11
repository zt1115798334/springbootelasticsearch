package com.zt.controller;

import com.zt.es.dao.EsArticleService;
import com.zt.es.entity.EsArticle;
import com.zt.mongo.entity.Article;
import com.zt.mongo.service.ArticleService;
import com.zt.utils.ClassReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("myController")
public class MyController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private EsArticleService esArticleService;

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
}

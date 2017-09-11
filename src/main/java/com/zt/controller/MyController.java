package com.zt.controller;

import com.zt.el.dao.ElArticleService;
import com.zt.el.entity.ElArticle;
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
    private ElArticleService elArticleService;

    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
        List<Article> articles = articleService.findListByPageRtList(1, 2);
        articles.forEach(article -> {
            ElArticle elArticle = new ElArticle();
            try {
                ClassReflection.reflectionAttr(article, elArticle);
                System.out.println(elArticle.toString());
                elArticleService.add(elArticle);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
        return articles.size();
    }
}

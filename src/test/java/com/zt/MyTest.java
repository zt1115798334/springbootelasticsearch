package com.zt;

import com.zt.constants.SysConst;
import com.zt.mongo.entity.Article;
import com.zt.mongo.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyTest extends BaseTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void test1() {
        Integer pageNumber = 1;
        Integer pageSize = SysConst.DEFAULT_BATCH_SIZE;
        List<Article> articles1 = articleService.findListByPageRtList(pageNumber, pageSize);
        System.out.println(articles1.size());
    }
}

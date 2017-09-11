package com.zt.es.service;

import com.zt.es.entity.EsArticle;

import java.util.List;

public interface EsArticleService {

    boolean add(EsArticle esArticle);

    boolean batchAdd(List<EsArticle> esArticles);
}

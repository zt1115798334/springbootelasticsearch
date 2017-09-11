package com.zt.es.dao.impl;

import com.zt.es.dao.EsArticleService;
import com.zt.es.entity.EsArticle;
import com.zt.es.repository.EsArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

@Service
public class EsArticleServiceImpl implements EsArticleService {

    @Autowired
    private EsArticleRepository esArticleRepository;

//    @Autowired
//    private ElasticsearchOperations es;
    @Override
    public boolean add(EsArticle esArticle) {
//        es.createIndex("ddd");
        esArticleRepository.save(esArticle);
        return true;
    }
}

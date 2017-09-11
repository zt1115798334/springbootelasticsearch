package com.zt.es.service.impl;

import com.zt.es.service.EsArticleService;
import com.zt.es.entity.EsArticle;
import com.zt.es.repository.EsArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsArticleServiceImpl implements EsArticleService {

    @Autowired
    private EsArticleRepository esArticleRepository;

    @Autowired
    private ElasticsearchOperations es;

    @Override
    public boolean add(EsArticle esArticle) {
        esArticleRepository.save(esArticle);
        return true;
    }

    @Override
    public boolean batchAdd(List<EsArticle> esArticles) {
        esArticleRepository.save(esArticles);
        return false;
    }
}

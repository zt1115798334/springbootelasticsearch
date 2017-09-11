package com.zt.es.repository;

import com.zt.es.entity.EsArticle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsArticleRepository extends ElasticsearchRepository<EsArticle, String> {

}

package com.zt.el.repository;

import com.zt.el.entity.ElArticle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElArticleRepository extends ElasticsearchRepository<ElArticle, String> {

}

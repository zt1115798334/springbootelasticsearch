package com.zt.es.repository;

import com.zt.es.entity.EsEnterpriseInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsEnterpriseInfoRepository extends ElasticsearchRepository<EsEnterpriseInfo, String> {
}

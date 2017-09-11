package com.zt.es.repository;

import com.zt.es.entity.EsEnterpriseInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsEnterpriseInfoRepository extends ElasticsearchRepository<EsEnterpriseInfo, String> {

    List<EsEnterpriseInfo> findByEnterpriseAbbrLike(String enterpriseAbbr);
}

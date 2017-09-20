package com.zt.es.service.impl;

import com.zt.constants.SysConst;
import com.zt.es.dao.EsEnterpriseInfoDao;
import com.zt.es.entity.EsEnterpriseInfo;
import com.zt.es.repository.EsEnterpriseInfoRepository;
import com.zt.es.service.EsEnterpriseInfoService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsEnterpriseInfoServiceImpl implements EsEnterpriseInfoService {

    @Autowired
    private EsEnterpriseInfoRepository esEnterpriseInfoRepository;

    @Autowired
    private EsEnterpriseInfoDao esEnterpriseInfoDao;

    @Override
    public boolean add(EsEnterpriseInfo esEnterpriseInfo) {
        esEnterpriseInfoRepository.save(esEnterpriseInfo);
        return false;
    }

    @Override
    public boolean batchAdd(List<EsEnterpriseInfo> esEnterpriseInfos) {
        esEnterpriseInfoRepository.save(esEnterpriseInfos);
        return false;
    }

    @Override
    public List<EsEnterpriseInfo> findByenterpriseAbbrLike(String enterpriseAbbr) {
        // Query
        FuzzyQueryBuilder fuzzy = QueryBuilders.fuzzyQuery("enterpriseAbbr", enterpriseAbbr);
        // 最大编辑距离
//        fuzzy.fuzziness(Fuzziness.ONE);
        // 公共前缀
//        fuzzy.prefixLength(0);
        WildcardQueryBuilder wildcard = QueryBuilders.wildcardQuery("enterpriseAbbr", "*" + enterpriseAbbr + "*");
        TermQueryBuilder termQuery = QueryBuilders.termQuery("enterpriseAbbr", enterpriseAbbr);
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("enterpriseAbbr", enterpriseAbbr);
        return  esEnterpriseInfoDao.findEsEnterpriseInfoByQuery(SysConst.INDEX, SysConst.ENTERPRISEINFO, fuzzy);
    }
}

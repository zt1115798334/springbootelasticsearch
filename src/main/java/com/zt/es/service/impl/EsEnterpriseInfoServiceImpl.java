package com.zt.es.service.impl;

import com.zt.es.entity.EsEnterpriseInfo;
import com.zt.es.repository.EsEnterpriseInfoRepository;
import com.zt.es.service.EsEnterpriseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsEnterpriseInfoServiceImpl implements EsEnterpriseInfoService {

    @Autowired
    private EsEnterpriseInfoRepository esEnterpriseInfoRepository;

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
        return esEnterpriseInfoRepository.findByEnterpriseAbbrLike(enterpriseAbbr);
    }
}

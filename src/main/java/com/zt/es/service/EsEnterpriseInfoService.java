package com.zt.es.service;

import com.zt.es.entity.EsEnterpriseInfo;

import java.util.List;

public interface EsEnterpriseInfoService {

    boolean add(EsEnterpriseInfo esEnterpriseInfo);

    boolean batchAdd(List<EsEnterpriseInfo> esEnterpriseInfos);
}

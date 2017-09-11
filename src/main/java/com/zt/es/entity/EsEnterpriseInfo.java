package com.zt.es.entity;

import com.zt.constants.SysConst;
import com.zt.entity.Investmenter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.List;

@Document(indexName = SysConst.INDEX, type = SysConst.ENTERPRISEINFO)
public class EsEnterpriseInfo implements Serializable {

    private static final long serialVersionUID = 9201034849892179274L;

    @Id
    private String id;
    private String enterpriseName;
    private String enterpriseAbbr;
    private List<Investmenter> investmenterList;

    public EsEnterpriseInfo() {
    }

    public EsEnterpriseInfo(String enterpriseName, String enterpriseAbbr, List<Investmenter> investmenterList) {
        this.enterpriseName = enterpriseName;
        this.enterpriseAbbr = enterpriseAbbr;
        this.investmenterList = investmenterList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAbbr() {
        return enterpriseAbbr;
    }

    public void setEnterpriseAbbr(String enterpriseAbbr) {
        this.enterpriseAbbr = enterpriseAbbr;
    }

    public List<Investmenter> getInvestmenterList() {
        return investmenterList;
    }

    public void setInvestmenterList(List<Investmenter> investmenterList) {
        this.investmenterList = investmenterList;
    }
}

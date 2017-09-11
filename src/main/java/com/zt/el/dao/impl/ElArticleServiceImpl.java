package com.zt.el.dao.impl;

import com.zt.el.dao.ElArticleService;
import com.zt.el.entity.ElArticle;
import com.zt.el.repository.ElArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElArticleServiceImpl implements ElArticleService {

    @Autowired
    private ElArticleRepository elArticleRepository;

    @Override
    public boolean add(ElArticle elArticle) {
        elArticleRepository.save(elArticle);
        return true;
    }
}

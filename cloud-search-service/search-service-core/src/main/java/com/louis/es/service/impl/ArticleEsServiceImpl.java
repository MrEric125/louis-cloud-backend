package com.louis.es.service.impl;

import com.louis.es.base.service.impl.BaseEsCRUDServiceImpl;
import com.louis.es.entity.Article;
import com.louis.es.repository.ArticleEsRepository;
import com.louis.es.service.ArticleEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/7/31
 * Description:
 */
@Service
public class ArticleEsServiceImpl extends BaseEsCRUDServiceImpl<Article,Long> implements ArticleEsService {

    @Autowired
    private ArticleEsRepository articleEsRepository;

    @Override
    public List<Article> searchAll() {
        Iterable<Article> all = articleEsRepository.findAll();
//        all;
        Page<Article> articlePage = (Page<Article>) all;
        return articlePage.getContent();
    }
}

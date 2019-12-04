package com.louis.search.controller;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.es.base.controller.BaseESController;
import com.louis.es.entity.Article;
import com.louis.es.service.ArticleEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/7/31
 * Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleESController extends BaseESController<Article, Long> {

    @Autowired
    private ArticleEsService getArticleService() {
       return (ArticleEsService) baseESService;
    }

    @GetMapping("/searchAll")
    public Wrapper searchAll() {
        List<Article> articles = getArticleService().searchAll();
        return handleResult(articles);

    }



}

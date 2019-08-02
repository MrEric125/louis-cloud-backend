package com.louis.es.service;

import com.louis.es.base.service.BaseEsCRUDService;
import com.louis.es.entity.Article;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/7/31
 * Description:
 */
public interface ArticleEsService extends BaseEsCRUDService<Article, Long> {

    List<Article> searchAll();


}

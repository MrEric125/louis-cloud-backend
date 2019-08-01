package com.louis.es.repository;

import com.louis.es.base.repository.BaseESRepository;
import com.louis.es.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * @author louis
 * <p>
 * Date: 2019/7/31
 * Description:
 */
@Repository
public interface ArticleEsRepository extends BaseESRepository<Article, Long> {

}

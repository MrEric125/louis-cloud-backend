package com.louis.product.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.product.entity.ProductCategory;
import org.springframework.stereotype.Repository;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@Repository
public interface PmsProductCategoryRepository extends BaseRepository<ProductCategory, Long> {

}

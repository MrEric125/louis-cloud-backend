package com.louis.product.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.product.entity.ProductCategory;
import org.springframework.stereotype.Repository;

/**
 * @author John·Louis
 * @date create in 2019/6/4
 * <p>
 * description:
 */
@Repository
public interface ProductCategoryRepository extends BaseRepository<ProductCategory, Long> {

}

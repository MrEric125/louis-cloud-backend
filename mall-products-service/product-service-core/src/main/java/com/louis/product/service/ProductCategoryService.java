package com.louis.product.service;

import com.louis.core.service.CRUDService;
import com.louis.product.entity.ProductCategory;
import com.louis.product.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

/**
 * @author John·Louis
 * @date create in 2019/6/4
 * <p>
 * description:
 */
@Service
public class ProductCategoryService extends CRUDService<ProductCategory, Long> {

    public ProductCategoryRepository getBaseRepository() {
        return (ProductCategoryRepository) baseRepository;
    }
}

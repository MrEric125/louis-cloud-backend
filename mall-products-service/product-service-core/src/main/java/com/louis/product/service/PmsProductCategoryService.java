package com.louis.product.service;

import com.louis.core.service.CRUDService;
import com.louis.product.entity.ProductCategory;
import com.louis.product.repository.PmsProductCategoryRepository;
import org.springframework.stereotype.Service;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@Service
public class PmsProductCategoryService extends CRUDService<ProductCategory, Long> {


    public PmsProductCategoryRepository getBaseRepository() {
        return (PmsProductCategoryRepository) baseRepository;
    }
}

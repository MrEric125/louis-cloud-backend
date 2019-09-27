package com.louis.product.service;

import com.louis.core.service.AbstractCRUDService;
import com.louis.product.entity.ProductCategory;
import com.louis.product.repository.PmsProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@Service
public class PmsProductCategoryService extends AbstractCRUDService<ProductCategory, Long> {


    private PmsProductCategoryRepository getBaseRepository() {
        return (PmsProductCategoryRepository) baseRepository;
    }


}

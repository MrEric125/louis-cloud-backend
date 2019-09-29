package com.louis.product.service;

import com.louis.core.service.AbstractCRUDService;
import com.louis.core.service.AbstractWebCRUDService;
import com.louis.product.api.dto.ProductCategoryDto;
import com.louis.product.entity.ProductCategory;
import com.louis.product.repository.PmsProductCategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@Service
public class PmsProductCategoryService extends AbstractWebCRUDService<ProductCategory, ProductCategoryDto, Long> {


    private PmsProductCategoryRepository getBaseRepository() {
        return (PmsProductCategoryRepository) baseRepository;
    }


    @Override
    public ProductCategory dtoToEntity(ProductCategoryDto dto) {
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(dto, productCategory);
        return productCategory;
    }

    @Override
    public ProductCategoryDto entityToDto(ProductCategory productCategory) {
        ProductCategoryDto dto = new ProductCategoryDto();
        BeanUtils.copyProperties(productCategory, dto);
        return dto;
    }
}

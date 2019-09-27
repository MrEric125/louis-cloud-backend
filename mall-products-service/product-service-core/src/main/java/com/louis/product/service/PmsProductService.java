package com.louis.product.service;

import com.louis.common.api.search.SearchOperator;
import com.louis.common.api.search.Searchable;
import com.louis.core.service.AbstractWebCRUDService;
import com.louis.product.api.dto.PmsProductDto;
import com.louis.product.entity.PmsProduct;
import com.louis.product.repository.PmsProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 */
@Service
public class PmsProductService extends AbstractWebCRUDService<PmsProduct, PmsProductDto,Long> {

    private PmsProductRepository getRepository() {
        return (PmsProductRepository)baseRepository;
    }

    public List<PmsProduct> findBySellerName(String sellerName) {

        Searchable searchable = Searchable.newSearchable();
        searchable.addSearchFilter("sellerName", SearchOperator.eq, sellerName);
        return getRepository().findAllList(searchable);

    }

    @Override
    public PmsProduct dtoToEntity(PmsProductDto dto) {
        PmsProduct product = new PmsProduct();
        BeanUtils.copyProperties(dto, product);
        return product;
    }

    @Override
    public PmsProductDto entityToDto(PmsProduct pmsProduct) {
        PmsProductDto pmsProductDto = new PmsProductDto();
        BeanUtils.copyProperties(pmsProduct, pmsProductDto);
        return pmsProductDto;
    }

}

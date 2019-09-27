package com.louis.product.api.feign.hystrix;

import com.louis.product.api.dto.PmsProductDto;
import com.louis.product.api.feign.PmsProductClientApi;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
public class ProductHystrix implements PmsProductClientApi {
    @Override
    public PmsProductDto findByProductId(Long id) {
        return null;
    }

    @Override
    public List<PmsProductDto> findBySellerName(String sellerName) {
        return null;
    }
}

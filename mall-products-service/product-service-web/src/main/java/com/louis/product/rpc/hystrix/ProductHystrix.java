package com.louis.product.rpc.hystrix;

import com.louis.product.api.dto.PmsProductDto;
import com.louis.product.api.feign.PmsProductClientApi;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
@Component
public class ProductHystrix implements PmsProductClientApi {
    @Override
    public PmsProductDto findByProductId(Long id) {
        throw new IllegalArgumentException("hystrix exception");
    }

    @Override
    public List<PmsProductDto> findBySellerName(String sellerName) {
        throw new IllegalArgumentException("hystrix exception");
    }
}

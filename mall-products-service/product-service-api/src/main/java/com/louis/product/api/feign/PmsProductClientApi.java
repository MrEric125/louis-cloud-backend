package com.louis.product.api.feign;

import com.louis.product.api.dto.PmsProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
@FeignClient(value = "product-server-A")
public interface PmsProductClientApi  {

    @GetMapping("product/findByProductId")
    PmsProductDto findByProductId(Long id);

    @GetMapping("product/findBySellerName")
    List<PmsProductDto> findBySellerName(String sellerName);


}

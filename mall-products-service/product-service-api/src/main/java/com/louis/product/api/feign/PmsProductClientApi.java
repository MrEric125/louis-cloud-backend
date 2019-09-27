package com.louis.product.api.feign;

import com.louis.product.api.dto.PmsProductDto;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
@FeignClient(" product-server-A")
public interface PmsProductClientApi  {


    PmsProductDto findByProductId(Long id);

    List<PmsProductDto> findBySellerName(String sellerName);


}

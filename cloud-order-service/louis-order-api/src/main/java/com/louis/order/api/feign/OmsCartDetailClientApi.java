package com.louis.order.api.feign;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.order.api.dto.OmsProductDto;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Eric
 * @date create in 2019/5/26
 */
@FeignClient(value = "louis-order-web")
public interface OmsCartDetailClientApi {

    WrapMapper addCartDetail(OmsProductDto productDto);









}

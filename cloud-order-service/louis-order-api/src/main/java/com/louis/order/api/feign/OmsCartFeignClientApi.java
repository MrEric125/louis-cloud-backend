package com.louis.order.api.feign;

import org.springframework.cloud.openfeign.FeignClient;



/**
 * @author Eric
 * @date create in 2019/5/12
 */
@FeignClient(value = "louis-order-web")
public interface OmsCartFeignClientApi  {

}

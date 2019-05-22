package com.louis.order.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/13
 * Description:
 */
@FeignClient(value = "louis-order-web")
public interface OmsOrderDetailFeignClientApi  {


}

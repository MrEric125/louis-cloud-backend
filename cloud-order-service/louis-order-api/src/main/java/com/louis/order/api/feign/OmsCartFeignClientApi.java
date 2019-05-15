package com.louis.order.api.feign;

import com.louis.common.feign.BaseFeignClient;
import com.louis.order.web.dto.OmsCartDto;
import com.louis.order.web.entity.OmsCart;
import org.springframework.cloud.openfeign.FeignClient;



/**
 * @author Eric
 * @date create in 2019/5/12
 */
@FeignClient(value = "louis-order-web")
public interface OmsCartFeignClientApi extends BaseFeignClient<OmsCart, OmsCartDto,Long> {

}

package com.louis.order.api.feign;

import com.louis.common.feign.BaseFeignClient;
import com.louis.order.web.dto.OmsOrderDto;
import com.louis.order.web.entity.OmsOrder;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/13
 * Description:
 */
@FeignClient(value = "louis-order-web")
public interface OmsOrderFeignClientApi extends BaseFeignClient<OmsOrder, OmsOrderDto, Long> {

}

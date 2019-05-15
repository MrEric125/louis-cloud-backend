package com.louis.order.api.feign;

import com.louis.common.feign.BaseFeignClient;
import com.louis.order.web.dto.OmsOrderDetailDto;
import com.louis.order.web.entity.OmsOrderDetail;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/13
 * Description:
 */
@FeignClient(value = "louis-order-web")
public interface OmsOrderDetailFeignClientApi extends BaseFeignClient<OmsOrderDetail, OmsOrderDetailDto, Long> {


}

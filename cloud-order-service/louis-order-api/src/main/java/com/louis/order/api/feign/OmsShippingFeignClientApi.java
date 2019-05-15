package com.louis.order.api.feign;

import com.louis.common.feign.BaseFeignClient;
import com.louis.order.web.dto.OmsShippingDto;
import com.louis.order.web.entity.OmsShipping;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/13
 * Description:
 */
public interface OmsShippingFeignClientApi extends BaseFeignClient<OmsShipping, OmsShippingDto, Long> {

}

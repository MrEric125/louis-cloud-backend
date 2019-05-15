package com.louis.order.api.feign;

import com.louis.common.feign.BaseFeignClient;
import com.louis.order.web.dto.OmsPayInfoDto;
import com.louis.order.web.entity.OmsProduct;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/13
 * Description:
 */
public interface OmsProductFeignClientApi extends BaseFeignClient<OmsProduct, OmsPayInfoDto, Long> {

}

package com.louis.order.api.feign;

import com.louis.common.feign.BaseFeignClient;
import com.louis.core.dto.BaseDto;
import com.louis.core.entity.BaseEntity;
import org.springframework.cloud.openfeign.FeignClient;

import java.io.Serializable;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@FeignClient(value = "louis-order-web")
public interface OmsCartFeignClientApi<E extends BaseEntity, D extends BaseDto<ID>, ID extends Serializable> extends BaseFeignClient<E, D, ID> {


}

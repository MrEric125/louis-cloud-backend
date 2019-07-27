package com.louis.order.api.feign.hystrix;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.api.feign.OmsOrderClientApi;
import org.springframework.stereotype.Component;

/**
 * @author John·Louis
 * @date create in 2019/7/28
 * description:
 */
@Component
public class OmsOrderHystrix implements OmsOrderClientApi {


    @Override
    public Wrapper<OmsOrderDto> createOrder(OmsOrderDto orderDto) {
        return null;
    }

    @Override
    public OmsOrderDto modifyOrderStatus() {
        return null;
    }

    @Override
    public void confirmOrder() {


    }

    @Override
    public Wrapper<OmsOrderDto> findByOrderId(long orderId) {
        OmsOrderDto dto = new OmsOrderDto();
        dto.setUserAddr("测试Hystrix");
        return WrapMapper.wrap(dto);
    }

    @Override
    public void deleteOrder(long userId, long orderId) {

    }
}

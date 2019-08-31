package com.louis.order.web.rpc.hystrix;

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
    public OmsOrderDto createOrder(OmsOrderDto orderDto) {
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
    public OmsOrderDto findByOrderId(long orderId) {
//        OmsOrderDto dto = new OmsOrderDto();
//        dto.setUserAddr("测试Hystrix");
//        return dto;
        return null;
    }

    @Override
    public void deleteOrder(long userId, long orderId) {

    }
}

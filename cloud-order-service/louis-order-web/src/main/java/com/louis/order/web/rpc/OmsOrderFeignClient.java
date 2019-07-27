package com.louis.order.web.rpc;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.api.feign.OmsOrderClientApi;
import com.louis.order.entity.OmsOrder;
import com.louis.order.service.OmsOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/15
 * Description:
 */
@RestController
@Api("order feign clientAPI")
@RequestMapping("/order/feign")
public class OmsOrderFeignClient extends BaseController implements OmsOrderClientApi {


    @Autowired
    private OmsOrderService orderService;


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
        OmsOrder omsOrder = orderService.findById(orderId);
        OmsOrderDto omsOrderDto = orderService.entityToDto(omsOrder);
        return handleResult(omsOrderDto);

    }

    @Override
    public void deleteOrder(long userId, long orderId) {

    }
}

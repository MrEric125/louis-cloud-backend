package com.louis.order.web.rpc;

import com.louis.common.web.web.BaseController;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.api.feign.OmsOrderClientApi;
import com.louis.order.entity.OmsOrder;
import com.louis.order.service.OmsOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/15
 * Description:
 * 实现类中不能使用 {@link @RequestMapping},否则，通过Feign路由过来的地址，就会和实现类中的地址对不上，
 */
@RestController
@Api("order feign clientAPI")
public class OmsOrderFeignClient extends BaseController implements OmsOrderClientApi {


    @Autowired
    private OmsOrderService orderService;


    @Override
    public OmsOrderDto createOrder(OmsOrderDto orderDto) {
        OmsOrder entity = orderService.createEntity(orderDto);
        return orderService.entityToDto(entity);
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
        OmsOrder omsOrder = orderService.findById(orderId);
        return  orderService.entityToDto(omsOrder);
    }

    @Override
    public void deleteOrder(long userId, long orderId) {

    }
}

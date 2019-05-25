package com.louis.order.api.feign;

import com.louis.order.api.dto.OmsOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/13
 * Description:
 */
@FeignClient(value = "louis-order-web")
public interface OmsOrderClientApi {


    @PostMapping("/createOrder")
    OmsOrderDto createOrder(@RequestBody OmsOrderDto orderDto);

    @PostMapping("/modifyOrder")
    OmsOrderDto modifyOrderStatus();

    @PostMapping("/confirm_order")
    void confirmOrder();


    @PostMapping("/delete_order")
    void deleteOrder(@RequestParam("userId") long userId, @RequestParam("orderId") long orderId);



}

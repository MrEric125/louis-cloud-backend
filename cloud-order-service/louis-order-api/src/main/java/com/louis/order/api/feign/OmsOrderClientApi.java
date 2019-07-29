package com.louis.order.api.feign;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.api.feign.hystrix.OmsOrderHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/13
 * Description:
 */
@FeignClient(value = "louis-order-web",fallback = OmsOrderHystrix.class)
public interface OmsOrderClientApi {


    @PostMapping("/createOrder")
    Wrapper<OmsOrderDto> createOrder(@RequestBody OmsOrderDto orderDto);

    @PostMapping("/modifyOrder")
    OmsOrderDto modifyOrderStatus();

    @PostMapping("/confirm_order")
    void confirmOrder();

    @GetMapping("findByOrderId/{orderId}")
    Wrapper<OmsOrderDto> findByOrderId(@PathVariable("orderId") long orderId);

    @PostMapping("/delete_order")
    void deleteOrder(@RequestParam("userId") long userId, @RequestParam("orderId") long orderId);



}

package com.louis.order.web.controller;


import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.WebCRUDController;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.service.OmsOrderService;
import com.louis.order.entity.OmsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/7
 * Description:
 */
@Api(tags = "orderController",description = "订单服务相关操作")
@RestController
@Slf4j
public class OrderController extends WebCRUDController<OmsOrder, OmsOrderDto,Long > {


    private final OmsOrderService orderService;

    @Autowired
    public OrderController(OmsOrderService orderService) {
        this.orderService = orderService;
    }


    /**
     * 新增订单，新增完成->调用支付系统->调用库存系统->调用积分系统
     * @return
     */



    @ApiOperation("通过id查找")
    @GetMapping("/findById/{id}")
    public Wrapper findOrderById(@PathVariable("id") Long id)  {
        OmsOrder omsOrder = orderService.findById(id);
        return handleResult(omsOrder);
    }




}

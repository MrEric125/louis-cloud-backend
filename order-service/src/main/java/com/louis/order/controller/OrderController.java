package com.louis.order.controller;

import com.exception.NotFoundEntityException;
import com.louis.order.common.service.OrderService;
import com.louis.order.entity.Order;
import com.louis.response.ResponseData;
import com.louis.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 80003996
 * <p>
 * Date: 2019/5/7
 * Description:
 */
@Api(tags = "orderController",description = "订单服务相关操作")
@RestController
public class OrderController extends BaseController<Order,Long > {


    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    /**
     * 新增订单，新增完成->调用支付系统->调用库存系统->调用积分系统
     * @return
     */
    @ApiOperation("新增订单")
    @PostMapping("/add")
    public ResponseData add() {
        return new ResponseData("success");
    }

    @ApiOperation("删除订单")
    @GetMapping("/delete")
    public ResponseData delete() {

        return new ResponseData("success");
    }
    @ApiOperation("编辑订单")
    @GetMapping("/edit")
    public ResponseData edit() {
        return new ResponseData("success");
    }



    @ApiOperation("通过id查找")
    @GetMapping("/findById/{id}")
    public ResponseData findOrderById(@PathVariable("id") Long id) throws NotFoundEntityException {
        Order byId = orderService.findById(id);
        return new ResponseData("success", byId);
    }


}

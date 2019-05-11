package com.louis.controller;

import com.exception.NotFoundEntityException;
import com.louis.common.service.OrderService;
import com.louis.entity.Order;
import com.louis.response.ResponseData;
import com.louis.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 80003996
 * <p>
 * Date: 2019/5/7
 * Description:
 */
@RestController
@RequestMapping("/order")
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
    @RequestMapping("/add")
    public ResponseData add() {
        return new ResponseData("success");
    }

    @RequestMapping("/delete")
    public ResponseData delete() {

        return new ResponseData("success");
    }
    @RequestMapping("/edit")
    public ResponseData edit() {
        return new ResponseData("success");
    }



    @RequestMapping("/findById/{id}")
    public ResponseData findOrderById(@PathVariable("id") Long id) throws NotFoundEntityException {
        Order byId = orderService.findById(id);
        return new ResponseData("success", byId);
    }


}

package com.louis.controller;

import com.louis.common.response.ResponseData;
import com.louis.entity.Order;
import com.louis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author 80003996
 * <p>
 * Date: 2019/5/7
 * Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
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

    @RequestMapping("/all")
    public ResponseData findAllOrder() {
        List<Order> all = orderService.findAll();
       return new ResponseData("success", all);
    }


}

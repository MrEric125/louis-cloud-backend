package com.louis.order.web.controller;


import com.louis.common.api.response.ResponseData;
import com.louis.common.web.web.CRUDController;
import com.louis.order.api.service.OmsOrderService;
import com.louis.order.web.entity.OmsOrder;
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
public class OrderController extends CRUDController<OmsOrder,Long > {


    private final OmsOrderService orderService;

    @Autowired
    public OrderController(OmsOrderService orderService) {
        this.orderService = orderService;
    }


    /**
     * 新增订单，新增完成->调用支付系统->调用库存系统->调用积分系统
     * @return
     */
    @ApiOperation("新增订单")
    @PostMapping("/add")
    public ResponseData add(OmsOrder order) {
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
    public ResponseData findOrderById(@PathVariable("id") Long id)  {
        OmsOrder byId = orderService.findById(id);
        return new ResponseData("success", byId);
    }


}

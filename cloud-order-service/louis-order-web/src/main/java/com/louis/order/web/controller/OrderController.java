package com.louis.order.web.controller;


import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.WebCRUDController;
import com.louis.common.web.constant.SearchHookConstant;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.service.OmsOrderService;
import com.louis.order.entity.OmsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/7
 * Description:
 */
@Api(tags = "orderController",description = "")
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController extends WebCRUDController<OmsOrder, OmsOrderDto,Long > {

    private final OmsOrderService orderService;

    @Autowired
    SearchHookConstant searchHookConstant;

    @Autowired
    public OrderController(OmsOrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation("通过id查找")
    @GetMapping("/findById/{id}")
    public Wrapper findOrderById(@PathVariable("id") Long id)  {
        OmsOrder omsOrder = orderService.findById(id);
        return handleResult(omsOrder);
    }

    /**
     * // TODO: 2019/8/30  后期需要加上权限认证功能
     *
     * @return
     */
    @PostMapping("/edit")
    public Wrapper editOrder(@RequestBody OmsOrderDto dto) {
        orderService.preHandle(dto, searchHookConstant.EDIT);
        OmsOrder omsOrder = orderService.dtoToEntity(dto);
        orderService.save(omsOrder);
        orderService.postHandler(dto, searchHookConstant.EDIT);
        return handlerNullResult();
    }


}

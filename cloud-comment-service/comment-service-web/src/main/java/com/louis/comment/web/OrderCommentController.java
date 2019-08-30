package com.louis.comment.web;

import com.louis.comment.dto.OrderCommentDto;
import com.louis.comment.entity.OrderComment;
import com.louis.comment.service.impl.OrderCommentServiceImpl;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.constant.SearchHookConstant;
import com.louis.common.web.web.WebCRUDController;
import com.louis.exception.ErrorCodeEnum;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.api.feign.OmsOrderClientApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/18
 */
@RestController
@RequestMapping(value = "/comment",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderCommentController extends WebCRUDController<OrderComment,OrderCommentDto, Long> {
    @Autowired
    private OrderCommentServiceImpl orderCommentService;

    @Autowired
    private OmsOrderClientApi orderClientApi;

    @Autowired
    SearchHookConstant hookConstant;


    /**
     * 需要校验orderNo是否已经存在
     * @param dto
     * @return
     */
    @Override
    public Wrapper add(OrderCommentDto dto) {

            //调用订单模块，校验订单是否存在
            OmsOrderDto omsOrderDto = orderClientApi.findByOrderId(dto.getOrderId());
            if (omsOrderDto != null) {
                return super.add(dto);
            }
            return WrapMapper.error(ErrorCodeEnum.OMS99990987.code(), ErrorCodeEnum.OMS99990987.msg());
    }

    /**
     * 查询的时候不需要调用订单服务校验订单是否存在
     * @param orderId
     * @param userId
     * @return
     */
    @GetMapping("/{orderId}/{userId}")
    public Wrapper getCommentByOrderId(@PathVariable("orderId") long orderId,
                                            @PathVariable("userId") long userId) {
        OmsOrderDto omsOrderDto = orderClientApi.findByOrderId(orderId);
        if (omsOrderDto == null) {

        }
        OrderComment orderComment = orderCommentService.findByUserIdAndOrderId(userId, orderId);
        // TODO: 2019/8/29 这个地方主要就是组装数据，也可能会将订单信息和评论信息组装在一起
        OrderCommentDto dto = new OrderCommentDto();
        if (orderComment != null) {
            BeanUtils.copyProperties(orderComment, dto);
        }

        return handleResult(dto);
    }

    @GetMapping("/{orderId}")
    public Wrapper getByOrderId(@PathVariable("orderId") long orderId) {
        List<OrderComment> orderComments = orderCommentService.findByOrderId(orderId);
        List<OrderCommentDto> orderCommentDtos = orderCommentService.entitiesToDtos(orderComments);
        return handleResult(orderCommentDtos);
    }
    public Wrapper getByTypeId() {
        return handlerNullResult();
    }

}

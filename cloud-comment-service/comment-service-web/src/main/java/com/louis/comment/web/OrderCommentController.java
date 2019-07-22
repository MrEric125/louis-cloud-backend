package com.louis.comment.web;

import com.louis.comment.dto.OrderCommentDto;
import com.louis.comment.entity.OrderComment;
import com.louis.comment.service.OrderCommentService;
import com.louis.common.web.web.WebCRUDController;
import com.louis.core.response.ResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * @date create in 2019/5/18
 */
@RestController
@RequestMapping("/comment")
public class OrderCommentController extends WebCRUDController<OrderComment,OrderCommentDto, Long> {
    @Autowired
    private OrderCommentService orderCommentService;



    @RequestMapping("/{orderId}/{userId}")
    public ResponseData getCommentByOrderId(@PathVariable("orderId") long orderId,
                                            @PathVariable("userId") long userId) {
        OrderComment orderComment = orderCommentService.findByUserIdAndOrderId(userId, orderId);
        OrderCommentDto dto = new OrderCommentDto();
        BeanUtils.copyProperties(orderComment, dto);
        return new ResponseData(dto);
    }



}

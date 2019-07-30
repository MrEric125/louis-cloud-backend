package com.louis.comment.web;

import com.louis.comment.dto.OrderCommentDto;
import com.louis.comment.entity.OrderComment;
import com.louis.comment.service.OrderCommentService;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.WebCRUDController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/18
 */
@RestController
@RequestMapping(value = "/comment",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderCommentController extends WebCRUDController<OrderComment,OrderCommentDto, Long> {
    @Autowired
    private OrderCommentService orderCommentService;



    @GetMapping("/{orderId}/{userId}")
    public Wrapper getCommentByOrderId(@PathVariable("orderId") long orderId,
                                            @PathVariable("userId") long userId) {
        OrderComment orderComment = orderCommentService.findByUserIdAndOrderId(userId, orderId);
        OrderCommentDto dto = new OrderCommentDto();
        if (orderComment != null) {
            BeanUtils.copyProperties(orderComment, dto);
        }
        return handleResult(dto);
    }

    @GetMapping("/{orderId}")
    public Wrapper getByOrderId(@PathVariable("orderId") long orderId) {
        List<OrderComment> orderComments = orderCommentService.findByOrderId(orderId);
        return handleResult(orderComments);
    }



}

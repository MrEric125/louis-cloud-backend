package com.louis.comment.service;

import com.louis.comment.dto.OrderCommentDto;
import com.louis.comment.entity.OrderComment;
import com.louis.core.service.ICRUDService;
import com.louis.core.service.IWebService;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/18
 */
public interface OrderCommentService extends IWebService<OrderComment, OrderCommentDto, Long> {


    List<OrderComment> findByOrderId(long orderId);

    OrderComment findByUserIdAndOrderId(long orderId, long userId);






}

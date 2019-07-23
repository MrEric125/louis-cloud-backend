package com.louis.comment.service;

import com.louis.comment.entity.OrderComment;
import com.louis.core.service.ICRUDService;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/18
 */
public interface OrderCommentService extends ICRUDService<OrderComment, Long> {


    List<OrderComment> findByOrderId(long orderId);

    OrderComment findByUserIdAndOrderId(long orderId, long userId);



}

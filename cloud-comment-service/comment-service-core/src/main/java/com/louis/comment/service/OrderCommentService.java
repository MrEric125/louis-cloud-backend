package com.louis.comment.service;

import com.louis.comment.entity.OrderComment;
import com.louis.comment.repository.OrderCommentRepository;
import com.louis.core.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author John·Louis
 * @date create in 2019/5/18
 */
@Service
public class OrderCommentService extends CRUDService<OrderComment, Long> {


    @Autowired
    private OrderCommentRepository orderCommentRepository;

    public OrderComment findByUserIdAndOrderId(long orderId, long userId) {
        return orderCommentRepository.findByOrderIdAndCommentUserId(orderId, userId);
    }
}

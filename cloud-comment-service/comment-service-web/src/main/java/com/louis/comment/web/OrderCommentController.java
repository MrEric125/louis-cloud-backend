package com.louis.comment.web;

import com.louis.comment.entity.OrderComment;
import com.louis.comment.service.OrderCommentService;
import com.louis.common.web.web.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@RestController
public class OrderCommentController extends CRUDController<OrderComment, Long> {
    @Autowired
    private OrderCommentService orderCommentService;

}

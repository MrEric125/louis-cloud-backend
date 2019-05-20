package com.louis.comment.repository;

import com.louis.comment.entity.OrderComment;
import com.louis.common.api.repository.BaseRepository;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
public interface OrderCommentRepository extends BaseRepository<OrderComment, Long> {


    OrderComment findByOrderIdAndCommentUserId(long orderId, long userId);

    List<OrderComment> findByGoodsId(long goods);



}
package com.louis.comment.feignclient;

import com.louis.comment.api.CommentFeignClientApi;
import com.louis.comment.dto.OrderCommentDto;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/5/22
 */
public class CommentFeignClient implements CommentFeignClientApi {

    @Override
    public List<OrderCommentDto> findByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<OrderCommentDto> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<OrderCommentDto> findByGoodsId(Long goodsId) {
        return null;
    }

    @Override
    public OrderCommentDto findByOrderIdAndUserId(Long orderId, Long userId) {
        return null;
    }
}

package com.louis.comment.api;

import com.louis.comment.dto.OrderCommentDto;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/5/22
 */
@FeignClient(value = "comment-server-A")
public interface CommentFeignClientApi  {


    List<OrderCommentDto> findByOrderId(Long orderId);

    List<OrderCommentDto> findByUserId(Long userId);


    List<OrderCommentDto> findByGoodsId(Long goodsId);


    /**
     * 通过订单号和用户号查询评论内容
     * @param orderId
     * @param userId
     * @return
     */
    OrderCommentDto findByOrderIdAndUserId(Long orderId, Long userId);






}

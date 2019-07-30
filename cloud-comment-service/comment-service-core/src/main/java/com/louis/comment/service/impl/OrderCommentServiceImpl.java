package com.louis.comment.service.impl;

import com.louis.comment.dto.OrderCommentDto;
import com.louis.comment.entity.OrderComment;
import com.louis.comment.repository.OrderCommentRepository;
import com.louis.comment.service.OrderCommentService;
import com.louis.core.service.WebCRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/7/23
 * description:
 */
@Service
public class OrderCommentServiceImpl  extends WebCRUDService<OrderComment, OrderCommentDto, Long> implements OrderCommentService {

    @Autowired
    private OrderCommentRepository orderCommentRepository;

    public OrderComment findByUserIdAndOrderId(long userId, long orderId) {
        return orderCommentRepository.findByOrderIdAndCommentUserId(orderId, userId);
    }

    @Cacheable(cacheNames = "comment_cache",key = "#id")
    @Override
    public OrderComment findById(Long id) {
        return super.findById(id);
    }

    @Override
    @Cacheable(cacheNames = "comment_cache",keyGenerator = "keyGenerator")
    public List<OrderComment> findByOrderId(long orderId) {
        return orderCommentRepository.findAllByOrderId(orderId);

    }

    @Override
    public OrderComment dtoToEntity(OrderCommentDto dto) {
        OrderComment orderComment = new OrderComment();
        BeanUtils.copyProperties(dto, orderComment);
        return orderComment;
    }

    @Override
    public OrderCommentDto entityToDto(OrderComment orderComment) {
        OrderCommentDto dto = new OrderCommentDto();
        BeanUtils.copyProperties(orderComment, dto);
        return dto;
    }


}

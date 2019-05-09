package com.louis.service;

import com.louis.common.service.BaseService;
import com.louis.entity.Order;
import com.louis.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Service
public class OrderService extends BaseService<Order,String> {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findByUserId(String userId) {

        return orderRepository.findAllByOrderUser(userId);

    }
}

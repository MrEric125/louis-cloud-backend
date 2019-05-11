package com.louis.common.service;

import com.louis.entity.Order;
import com.louis.common.repository.OrderRepository;
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
public class OrderService extends BaseService<Order,Long> {


    @Autowired
    OrderRepository orderRepository;

    public List<Order> findByUserId(String userId) {
        Order order = new Order();
        order.getId();

        return orderRepository.findAllByOrderUser(userId);

    }
}

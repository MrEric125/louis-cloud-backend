package com.louis.order.common.repository;

import com.louis.common.repository.BaseRepository;
import com.louis.order.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Repository
public interface OrderRepository extends BaseRepository<Order,Long> {


    List<Order> findAllByOrderUser(String userId);


}

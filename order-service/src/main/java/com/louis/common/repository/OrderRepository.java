package com.louis.common.repository;

import com.louis.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,String> {


    List<Order> findAllByOrderUser(String userId);
}

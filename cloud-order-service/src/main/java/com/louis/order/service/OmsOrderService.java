package com.louis.order.service;

import com.louis.order.entity.OmsOrder;
import com.louis.order.repository.OmsOrderRepository;
import com.louis.service.CRUDService;
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
public class OmsOrderService extends CRUDService<OmsOrder,Long> {


    @Autowired
    OmsOrderRepository omsOrderRepository;

    public List<OmsOrder> findByUserId(String userId) {


        return omsOrderRepository.findAllByOrderUser(userId);

    }
}

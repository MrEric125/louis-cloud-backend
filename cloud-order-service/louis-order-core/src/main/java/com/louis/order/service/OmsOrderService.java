package com.louis.order.service;


import com.louis.core.service.CRUDService;
import com.louis.order.entity.OmsOrder;
import com.louis.order.repository.OmsOrderRepository;
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

    public OmsOrderRepository getRepository() {
        return (OmsOrderRepository)baseRepository;
    }

    public List<OmsOrder> findByUserId(Long userId) {


        return omsOrderRepository.findAllByUserId(userId);

    }
}

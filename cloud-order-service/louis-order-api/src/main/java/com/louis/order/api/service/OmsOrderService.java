package com.louis.order.api.service;


import com.louis.common.api.service.CRUDService;
import com.louis.order.api.repository.OmsOrderRepository;
import com.louis.order.web.entity.OmsOrder;
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

    public List<OmsOrder> findByUserId(Long userId) {


        return omsOrderRepository.findAllByUserId(userId);

    }
}

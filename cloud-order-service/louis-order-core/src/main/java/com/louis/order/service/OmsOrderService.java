package com.louis.order.service;


import com.louis.core.service.CRUDService;
import com.louis.order.entity.OmsOrder;
import com.louis.order.repository.OmsOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Service
@Slf4j
public class OmsOrderService extends CRUDService<OmsOrder,Long> {




    public OmsOrderRepository getRepository() {
        return (OmsOrderRepository)baseRepository;
    }

    public List<OmsOrder> findByUserId(Long userId) {


        return getRepository().findAllByUserId(userId);

    }
}

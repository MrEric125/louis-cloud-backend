package com.louis.order.service;

import com.louis.core.service.CRUDService;
import com.louis.order.entity.OmsOrderLogistics;
import com.louis.order.repository.OmsOrderLogisticsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author John·Louis
 * @date create in 2019/5/31
 * <p>
 * description:
 */
@Service
@Slf4j
public class OmsOrderLogisticsService extends CRUDService<OmsOrderLogistics, Long> {
    public OmsOrderLogisticsRepository getRepository() {


        return (OmsOrderLogisticsRepository)baseRepository;
    }
}

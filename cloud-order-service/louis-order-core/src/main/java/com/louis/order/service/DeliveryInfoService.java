package com.louis.order.service;

import com.louis.core.service.AbstractCRUDService;
import com.louis.order.entity.DeliveryInformation;
import com.louis.order.repository.DeliveryInfoRepository;
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
public class DeliveryInfoService extends AbstractCRUDService<DeliveryInformation, Long> {
    public DeliveryInfoRepository getRepository() {
        return (DeliveryInfoRepository)baseRepository;
    }
}

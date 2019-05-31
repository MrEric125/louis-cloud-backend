package com.louis.order.service;

import com.louis.core.service.CRUDService;
import com.louis.order.entity.OmsPayInfo;
import com.louis.order.repository.OmsPayInfoRepository;
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
public class OmsPayInfoService extends CRUDService<OmsPayInfo,Long> {
    public OmsPayInfoRepository getRepository() {
        return (OmsPayInfoRepository) baseRepository;
    }
}

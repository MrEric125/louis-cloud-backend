package com.louis.order.service;

import com.louis.core.service.AbstractCRUDService;
import com.louis.order.entity.OmsCartDetail;
import com.louis.order.repository.OmsCartDetailRepository;
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
public class OmsCartDetailService extends AbstractCRUDService<OmsCartDetail, Long> {
    public OmsCartDetailRepository getRepository() {
        return (OmsCartDetailRepository)baseRepository;
    }
}

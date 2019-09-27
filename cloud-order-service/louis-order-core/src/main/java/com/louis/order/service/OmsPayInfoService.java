package com.louis.order.service;

import com.louis.core.service.AbstractWebCRUDService;
import com.louis.order.api.dto.OmsPayInfoDto;
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
public class OmsPayInfoService extends AbstractWebCRUDService<OmsPayInfo, OmsPayInfoDto,Long> {



    public OmsPayInfoRepository getRepository() {
        return (OmsPayInfoRepository) baseRepository;
    }

    public int queryPaymentWay() {
        return 0;
    }

    public OmsPayInfo surePay(OmsPayInfoDto dto) {


        return dtoToEntity(dto);
    }

    @Override
    public OmsPayInfo dtoToEntity(OmsPayInfoDto dto) {
        return null;
    }

    @Override
    public OmsPayInfoDto entityToDto(OmsPayInfo omsPayInfo) {
        return null;
    }
}

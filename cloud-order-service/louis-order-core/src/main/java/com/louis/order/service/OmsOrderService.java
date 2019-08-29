package com.louis.order.service;


import com.google.common.base.Preconditions;
import com.louis.core.service.WebCRUDService;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.entity.OmsOrder;
import com.louis.order.repository.OmsOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Service
@Slf4j
public class OmsOrderService extends WebCRUDService<OmsOrder, OmsOrderDto,Long> {




    public OmsOrderRepository getRepository() {
        return (OmsOrderRepository)baseRepository;
    }

    public List<OmsOrder> findByUserId(Long userId) {
        return getRepository().findAllByUserId(userId);
    }


    @Override
    public void checkParams(OmsOrderDto dto) {
        Preconditions.checkNotNull(dto.getUserAddr(), "收货地址不能为空");
        Preconditions.checkNotNull(dto.getUserAddr(), "用户id不能为空");




    }

    @Override
    public OmsOrder dtoToEntity(OmsOrderDto dto) {
        OmsOrder order = new OmsOrder();
        BeanUtils.copyProperties(dto, order);
        order.setOrderCode(generateOrderCode());
        return order;
    }

    @Override
    public OmsOrderDto entityToDto(OmsOrder omsOrder) {
        OmsOrderDto dto = new OmsOrderDto();
        BeanUtils.copyProperties(omsOrder, dto);
        return dto;
    }
    private String generateOrderCode() {
        return UUID.randomUUID().toString();
    }
}

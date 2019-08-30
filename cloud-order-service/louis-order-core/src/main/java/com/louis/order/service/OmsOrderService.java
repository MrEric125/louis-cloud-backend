package com.louis.order.service;


import com.google.common.base.Preconditions;
import com.louis.core.service.AbstractWebCRUDService;
import com.louis.core.utils.StringGenerateUtil;
import com.louis.order.api.dto.OmsOrderDto;
import com.louis.order.entity.OmsOrder;
import com.louis.order.repository.OmsOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Louis
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Service
@Slf4j
public class OmsOrderService extends AbstractWebCRUDService<OmsOrder, OmsOrderDto,Long> {

    @Value("${order.length}")
    private int orderLength;

    private static final String ORDER_PRE = "O";

    @Autowired
    OrderStatusService orderStatusService;

    public OmsOrderRepository getRepository() {
        return (OmsOrderRepository)baseRepository;
    }

    public List<OmsOrder> findByUserId(Long userId) {
        return getRepository().findAllByUserId(userId);
    }


    private void checkParams(OmsOrderDto dto) {
        Preconditions.checkNotNull(dto.getUserAddr(), "收货地址不能为空");
        Preconditions.checkNotNull(dto.getUserAddr(), "用户id不能为空");
        Preconditions.checkNotNull(dto.getTotalCost(), "总费用不能为空");
    }

    @Override
    public <T> void preHandle(T t, int hook) {
        checkParams((OmsOrderDto) t);

    }

    @Override
    public <T> void postHandler(T t, int hook) {
        super.postHandler(t, hook);
    }

    @Override
    public OmsOrder dtoToEntity(OmsOrderDto dto) {
        OmsOrder order = OmsOrder.builder()
                .orderCode(StringGenerateUtil.generateCode(ORDER_PRE,new Date(), orderLength == 0 ? 30 : orderLength))
                .beganTime(new Date())
                .build();
        BeanUtils.copyProperties(dto, order);
        order.setOrderStatus(orderStatusService.createOrderStatus(order));
        order.setUpdateInfo(getLoginAuthDto());
        return order;
    }

    @Override
    public OmsOrderDto entityToDto(OmsOrder omsOrder) {
        OmsOrderDto dto = new OmsOrderDto();
        BeanUtils.copyProperties(omsOrder, dto);
        return dto;
    }

}

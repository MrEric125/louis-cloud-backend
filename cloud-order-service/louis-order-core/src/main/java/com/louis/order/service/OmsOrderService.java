package com.louis.order.service;


import com.google.common.base.Preconditions;
import com.louis.core.service.AbstractWebCRUDService;
import com.louis.core.utils.DateUtils;
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
import java.util.UUID;

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
    public void postHandle(OmsOrderDto dto) {
        checkParams(dto);
    }

    @Override
    public void afterHandler(OmsOrder order) {

    }

    @Override
    public OmsOrder dtoToEntity(OmsOrderDto dto) {
        OmsOrder order = OmsOrder.builder()
                .orderCode(generateOrderCode(new Date(), orderLength == 0 ? 30 : orderLength))
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

    /**
     * 生成订单号的工具类
     * @param date
     * @param num
     * @return
     */
    private static String generateOrderCode(Date date,int num) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return DateUtils.DateToStr(DateUtils.YYYYMMDDHHMMSSSSS, date)
                .concat(uuid.substring(0, num - DateUtils.YYYYMMDDHHMMSSSSS.length()));
    }


}

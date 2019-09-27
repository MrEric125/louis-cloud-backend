package com.louis.order.service;

import com.louis.order.entity.OmsOrder;
import com.louis.order.enums.OrderStatusEnum;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author louis
 * <p>
 * Date: 2019/8/29
 * Description:
 * 
 * // TODO: 2019/8/29 先实现一个比较简单的订单状态判断器 
 *
 */
@Service
public class OrderStatusService {

    public int createOrderStatus(OmsOrder order) {
        int status;
        //交易关闭或者订单取消
        if (Objects.nonNull(order.getCloseTime())) {
            if (order.getTransactionNumber() != null) {
                status = OrderStatusEnum.Closed.code();
            } else {
                status = OrderStatusEnum.Cancel.code();
            }
        } else {
            if (order.getPayment() != null) {
                if (order.getDeliverCode() != null) {
                    status = OrderStatusEnum.Delivered.code();
                } else {
                    status = OrderStatusEnum.Payed.code();
                }
            } else {
                status = OrderStatusEnum.UnPay.code();
            }
        }
        return status;


    }



}

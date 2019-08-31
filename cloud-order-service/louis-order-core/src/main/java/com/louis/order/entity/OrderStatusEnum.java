package com.louis.order.entity;

/**
 * @author louis
 * <p>
 * Date: 2019/8/29
 * Description:
 * "订单状态",notes ="订单状态:0-已取消-10-未付款, 20-已付款, 40-已发货, 50-交易成功, 60-交易关闭"
 */
public enum OrderStatusEnum {

    Success(50),Cancel(0),UnPay(10),Payed(20),Delivered(40),Closed(60);


    private int code;

    public int code() {
        return this.code;
    }

    OrderStatusEnum( int code) {
        this.code = code;
    }
}

package com.louis.order.enums;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
public enum PayInfoEnum {

    AliPay(10),WeiPay(20), MyPay(30);


    private int code;

    public int code() {
        return this.code;
    }

    PayInfoEnum( int code) {
        this.code = code;
    }
}

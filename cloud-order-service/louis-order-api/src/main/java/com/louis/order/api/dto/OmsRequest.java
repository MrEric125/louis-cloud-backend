package com.louis.order.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/5/24
 *
 * Oms系统在接收前段传入过来的参数
 */
@Setter
@Getter
public class OmsRequest {

    private long cartId;

    private long userId;

    private long productId;

    private int num;

}

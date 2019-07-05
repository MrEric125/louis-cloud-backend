package com.louis.order.api.dto;

import com.louis.common.api.BaseRequest;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author John·Louis
 * @date create in 2019/5/24
 *
 * Oms系统在接收前段传入过来的参数
 */
@Setter
@Getter
@ApiModel
public class OmsRequest extends BaseRequest {

    private long cartId;

    private long userId;

    private long productId;

    private int num;



}

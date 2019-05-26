package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author louis
 * <p>
 * Date: 2019/5/15
 * Description:
 */
@Setter
@Getter
@ApiModel("支付 dto")
public class OmsPayInfoDto extends BaseDto<Long> {

    @ApiModelProperty("用户id")
    private Long userId;


    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("支付金额")
    private BigDecimal paymentAmount;


    @ApiModelProperty(value = "支付平台:",notes = "1-支付宝,2-微信，3-其它")
    private Integer payPlatform;


    @ApiModelProperty("支付流水号")
    private String platformNumber;

    @ApiModelProperty("支付状态")
    private String platformStatus;


    @ApiModelProperty("支付创建日期")
    private Date createTime;

    @ApiModelProperty("支付更新日期")
    private Date updateTime;



}

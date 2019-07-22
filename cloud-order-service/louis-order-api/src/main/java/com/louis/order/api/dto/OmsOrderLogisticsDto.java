package com.louis.order.api.dto;

import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 */
@Setter
@Getter
@ApiModel("物流相关信息")
public class OmsOrderLogisticsDto extends BaseDto<Long> {


    @ApiModelProperty("订单号")
    private String orderId;

    @ApiModelProperty("快递单号")
    private String expressNo;

    @ApiModelProperty("收货人姓名")
    private String consigneeRealName;

    @ApiModelProperty("收货人手机号")
    private String consigneePhoneNo;

    @ApiModelProperty("收货地址")
    private String consigneeAddress;

    @ApiModelProperty("邮政编码")
    private String consigneeZip;

    @ApiModelProperty("物流状态")
    private int status;

    @ApiModelProperty("结算状态")
    private int settlementStatus;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("结算时间")
    private Date settlementTime;




}

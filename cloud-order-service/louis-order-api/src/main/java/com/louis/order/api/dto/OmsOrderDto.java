package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/15
 * Description:
 */
@Setter
@Getter
@ApiModel(description = "訂單 dto")
public class OmsOrderDto extends BaseDto<Long> {

    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("收货地址")
    private String userAddr;

    @ApiModelProperty("支付方式")
    private Integer payChannel;

    /**
     * 简化流程先把这些复杂的业务场景去掉。后期整个模块搭建好了，
     * 再把这些加进来
     *
     */
//    @ApiModelProperty(value = "商品明细",notes = "一个订单可能会有多个明细")
//    private List<OmsOrderDetailDto> itemDtoList;

    /**
     * 应支付金额
      */
    @ApiModelProperty("总价格：=商品单价*商品件数+运费-优惠券")
    private BigDecimal totalCost;

    @ApiModelProperty("实际支付金额")
    private BigDecimal payment;

    @ApiModelProperty("运费金额")
    private Integer postage;

    @ApiModelProperty("优惠价")
    private int coupon;


    @ApiModelProperty(value = "订单状态",notes ="订单状态:0-已取消-10-未付款, 20-已付款, 40-已发货, 50-交易成功, 60-交易关闭" )
    private int orderStatus;

    @ApiModelProperty("订单创建时间")
    private Date beganTime;

    @ApiModelProperty("订单支付时间")
    private Date paymentTime;

    @ApiModelProperty("订单发货时间")
    private Date sendTime;

    @ApiModelProperty("订单关闭时间")
    private Date closeTime;


}

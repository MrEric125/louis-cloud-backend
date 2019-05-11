package com.louis.order.entity;

import com.louis.entity.MallEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author louis
 * Date: 2019/5/6
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oms_order")
public class OmsOrder extends MallEntity<Long> {


    private static final long serialVersionUID = 1971120387978167283L;

    @ApiModelProperty("订单编码")
    @Column(name = "order_code")
    private String orderCode;

    @ApiModelProperty("订单名字")
    @Column(name = "order_name")
    private String orderName;

    @ApiModelProperty("实际支付金额")
    private BigDecimal payment;

    @ApiModelProperty(value = "订单状态",notes ="订单状态:0-已取消-10-未付款, 20-已付款, 40-已发货, 50-交易成功, 60-交易关闭" )
    private Integer orderStatus;


    @ApiModelProperty("运费金额")
    private Integer postage;

    @ApiModelProperty("创建订单用户")
    @Column(name = "user_id")
    private String userId;

    @ApiModelProperty("订单创建时间")
    @Column(name = "began_time")
    private Date beganTime;

    @ApiModelProperty("结束时间")
    @Column(name = "end_time")
    private Date endTime;

    @ApiModelProperty("商品编码")
    @Column(name = "goods_code")
    private String goodsCode;


    @ApiModelProperty("订单支付时间")
    @Column(name = "payment_time")
    private Date paymentTime;

    @ApiModelProperty("订单发货时间")
    @Column(name = "send_time")
    private Date sendTime;


    @ApiModelProperty("订单关闭时间")
    @Column(name = "close_time")
    private Date closeTime;






























}

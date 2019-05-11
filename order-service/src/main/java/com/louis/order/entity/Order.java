package com.louis.order.entity;

import com.louis.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Setter
@Getter
@Entity
@Table(name = "sys_order")
public class Order extends BaseEntity<Long> {





    @ApiModelProperty("订单编码")
    @Column(name = "order_code")
    private String orderCode;
    @ApiModelProperty("订单名字")
    @Column(name = "order_name")
    private String orderName;
    @ApiModelProperty("创建订单用户")
    @Column(name = "order_user")
    private String orderUser;
    @ApiModelProperty("订单开始时间")
    @Column(name = "began_time")
    private Date beganTime;
    @ApiModelProperty("结束时间")
    @Column(name = "end_time")
    private Date endTime;
    @ApiModelProperty("商品编码")
    @Column(name = "goods_code")
    private String goodsCode;






























}

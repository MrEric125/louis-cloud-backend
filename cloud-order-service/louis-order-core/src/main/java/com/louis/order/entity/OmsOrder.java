package com.louis.order.entity;

import com.louis.core.entity.MallEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author louis
 * Date: 2019/5/6
 * Description:todo 这里后期需要修改，订单与商品的关系，应该是多对多的关系
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oms_order")
public class OmsOrder extends MallEntity<Long> {


    private static final long serialVersionUID = 1971120387978167283L;

    @Column(name = "order_code")
    private String orderCode;

    @OneToMany
    private List<OrderProduct> productList;

    @Column(name = "order_name")
    private String orderName;

    private BigDecimal payment;


    @Column(name = "order_status")
    private Integer orderStatus;


    @ApiModelProperty("运费金额")
    private Integer postage;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "began_time")
    private Date beganTime;


    @Column(name = "payment_time")
    private Date paymentTime;

    @Column(name = "send_time")
    private Date sendTime;


    @Column(name = "close_time")
    private Date closeTime;






























}

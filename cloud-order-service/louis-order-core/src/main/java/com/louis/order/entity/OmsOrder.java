package com.louis.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * @author John·Louis
 * Date: 2019/5/6
 * Description: 这里后期需要修改，订单与商品的关系，是多对多的关系
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oms_order")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmsOrder extends MallEntity<Long> {


    private static final long serialVersionUID = 1971120387978167283L;

    @Column(name = "order_code")
    private String orderCode;

    /**
     * 交易號
     */
    @Column(name = "tran_no")
    private String transactionNumber;



    /**
     * 支付多少钱
     */
    private BigDecimal payment;


    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 支付方式
     */
    @Column(name = "pay_channel")
    private int payChannel;


    /**
     * 产生的积分
     */
    private int integral;

    /**
     * 運費
     */
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

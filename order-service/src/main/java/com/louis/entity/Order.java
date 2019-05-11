package com.louis.entity;

import com.louis.common.entity.BaseEntity;
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





    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_user")
    private String orderUser;

    @Column(name = "began_time")
    private Date beganTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "goods_code")
    private String goodsCode;






























}

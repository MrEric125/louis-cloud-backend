package com.louis.entity;

import com.louis.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "order")
public class Order extends BaseEntity<String> {



    private String orderCode;

    private String orderName;

    private String orderUser;

    private Date beganTime;

    private Date endTime;

    private String goodsCode;






























}

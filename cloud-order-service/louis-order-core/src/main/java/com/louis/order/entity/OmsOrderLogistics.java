package com.louis.order.entity;

import com.louis.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eric
 * @date create in 2019/5/26
 *
 * description: 物流信息
 */
@Setter
@Getter
@Entity
@Table(name = "oms_order_logistics")
public class OmsOrderLogistics extends BaseEntity {

    private static final long serialVersionUID = -6708847003459578628L;

    private String orderId;

    private String expressNo;

    private String consigneeRealName;

    private String consigneePhoneNo;

    private String consigneeAddress;

    private String consigneeZip;

    private int status;

    private int settlementStatus;







}

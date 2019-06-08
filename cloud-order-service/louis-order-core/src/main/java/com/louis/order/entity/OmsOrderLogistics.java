package com.louis.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 *
 * description: 物流信息
 */
@Setter
@Getter
@Entity
@Table(name = "oms_order_logistics")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmsOrderLogistics extends BaseEntity {

    private static final long serialVersionUID = -6708847003459578628L;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "express_No")
    private String expressNo;

    @Column(name = "consignee_real_name")
    private String consigneeRealName;

    @Column(name = "consignee_phone_no")
    private String consigneePhoneNo;

    @Column(name = "consignee_address")
    private String consigneeAddress;

    @Column(name = "consignee_zip")
    private String consigneeZip;

    @Column(name = "status")
    private int status;

    @Column(name = "delivery_staff")

    private String deliveryStaff;

    @Column(name = "settlement_status")
    private int settlementStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "settlement_time")
    private Date settlementTime;







}

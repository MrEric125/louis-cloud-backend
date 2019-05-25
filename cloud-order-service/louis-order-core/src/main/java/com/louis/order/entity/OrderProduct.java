package com.louis.order.entity;

import com.louis.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eric
 * @date create in 2019/5/25
 */
@Setter
@Getter
@Entity
@Table(name = "oms_order_product")
public class OrderProduct extends BaseEntity<Long> {


    private static final long serialVersionUID = -1378518157606971593L;


    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_id")
    private long productId;

}

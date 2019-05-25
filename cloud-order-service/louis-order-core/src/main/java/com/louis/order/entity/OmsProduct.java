package com.louis.order.entity;

import com.louis.core.entity.BaseEntity;
import com.louis.core.entity.LogicDeleteable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Entity
@Table(name = "oms_product")
@Setter
@Getter
public class OmsProduct extends BaseEntity<Long> implements LogicDeleteable {


    private static final long serialVersionUID = -7994226423109936880L;

    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "product_pic")
    private long productPic;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "seller")
    private String seller;


    @Column(name = "seller_id")
    private Long sellerId;


    @Column(name = "product_num")
    private int productNum;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "coupon")
    private int coupon;

    @Column(name = "unit_price")
    private int unitPrice;

    @Column(name = "discount")
    private int discount;
    /**
     * 商品的属性，
     */
    @Column(name = "attr1")
    private String attr1;

    @Column(name = "value1")
    private String value1;


    /**
     * 是否选择,1=已勾选,0=未勾选
     */

    private boolean checked=Boolean.TRUE;

    private boolean deleted=Boolean.FALSE;

    @Override
    public Boolean getDeleted() {
        return this.deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public void markDeleted() {
        this.deleted = true;
    }
}

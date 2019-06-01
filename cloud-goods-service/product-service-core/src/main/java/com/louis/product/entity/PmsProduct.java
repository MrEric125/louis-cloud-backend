package com.louis.product.entity;

import com.louis.core.entity.BaseEntity;
import com.louis.core.entity.LogicDeleteable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/26
 */
@Setter
@Getter
@Entity
@Table(name = "pms_product",indexes ={@Index(name = "pms_p_category_id",columnList ="category_id" )})
public class PmsProduct extends BaseEntity<Long> implements LogicDeleteable {

    private static final long serialVersionUID = -5326322245586530418L;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "old_price")
    private BigDecimal oldPrice;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "publish_time")
    private Date publishTime;

    @Column(name = "summary")
    private String summary;

    @Column(name = "discount_time")
    private Date discountTime;

    @Column(name = "discount_end_time")
    private Date discountEndTime;

    @Column(name = "store_up")
    private int storeUp;

    @Column(name = "audit")
    private boolean audit;

    @Column(name = "deleted")
    private boolean deleted;



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

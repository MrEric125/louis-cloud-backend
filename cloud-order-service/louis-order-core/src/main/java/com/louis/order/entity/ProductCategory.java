package com.louis.order.entity;

import com.louis.core.entity.BaseEntity;
import com.louis.core.entity.TreeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eric
 * @date create in 2019/5/26
 */
@Setter
@Getter
@Entity
@Table(name = "product_category")
public class ProductCategory extends TreeEntity<Long> {


    @Column(name = "product_name")
    private String productName;







    private static final long serialVersionUID = 9123120533901658690L;
}

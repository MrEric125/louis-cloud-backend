package com.louis.order.entity;

import com.louis.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

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
public class ProductCategory extends BaseEntity<Long> {


    private static final long serialVersionUID = 9123120533901658690L;
}

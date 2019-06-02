package com.louis.order.entity;

import com.louis.core.entity.TreeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 */
@Setter
@Getter
//@NoArgsConstructor
//@Builder
@Entity
@Table(name = "product_category")
public class ProductCategory extends TreeEntity<Long> {

    private static final long serialVersionUID = 9123120533901658690L;

    @Column(name = "product_name")
    private String productName;

}

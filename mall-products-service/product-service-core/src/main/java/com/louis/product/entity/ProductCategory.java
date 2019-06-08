package com.louis.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.TreeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John louis
 *  create in 2019/5/26
 */
@Entity
@Table(name = "product_category")
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategory extends TreeEntity<Long> {

    private static final long serialVersionUID = 7689303725899022373L;

    @Column(name = "category_name")
    private String categoryName;

    private int status;

    private int sorted;

    private String icon;

    @Column(name = "url_path")
    private String urlPath;






}

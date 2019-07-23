package com.louis.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 */
@Setter
@Getter
@MappedSuperclass
public class TreeEntity<Id extends Serializable> extends BaseEntity<Id> {

    private static final long serialVersionUID = 3756498214559255983L;

    @Column(name = "has_children")
    private boolean hasChildren = Boolean.FALSE;

    @Column(name = "parent_id")
    private Id parentId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;



}

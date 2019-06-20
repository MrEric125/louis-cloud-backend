package com.louis.server.entity;

import com.louis.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eric
 * @date create in 2019/6/16
 */
@Entity
@Table(name = "sys_role_permission")
public class RolePermission extends BaseEntity<Long> {

    private static final long serialVersionUID = 6991710635907223670L;

    @Column(name = "role_id")
    private long roleId;

    @Column(name = "permission_id")
    private long permissionId;




}

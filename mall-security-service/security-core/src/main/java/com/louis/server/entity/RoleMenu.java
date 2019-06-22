package com.louis.server.entity;

import com.louis.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Setter
@Getter
@Table(name = "role_menu")
@Entity

public class RoleMenu extends BaseEntity<Long> {

    private static final long serialVersionUID = -5762477415564849593L;

    @Column(name = "role_id")
    private long roleId;

    @Column(name = "menu_id")
    private long menuId;
}

package com.louis.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John·Louis
 * @date create in 2019/4/15
 * 用户角色 多对多表
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "sys_user_role")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole extends BaseEntity<Long> {

    private static final long serialVersionUID = -4161710021962553754L;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    private String description;

    public String authority() {
        return this.getRoleName();
    }

}

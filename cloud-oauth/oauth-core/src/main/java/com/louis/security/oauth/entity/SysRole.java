package com.louis.security.oauth.entity;

import com.louis.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseEntity<Long> {


    private static final long serialVersionUID = 2816393346044758798L;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_des")
    private String roleDes;

    @Column(name = "registry_time")
    private Date registryTime;

    @Column(name = "update_time")
    private Date updateTime;





}

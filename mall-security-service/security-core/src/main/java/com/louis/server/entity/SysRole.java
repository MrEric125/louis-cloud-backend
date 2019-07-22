package com.louis.server.entity;

import com.louis.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author John·Louis
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

    /**
     * 当新注册一个用户的时候默认的角色是user
     */
    public static final String DEFAULT_ROLE="USER";

    /**
     * admin 角色
     */
    public static final String ADMIN = "admin";


    /**
     * 运维人员
     */
    public static final String FIX = "fix";

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "en_name")
    private String enName;

    @Column(name = "role_des")
    private String roleDes;

    @Column(name = "registry_time")
    private Date registryTime;

    @Column(name = "update_time")
    private Date updateTime;





}

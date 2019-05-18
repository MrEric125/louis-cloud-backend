package com.louis.security.oauth.entity;

import com.louis.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user")
public class SysUserInfo extends BaseEntity<Long> {


    private static final long serialVersionUID = 256121294003669340L;
    //这个地方的用户名必须保证唯一性
    private String username;

    private String password;

    private String phone;
}

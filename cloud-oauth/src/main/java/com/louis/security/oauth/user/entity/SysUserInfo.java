package com.louis.security.oauth.user.entity;

import com.louis.core.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user")
public class SysUserInfo extends BaseEntity<Long> {


    private static final long serialVersionUID = 256121294003669340L;
    //这个地方的用户名必须保证唯一性
    private String userName;

    private String password;
}

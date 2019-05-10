package com.louis.common.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/3
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_user")
public class User extends BaseEntity<Long>{




    @Column(name = "user_name")
    private String userName;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "desc")
    private String description;

    @Column(name = "user_phone")
    private long userPhone;

    @Column(name = "password")
    private String password;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "weichat_num")
    private String weiChatNumber;

    @Column(name = "status")
    private String status;



}

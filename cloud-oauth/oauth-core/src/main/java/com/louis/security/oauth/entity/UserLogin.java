package com.louis.security.oauth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 *
 * 用于记录用户登录信息
 *
 * 后期优化：登录信息记录到redis中
 */
@Entity
@Table(name = "sys_login_info")
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLogin extends BaseEntity<Long> {

    private static final long serialVersionUID = 5708560329167430554L;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "last_login")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;

    private String ip;



}

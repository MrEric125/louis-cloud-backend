package com.louis.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author louis
 * <p>
 * Date: 2019/6/13
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sys_user_token")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserToken extends BaseEntity<Long> {
    private static final long serialVersionUID = -1069883127226845426L;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;



    /**
     * 登录地址
     */
    @Column(name = "login_time")
    private Date loginTime;



    /**
     * 访问token
     */
    @Column(name = "access_token")
    private String accessToken;

    /**
     * 刷新token
     */
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 访问token的生效时间(秒)
     */
    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 刷新token的生效时间(秒)
     */
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * 0 在线 10已刷新 20 离线
     */
    private Integer status;



    /**
     * 失效时间(秒)
     */
    @Transient
    private Integer expiresIn;

//    @Transient
//    @JsonIgnore
//    public void setUpdateInfo(LoginAuthDto user) {
//
//        if (isNew()) {
//            this.creatorId = (this.lastOperatorId = user.getUserId());
//            this.creator = user.getUserName();
//            this.createdTime = (this.updateTime = new Date());
//        }
//        this.lastOperatorId = user.getUserId();
//        this.lastOperator = user.getUserName() == null ? user.getLoginName() : user.getUserName();
//        this.updateTime = new Date();
//    }
}

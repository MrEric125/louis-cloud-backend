package com.louis.core.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.louis.core.dto.LoginAuthDto;
import com.louis.core.utils.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/11
 * description:  这里会依赖LoginAuthDto 是设计成 继承MallEntity的实体
 * 如果没有登录的话那么那么久不让其看到这些信息
 */

@Setter
@Getter
public class MallEntity<ID extends Serializable> extends BaseEntity<ID> {

    private static final long serialVersionUID = 3729919427498817843L;


    @ApiModelProperty("创建人id")
    @Column(name = "creator_id")
    private ID creatorId;

    @ApiModelProperty("创建时间")
    @Column(name = "created_time")
    @DateTimeFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS)
    @JsonFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS, timezone = "GMT+8")
    private Date createdTime;


    @ApiModelProperty("更新时间")
    @Column(name = "update_time")
    @DateTimeFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS)
    @JsonFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS, timezone = "GMT+8")
    private Date updateTime;


    @ApiModelProperty("最近操作人")
    @Column(name = "last_operator")
    private String lastOperator;

    @ApiModelProperty("最近操作人id")
    @Column(name = "last_operator_id")
    private ID lastOperatorId;

    @Transient
    @JsonIgnore
    public void setUpdateInfo(LoginAuthDto<ID> user) {

        if (isNew()) {
            this.creatorId = (this.lastOperatorId = user.getUserId());

            this.createdTime = (this.updateTime = new Date());
        }
        this.lastOperatorId = user.getUserId();
        this.lastOperator = user.getUserName() == null ? user.getLoginName() : user.getUserName();
        this.updateTime = new Date();
    }








}

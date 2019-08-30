package com.louis.stream.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.louis.core.entity.BaseEntity;
import com.louis.core.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 */
@Entity
@Table(name = "stm_exception_log")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExceptionLog extends BaseEntity<Long> {


    private static final long serialVersionUID = -5867389356734233938L;
    /**
     * 运行环境
     */
    @Column(name = "profile")
    private String profile;

    /**
     * 应用名称
     */
    @Column(name = "application_name")
    private String applicationName;

    /**
     * 异常信息
     */
    @Column(name = "exception_message")
    private String exceptionMessage;

    @Column(name = "username")
    private String username;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private long userId;


    /**
     * 异常发生的时间
     */
    @DateTimeFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS)
    @JsonFormat(pattern = DateUtils.YYYY_MM_DD_HH_MM_SS, timezone = "GMT+8")
    @Column(name = "exception_time")
    private Date exceptionTime;

    /**
     * 异常的原因
     */
    @Column(name = "error_couse")
    private String errorCause;

}

package com.louis.security.oauth.entity;

import com.louis.common.api.repository.EnableQueryCache;
import com.louis.core.entity.BaseEntity;
import com.louis.core.entity.LogicDeleteable;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

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
@EnableQueryCache
public class SysUser extends BaseEntity<Long> implements LogicDeleteable,Comparable<SysUser> {

    public static final int PASSWORD_MAX_LENGTH = 50;
    public static final int PASSWORD_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 50;
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final String USERNAME_PATTERN = "^[\\u4E00-\\u9FA5\\uf900-\\ufa2d_a-zA-Z][\\u4E00-\\u9FA5\\uf900-\\ufa2d\\w]{1,19}$";
    public static final String EMAIL_PATTERN = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?";
    public static final String MOBILE_PHONE_NUMBER_PATTERN = "^(0|86|17951)?(13[0-9]|14[57]|15[012356789]|166|17[0135678]|18[0-9]|19[89])[0-9]{8}$";




    private static final long serialVersionUID = 256121294003669340L;
    //这个地方的用户名必须保证唯一性
    @NotNull(message = "{nut.null}")
    @Pattern(regexp = USERNAME_PATTERN,message = "{user.username.not.valid}")
    private String username;

    @Column(name = "real_name")
    private String realName;


    /**
     * 後期也可以将邮箱作为登录账号
     */
    @NotNull(message = "{not.null}")
    @Pattern(regexp = EMAIL_PATTERN,message = "{user.email.not.valid}")
    private String email;


    /**
     * 通过MD5加密(username+original password+salt)加密存储
     */
    @Length(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH, message = "{user.password.not.valid}")
    private String password;

    /**
     * 加密密码时使用的种子
     */
    private String salt;

    @Column(name = "registry_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registryDate;

    /**
     * 用户状态，0-未启用，1-启用
     */

    private Integer status=UserStatus.normal.getInfo();




    @NotNull(message = "{not.null}")
    @Pattern(regexp = MOBILE_PHONE_NUMBER_PATTERN, message = "{user.mobile.phone.number.not.valid}")
    @Column(name = "mobile_phone_number")
    private String phone;

    private Boolean deleted = Boolean.FALSE;
    @Override
    public Boolean getDeleted() {
        return this.deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;

    }

    @Override
    public void markDeleted() {
        this.deleted = true;

    }

    @Override
    public int compareTo(SysUser o) {
        return 0;
    }

    /**
     * 随机生成登录盐
     */
    public void randomSalt() {

        setSalt(RandomStringUtils.randomAlphabetic(10));

    }

}

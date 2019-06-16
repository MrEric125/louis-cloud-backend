package com.louis.security.validate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author louis
 * <p>
 * Date: 2019/6/11
 * Description:  验证码
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = -3264808289800044061L;

    private String code;

    private String type;


}

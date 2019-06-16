package com.louis.common.web.web.bind.annotation;

import java.lang.annotation.*;

/**
 * <p>绑定当前登录的用户</p>
 * <p>不同于@ModelAttribute</p>
 *
 * @author Zhang Kaitao
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * 当前用户在request中的名字 默认{@link Constants#CURRENT_USER}
     *
     * @return
     */
    String value() default "user";

}

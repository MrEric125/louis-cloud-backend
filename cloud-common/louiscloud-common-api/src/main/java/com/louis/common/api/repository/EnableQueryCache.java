

package com.louis.common.api.repository;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableQueryCache {

    boolean value() default true;

}



package com.louis.core.repository;

import java.lang.annotation.*;


/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableQueryCache {

    boolean value() default true;

}

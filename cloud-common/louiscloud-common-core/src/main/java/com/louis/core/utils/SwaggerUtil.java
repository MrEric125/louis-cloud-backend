package com.louis.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;


/**
 * @author John·Louis
 *
 * @date 2019年5月30日22:53:36
 *
 * description
 */
public class SwaggerUtil {


    /**
     * 判断当前环境
     * @param env
     * @return	true :当前环境为非正式环境	false:当前环境为正式环境
     */
    public static boolean showApi(Environment env) {
        String active = env.getProperty("spring.profiles.active");
        return active == null ||
                StringUtils.equals("local-dev", active) ||
                StringUtils.equals("local-test", active) ||
                StringUtils.equals("dev", active) ||
                StringUtils.equals("test", active);
    }
}

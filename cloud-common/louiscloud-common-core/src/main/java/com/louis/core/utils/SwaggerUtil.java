package com.louis.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;

/**
 * @author Eric
 * @date create in 2019/5/11
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

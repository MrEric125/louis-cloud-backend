package com.louis.core.redis;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 *
 * redis 键前缀工具类
 */
public interface RedisKeyPrefixConstants {


    /**
     * 用户缓存相关性向
     */
    String userRoles = "role_userRoles_";
    String userIdCachePrefix = "user_userId_";
    String usernameCachePrefix = "user_username_";
    String userPhoneCachePrefix = "user_userPhone_";
    String userEmilCachePrefix = "user_userEmil_";

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = Maps.newHashMap();


    }







}

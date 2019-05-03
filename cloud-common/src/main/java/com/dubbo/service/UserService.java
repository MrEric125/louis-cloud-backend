package com.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author Eric
 * @date create in 2019/5/3
 */
public interface UserService {

    String getUser(String id);

}

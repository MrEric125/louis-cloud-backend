package com.louis.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.louis.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Eric
 * @date create in 2019/5/3
 */
@Service(version = "1.0.0")
@Slf4j
public class UserServiceImpl implements UserService {


    @Override
    public String getUser(String id) {
        return new User(id,"zhangsan","22岁").toString();
    }
}

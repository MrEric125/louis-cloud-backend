package com.louis.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.service.UserService;
import com.louis.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @date create in 2019/5/3
 */
//@Service(version = "1.0.0")
@Slf4j
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String id) {
        return null;
    }


//    @Override
//    public String getUser(String id) {
//        return new User(id,"zhangsan","22岁").toString();
//    }

}

package com.louis.security.oauth.user.service;

import com.louis.security.oauth.user.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
@Service
public class UserService {

    public UserInfo findByUserName(String userName) {
        return new UserInfo("test", "test");
    }

}

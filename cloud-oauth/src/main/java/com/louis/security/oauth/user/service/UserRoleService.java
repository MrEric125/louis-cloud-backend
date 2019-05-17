package com.louis.security.oauth.user.service;

import com.google.common.collect.Lists;
import com.louis.security.oauth.user.entity.UserInfo;
import com.louis.security.oauth.user.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
@Service
public class UserRoleService {

    public List<UserRole> getRoleByUser(UserInfo userInfo) {
        if ("test".equals(userInfo.getUserName())) {
            return Lists.newArrayList(new UserRole("ROLE_ADMIN"));
        }
        return null;
    }
}

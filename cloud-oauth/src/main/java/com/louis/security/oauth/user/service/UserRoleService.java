package com.louis.security.oauth.user.service;

import com.louis.common.api.service.CRUDService;
import com.louis.security.oauth.user.entity.SysUserInfo;
import com.louis.security.oauth.user.entity.UserRole;
import com.louis.security.oauth.user.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
@Service
public class UserRoleService extends CRUDService<UserRole, Long> {


    @Autowired
    private UserRoleRepository userRoleRepository;


    public List<UserRole> getRoleByUser(@NotNull SysUserInfo userInfo) {
        /*if ("test".equals(userInfo.getUserName())) {
            return Lists.newArrayList(new UserRole("ROLE_ADMIN"));
        }
        return null;*/
        return userRoleRepository.findByUserId(userInfo.getId());


    }

    public List<UserRole> getRoleByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);

    }
}

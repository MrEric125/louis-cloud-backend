package com.louis.security.oauth.service;

import com.louis.common.api.service.CRUDService;
import com.louis.security.oauth.entity.SysUser;
import com.louis.security.oauth.entity.UserRole;
import com.louis.security.oauth.repository.UserRoleRepository;
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


    public List<UserRole> getRoleByUser(@NotNull SysUser user) {
        /*if ("test".equals(userInfo.getUserName())) {
            return Lists.newArrayList(new UserRole("ROLE_ADMIN"));
        }
        return null;*/
        return userRoleRepository.findByUserId(user.getId());


    }

    public List<UserRole> getRoleByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);

    }
}

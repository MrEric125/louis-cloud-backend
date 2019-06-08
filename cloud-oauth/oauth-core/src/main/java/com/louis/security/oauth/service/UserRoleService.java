package com.louis.security.oauth.service;

import com.louis.core.redis.RedisOperate;
import com.louis.core.service.CRUDService;
import com.louis.security.oauth.RedisConstant;
import com.louis.security.oauth.entity.SysUser;
import com.louis.security.oauth.entity.UserRole;
import com.louis.security.oauth.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    RedisOperate<UserRole> redisOperate;


    public List<UserRole> getRoleByUser(@NotNull SysUser user) {
        /*if ("test".equals(userInfo.getUserName())) {
            return Lists.newArrayList(new UserRole("ROLE_ADMIN"));
        }
        return null;*/
        List<UserRole> userRoles =  redisOperate.lGet(RedisConstant.SYS_USER_ROLE + user.getId(), 0, -1);
        if (CollectionUtils.isEmpty(userRoles)) {
             userRoles = userRoleRepository.findByUserId(user.getId());
            redisOperate.lSet(RedisConstant.SYS_USER_ROLE + user.getId(), userRoles, RedisConstant.TOKEN_EXPIRE);
        }
        return userRoles;


    }

    public List<UserRole> getRoleByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);

    }
}

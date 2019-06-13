package com.louis.security.oauth.service;

import com.louis.core.redis.RedisOperate;
import com.louis.core.service.CRUDService;
import com.louis.oauth.dto.RoleDto;
import com.louis.security.oauth.RedisConstant;
import com.louis.security.oauth.entity.SysUser;
import com.louis.security.oauth.entity.UserRole;
import com.louis.security.oauth.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    /**
     * 获取当前用户所有的角色
     * @param user
     * @return
     */
    public List<UserRole> getRoleByUser(@NotNull SysUser user) {

        List<UserRole> userRoles =  redisOperate.lGet(RedisConstant.SYS_USER_ROLE + user.getId(), 0, -1);
        if (CollectionUtils.isEmpty(userRoles)) {
             userRoles = userRoleRepository.findByUserId(user.getId());
            redisOperate.lSet(RedisConstant.SYS_USER_ROLE + user.getId(), userRoles, RedisConstant.TOKEN_EXPIRE);
        }
        return userRoles;


    }

    /**
     * 用户还是原来的用户，但是role已经不是原来的role
     *
     * @param userRole
     * @param newRoleName
     */
    public void updateUserRole(long userId,String oldRoleName, RoleDto roleDto) {

        UserRole userRole = getRoleByUserIdAndRoleName(userId, oldRoleName);
        if (userRole == null) {
            return;
        }
        redisOperate.lRemove(RedisConstant.SYS_USER_ROLE + userId, 1, userRole);
        userRole.setDescription(roleDto.getRoleDescription());
        userRole.setRoleName(roleDto.getRoleName());
        userRole.setRoleId(roleDto.getId());
        save(userRole);
        redisOperate.lSet(RedisConstant.SYS_USER_ROLE + userRole.getUserId(), userRole, RedisConstant.TOKEN_EXPIRE);
    }

    public List<UserRole> getRoleByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);

    }

    public UserRole getRoleByUserIdAndRoleName(Long userId,String roleName) {
        return userRoleRepository.findByUserIdAndRoleName(userId, roleName);
    }
}

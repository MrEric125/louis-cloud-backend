package com.louis.server.service.impl;

import com.louis.common.api.search.SearchOperator;
import com.louis.common.api.search.Searchable;
import com.louis.core.redis.RedisOperate;
import com.louis.core.service.AbstractWebCRUDService;
import com.louis.oauth.dto.RoleDto;
import com.louis.constant.RedisConstant;
import com.louis.oauth.dto.UserRoleDto;
import com.louis.server.entity.SysRole;
import com.louis.server.entity.UserRole;
import com.louis.server.repository.UserRoleRepository;
import com.louis.server.service.SysRoleService;
import com.louis.server.service.UserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author John·Louis
 * @date create in 2019/4/15
 */
@Service
public class UserRoleServiceImpl extends AbstractWebCRUDService<UserRole, UserRoleDto, Long> implements UserRoleService {


    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    RedisOperate<UserRole> redisOperate;

    public List<UserRole> findByUserId(long userId) {
        return userRoleRepository.findAllByUserId(userId);
    }

    public List<UserRole> findByRoleId(long roleId) {
        return userRoleRepository.findByRoleId(roleId);
    }

    public void blindRole(UserRoleDto dto) {
        this.save(this.dtoToEntity(dto));
    }



    /**
     * 获取当前用户所有的角色
     * @param user
     * @return
     */
    public List<SysRole> getRoleByUser(long userId) {

        List<UserRole> userRoles = null;
        if (CollectionUtils.isEmpty(userRoles)) {
            userRoles = userRoleRepository.findAllByUserId(userId);
        }
        return userRoles.stream().map(x -> sysRoleService.
                        findByRoleName(x.getRoleName()))
                .collect(Collectors.toList());
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

    public UserRole getRoleByUserIdAndRoleName(Long userId,String roleName) {
        return userRoleRepository.findByUserIdAndRoleName(userId, roleName);
    }

    @Override
    public UserRole dtoToEntity(UserRoleDto dto) {
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(dto, userRole);
        return userRole;
    }

    @Override
    public UserRoleDto entityToDto(UserRole userRole) {
        UserRoleDto dto = new UserRoleDto();
        BeanUtils.copyProperties(userRole, dto);
        return dto;
    }
}

package com.louis.server.service.impl;

import com.louis.core.service.WebCRUDService;
import com.louis.oauth.dto.RoleDto;
import com.louis.oauth.dto.RolePermissionDto;
import com.louis.server.entity.RolePermission;
import com.louis.server.entity.SysRole;
import com.louis.server.entity.SysUser;
import com.louis.server.entity.UserRole;
import com.louis.server.repository.SysRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Service
public class SysRoleService extends WebCRUDService<SysRole, RoleDto, Long> {



    /**
     *
     * @return
     */
    public SysRoleRepository getBaseRepository() {
        return (SysRoleRepository) baseRepository;
    }

    /**
     *
     * @param roleName
     * @return
     */
    public SysRole findByRoleName(String roleName) {
       return getBaseRepository().findByRoleName(roleName);
    }






    /**
     *
     * @param dto
     * @return
     */
    @Override
    public SysRole dtoToEntity(RoleDto dto) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(dto, sysRole);
        return sysRole;
    }

    /**
     *
     * @param sysRole
     * @return
     */
    @Override
    public RoleDto entityToDto(SysRole sysRole) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(sysRole, roleDto);
        return roleDto;
    }

}

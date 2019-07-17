package com.louis.server.service.impl;

import com.louis.common.api.search.SearchOperator;
import com.louis.common.api.search.Searchable;
import com.louis.core.service.WebCRUDService;
import com.louis.oauth.dto.RolePermissionDto;
import com.louis.server.entity.RolePermission;
import com.louis.server.entity.SysPermission;
import com.louis.server.entity.SysRole;
import com.louis.server.repository.RolePermissionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author louis
 * <p>
 * Date: 2019/6/18
 * Description:
 */
@Service
public class RolePermissionService extends WebCRUDService<RolePermission, RolePermissionDto, Long> {


    @Autowired
    RolePermissionRepository rolePermissionRepository;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    PermissionServiceImpl permissionService;

    public List<RolePermission> findByRoleId(long roleId) {
        return rolePermissionRepository.findByRoleId(roleId);
    }

    public List<RolePermission> findByPermission(long permissionID) {
        return rolePermissionRepository.findByPermissionId(permissionID);
    }


    public List<SysRole> findRoleByPermissionId(long permissionId) {
        Searchable searchable = Searchable.newSearchable();
        searchable.addSearchFilter("permissionId", SearchOperator.eq, permissionId);
        List<RolePermission> allList = this.findAllList(searchable);
        return allList.stream().map
                (x -> sysRoleService.findById(x.getId()))
                .collect(Collectors.toList());

    }

    public List<SysPermission> findPermissionByRoleId(long roleId) {
        Searchable searchable = Searchable.newSearchable();
        searchable.addSearchFilter("permissionId", SearchOperator.eq, roleId);
        List<RolePermission> allList = this.findAllList(searchable);
        return allList.stream().map
                (x -> permissionService.findById(x.getId()))
                .collect(Collectors.toList());

    }

    public void blindPermission(RolePermissionDto dto) {
        RolePermission rolePermission = this.dtoToEntity(dto);
        this.save(rolePermission);
    }





    @Override
    public RolePermission dtoToEntity(RolePermissionDto dto) {
        RolePermission rolePermission = new RolePermission();
        BeanUtils.copyProperties(dto, rolePermission);
        return rolePermission;
    }

    @Override
    public RolePermissionDto entityToDto(RolePermission rolePermission) {
        RolePermissionDto dto = new RolePermissionDto();
        BeanUtils.copyProperties(rolePermission, dto);
        return dto;
    }

}

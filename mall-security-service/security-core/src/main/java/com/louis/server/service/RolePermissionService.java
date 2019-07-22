package com.louis.server.service;

import com.louis.core.service.IWebService;
import com.louis.oauth.dto.RolePermissionDto;
import com.louis.server.entity.RolePermission;
import com.louis.server.entity.SysPermission;
import com.louis.server.entity.SysRole;

import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/5
 * Description:
 */
public interface RolePermissionService extends IWebService<RolePermission, RolePermissionDto, Long> {

     List<SysRole> findRoleByPermissionId(long permissionId);

    List<RolePermission> findByRoleId(long roleId);

    void blindPermission(RolePermissionDto dto);

    List<SysPermission> findPermissionByRoleId(long roleId);



}

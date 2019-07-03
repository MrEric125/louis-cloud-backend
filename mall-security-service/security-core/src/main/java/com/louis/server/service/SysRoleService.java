package com.louis.server.service;

import com.louis.core.service.ICRUDService;
import com.louis.server.entity.SysRole;

/**
 * @author John·Louis
 * @date create in 2019/7/3
 * description:
 */
public interface SysRoleService extends ICRUDService<SysRole,Long> {

    SysRole findByRoleName(String roleName);
}

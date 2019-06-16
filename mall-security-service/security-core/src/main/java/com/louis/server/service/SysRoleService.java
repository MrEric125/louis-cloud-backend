package com.louis.server.service;

import com.louis.core.service.CRUDService;
import com.louis.server.entity.SysRole;
import com.louis.server.repository.SysRoleRepository;
import org.springframework.stereotype.Service;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Service
public class SysRoleService extends CRUDService<SysRole, Long> {

    public SysRoleRepository getBaseRepository() {
        return (SysRoleRepository) baseRepository;
    }


    public SysRole findByRoleName(String roleName) {
       return getBaseRepository().findByRoleName(roleName);
    }

}

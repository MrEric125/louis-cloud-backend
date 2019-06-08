package com.louis.security.oauth.service;

import com.louis.core.service.CRUDService;
import com.louis.security.oauth.entity.SysRole;
import com.louis.security.oauth.repository.SysRoleRepository;
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

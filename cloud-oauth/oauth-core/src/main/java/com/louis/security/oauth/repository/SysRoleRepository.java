package com.louis.security.oauth.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.security.oauth.entity.SysRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Repository
public interface SysRoleRepository extends BaseRepository<SysRole, Long> {

    @Query
    SysRole findByRoleName(String roleName);


}

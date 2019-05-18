package com.louis.security.oauth.repository;

import com.louis.common.api.repository.BaseRepository;
import com.louis.security.oauth.entity.SysRole;
import org.springframework.stereotype.Repository;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Repository
public interface SysRoleRepository extends BaseRepository<SysRole, Long> {

}

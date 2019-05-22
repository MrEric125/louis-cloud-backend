package com.louis.security.oauth.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.security.oauth.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Repository
public interface SysUserRepository extends BaseRepository<SysUser, Long> {


    SysUser findByUsername(String userName);

}

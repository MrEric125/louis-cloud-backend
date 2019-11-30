package com.louis.oauth.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.oauth.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author John·Louis
 * @date create in 2019/5/18
 */
@Repository
public interface SysUserRepository extends BaseRepository<SysUser, Long> {


    SysUser findByUsername(String userName);

}

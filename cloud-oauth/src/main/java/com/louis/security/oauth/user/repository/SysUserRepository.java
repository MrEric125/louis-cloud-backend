package com.louis.security.oauth.user.repository;

import com.louis.common.api.repository.BaseRepository;
import com.louis.security.oauth.user.entity.SysUserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Repository
public interface SysUserRepository extends BaseRepository<SysUserInfo, Long> {


    SysUserInfo findByUsername(String userName);

}

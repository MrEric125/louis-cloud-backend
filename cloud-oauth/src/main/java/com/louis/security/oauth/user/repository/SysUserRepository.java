package com.louis.security.oauth.user.repository;

import com.louis.common.api.repository.BaseRepository;
import com.louis.security.oauth.user.entity.SysUserInfo;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
public interface SysUserRepository extends BaseRepository<SysUserInfo, Long> {


    SysUserInfo findByUserName(String userName);

}

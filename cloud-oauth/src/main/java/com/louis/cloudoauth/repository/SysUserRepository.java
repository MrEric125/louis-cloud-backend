package com.louis.cloudoauth.repository;

import com.louis.cloudoauth.entity.SysUser;
import com.louis.common.api.repository.BaseRepository;
import com.louis.core.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author louis
 * <p>
 * Date: 2019/5/16
 * Description:
 */
public interface SysUserRepository extends BaseRepository<SysUser, Long> {


    Optional<User> findOneWithRolesByUsername(String userName);
}

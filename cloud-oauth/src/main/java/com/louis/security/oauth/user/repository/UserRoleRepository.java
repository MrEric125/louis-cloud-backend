package com.louis.security.oauth.user.repository;

import com.louis.common.api.repository.BaseRepository;
import com.louis.security.oauth.user.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Repository
public interface UserRoleRepository extends BaseRepository<UserRole, Long> {

    List<UserRole> findByUserId(long userId);


}

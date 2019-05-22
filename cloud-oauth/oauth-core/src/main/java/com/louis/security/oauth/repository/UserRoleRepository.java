package com.louis.security.oauth.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.security.oauth.entity.UserRole;
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

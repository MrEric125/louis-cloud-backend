package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Repository
public interface UserRoleRepository extends BaseRepository<UserRole, Long> {

    List<UserRole> findAllByUserId(long userId);

    UserRole findByUserIdAndRoleName(Long userId, String roleName);

    List<UserRole> findByRoleId(long roleName);


}

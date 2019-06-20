package com.louis.server.repository.oauth2;

import com.louis.server.entity.oauth.UserRoleXrefEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Deprecated
public interface UserRoleXrefRepository extends JpaRepository<UserRoleXrefEntity, Long> {
}

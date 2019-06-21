package com.louis.server.repository.oauth2;

import com.louis.server.entity.oauth.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

@Deprecated
public interface UserRoleXrefRepository extends JpaRepository<UserRole, Long> {
}

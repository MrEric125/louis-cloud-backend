package com.louis.server.repository.oauth2;

import com.louis.server.entity.oauth.OauthUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

@Deprecated
public interface UserRoleXrefRepository extends JpaRepository<OauthUserRole, Long> {
}

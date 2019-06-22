package com.louis.server.repository.oauth2;

import com.louis.server.entity.oauth.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findOneByName(String roleName);

}

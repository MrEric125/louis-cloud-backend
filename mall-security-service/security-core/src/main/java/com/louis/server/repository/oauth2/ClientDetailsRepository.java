package com.louis.server.repository.oauth2;

import com.louis.server.entity.oauth.ClientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientDetailsRepository extends JpaRepository<ClientDetailsEntity, Long> {

    Optional<ClientDetailsEntity> findOneByClientId(String clientId);
}

package com.louis.server.repository.oauth2;

import com.louis.server.entity.oauth.RedirectUriEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RedirectUriRepository extends JpaRepository<RedirectUriEntity, Long> {

    Optional<RedirectUriEntity> findOneByValue(String value);
}

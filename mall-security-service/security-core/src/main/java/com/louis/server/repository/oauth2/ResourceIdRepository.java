package com.louis.server.repository.oauth2;

import com.louis.server.entity.oauth.ResourceIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceIdRepository extends JpaRepository<ResourceIdEntity, Long> {

    Optional<ResourceIdEntity> findOneByValue(String value);
}

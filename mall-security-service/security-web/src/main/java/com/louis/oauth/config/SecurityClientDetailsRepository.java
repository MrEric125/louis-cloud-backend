package com.louis.oauth.config;

import com.louis.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 */
@Repository
public interface SecurityClientDetailsRepository extends BaseRepository<SecurityClientDetails,String> {

    SecurityClientDetails loadClientByClientId(String client);

    void changeRedirectRul(String clientId, String newRedirectUri);
}

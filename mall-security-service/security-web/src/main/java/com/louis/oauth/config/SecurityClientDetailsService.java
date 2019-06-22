package com.louis.oauth.config;

import com.louis.oauth.dto.ClientDetailsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 * 使用我们自己的clientDetails
 */
@Component
public class SecurityClientDetailsService implements ClientDetailsService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SecurityClientDetailsRepository clientDetailsRepository;



    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
//        return clientDetailsRepository.loadClientByClientId(clientId);
        return null;
    }

    /**
     * 在注册用户端的时候默认将clientId设置为用户的clientId
     *
     */
    public void registryClientDetailRigestryUser(ClientDetailsDto dto) {
        SecurityClientDetails details = new SecurityClientDetails();
        BeanUtils.copyProperties(dto, details);
        clientDetailsRepository.save(details);


    }

    public void changeRedirectUrl(String clientId, String newRedirectUrl) {
//        clientDetailsRepository.changeRedirectRul(clientId, newRedirectUrl);

    }


}

package com.louis.security.oauth.oauth.verifier;

import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {

    @Override
    public boolean verify(String jti) {
        return true;
    }

}

package com.louis.verifier;

import org.springframework.stereotype.Component;

/**
 * @author John·Louis
 * @date create in 2019/4/14
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {

    @Override
    public boolean verify(String jti) {
        return true;
    }

}

package com.louis.verifier;

/**
 * @author John·Louis
 * @date create in 2019/4/14
 */
public interface TokenVerifier {
    boolean verify(String jti);
}

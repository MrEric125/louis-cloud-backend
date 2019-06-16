package com.louis.verifier;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
public interface TokenVerifier {
    boolean verify(String jti);
}

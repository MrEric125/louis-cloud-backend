package com.louis.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * @author John·Louis
 * @date create in 2019/4/14
 */

public class AuthMethodNotSupportedException extends AuthenticationServiceException {


    private static final long serialVersionUID = -6666545597560069098L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}

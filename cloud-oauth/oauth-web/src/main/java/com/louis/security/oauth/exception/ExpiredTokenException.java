package com.louis.security.oauth.exception;

import com.louis.security.oauth.oauth.token.Token;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Eric
 * @date create in 2019/4/14
 *
 * 过期的 token错误
 */
public class ExpiredTokenException extends AuthenticationException {


    private static final long serialVersionUID = -2702145067215114446L;

    private Token token;

    public ExpiredTokenException(Token token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }


    public ExpiredTokenException(String msg) {
        super(msg);
    }
}

package com.louis.exception;

/**
 * @author John·Louis
 * @date create in 2019/4/14
 * 非法 token
 */
public class InvalidTokenException extends RuntimeException{
    private static final long serialVersionUID = -5235027267868414271L;

    public InvalidTokenException(String msg) {
        super(msg);
    }

    public InvalidTokenException(String msg, Throwable t) {
        super(msg, t);
    }


}

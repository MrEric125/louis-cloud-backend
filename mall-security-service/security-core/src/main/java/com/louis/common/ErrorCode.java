package com.louis.common;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
public enum  ErrorCode {

    GLOBAL(2),

    AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);

    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }


}

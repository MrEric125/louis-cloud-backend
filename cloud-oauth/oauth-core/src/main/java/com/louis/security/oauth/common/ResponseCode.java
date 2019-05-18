package com.louis.security.oauth.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Setter
@Getter
public class ResponseCode {

    private String code;

    private String message;

    private Object data;

    public ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResponseCode(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseCode(String code, Object data) {
        this.code = code;
        this.data = data;
    }
}

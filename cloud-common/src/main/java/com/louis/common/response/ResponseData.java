package com.louis.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/7
 * Description:
 */
@Setter
@Getter
public class ResponseData {

    public String responseCode;

    public String message;

    public Object data;

    public ResponseData(String responseCode) {
        this.responseCode = responseCode;
    }

    public ResponseData(String responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public ResponseData(String responseCode, String message, Object o) {
        this.responseCode = responseCode;
        this.message = message;
        this.data = o;
    }

    

    public ResponseData(String message, Object data) {
        this.message = message;
        this.data = data;
    }
    
    
}

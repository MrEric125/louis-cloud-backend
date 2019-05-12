package com.louis.common.api.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/7
 * Description:
 * 返回前端json数据格式
 */
@Setter
@Getter
public class ResponseData {

    public int responseCode;

    public String message;

    public Object data;

    public ResponseData(int responseCode) {
        this(responseCode, "success", null);
    }

    public ResponseData(int responseCode, String message) {
        this(responseCode, message, null);
    }

    public ResponseData(int responseCode, String message, Object o) {
        this.responseCode = responseCode;
        this.message = message;
        this.data = o;
    }

    public ResponseData(String message, Object data) {
        this(200, message, data);
    }

    public ResponseData(Object data) {
        this("success", data);
    }
    
    
}

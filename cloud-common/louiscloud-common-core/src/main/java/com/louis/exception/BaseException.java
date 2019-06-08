package com.louis.exception;

import com.louis.core.utils.MessageUtils;
import org.springframework.util.StringUtils;


/**
 * @author John·Louis
 * @date create in 2019/6/8
 * <p>
 * description:
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 2175426057367739947L;

    private String module;

    private String code;

    private Object[] args;

    private String defaultMessage;

    public BaseException(String module, String code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }

    public BaseException(String module, String defaultMessage) {
        this(module, null, null, defaultMessage);
    }

    public BaseException(String code, Object[] args) {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage) {
        this(null, null, null, defaultMessage);
    }

    @Override
    public String getMessage() {
        String message = null;
        if (!StringUtils.isEmpty(code)) {
            message = MessageUtils.message(code, args);
        }
        if (message == null) {
            message = defaultMessage;
        }
        return message;
    }

}

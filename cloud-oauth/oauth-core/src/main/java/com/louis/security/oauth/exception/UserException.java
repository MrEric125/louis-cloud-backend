package com.louis.security.oauth.exception;

import com.louis.exception.BaseException;

/**
 * @author John·Louis
 * @date create in 2019/6/8
 * <p>
 * description:
 */
public class UserException extends BaseException {

    private static final long serialVersionUID = -1539404971923060691L;
    private String errorMsg;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}

package com.louis.common.api;

/**
 * @author louis
 * <p>
 * Date: 2019/7/18
 * Description:
 */
public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2452496405762514616L;
    private int errorCode;

    public EntityNotFoundException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}

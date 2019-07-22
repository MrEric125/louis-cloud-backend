package com.louis.common.api;

/**
 * @author louis
 * <p>
 * Date: 2019/7/19
 * Description:
 */
public class UnablePageException extends RuntimeException {
    private static final long serialVersionUID = -2704329832474557034L;

    public UnablePageException(String message) {
        super(message);
    }
}

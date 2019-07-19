package com.louis.common.api.wrapper;

import java.io.Serializable;

/**
 * @author Eric
 * @date create in 2019/5/22
 */
public class WrapperMassage implements Serializable {

    private static final long serialVersionUID = -6098835717971460688L;
    /**
     * 成功码.
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 成功信息.
     */
    public static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 错误码.
     */
    public static final int ERROR_CODE = 400;



    public static final int INTERNAL_SERVER_ERROR = 500;




    /**
     * 错误信息.
     */
    public static final String ERROR_MESSAGE = "内部异常";

    /**
     * 错误码：参数非法
     */
    public static final int ILLEGAL_ARGUMENT_CODE_ = 100;

    /**
     * 错误信息：参数非法
     */
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";
}

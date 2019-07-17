package com.louis.common.api;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;

import java.util.Objects;

/**
 * @author louis
 * <p>
 * Date: 2019/7/17
 * Description:
 */
public abstract class BaseHandler<T> {

    /**
     * Handle result wrapper.
     *
     * @param result the result
     *
     * @return the wrapper
     */
    protected <T> Wrapper<T> handleResult(T result) {
        boolean flag = isFlag(result);

        if (flag) {
            return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "操作成功", result);
        } else {
            return WrapMapper.wrap(WrapperMassage.ERROR_CODE, "操作失败", result);
        }
    }

    /**
     * Handle result wrapper.
     *

     * @param result   the result
     * @param errorMsg the error msg
     *
     * @return the wrapper
     */
    protected <T> Wrapper<T> handleResult(T result, String errorMsg) {
        boolean flag = isFlag(result);

        if (flag) {
            return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "操作成功", result);
        } else {
            return WrapMapper.wrap(WrapperMassage.ERROR_CODE, errorMsg, result);
        }
    }


    /**
     * special Scene ,should return null result
     *
     * @param
     * @param errorMsg
     * @param <T>
     * @return
     */
    protected <T> Wrapper<T> returnNullResult( String errorMsg) {

        if (errorMsg == null) {
            return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "操作成功");
        } else {
            return WrapMapper.wrap(WrapperMassage.ERROR_CODE, errorMsg);
        }
    }

    /**
     * special Scene ,should return null result
     *
     * @param
     * @param
     * @param <T>
     * @return
     */
    protected <T> Wrapper<T> returnNullResult() {
        return returnNullResult( null);
    }

    /**
     * 判断对象是否为空
     * @param result
     * @return
     */
    private boolean isFlag(Object result) {
        boolean flag;
        if (result instanceof Integer) {
            flag = (Integer) result > 0;
        } else if (result instanceof Boolean) {
            flag = (Boolean) result;
        } else {
            flag = Objects.nonNull(result);
        }
        return flag;
    }



}

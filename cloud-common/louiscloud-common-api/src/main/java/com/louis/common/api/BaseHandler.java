package com.louis.common.api;

import com.louis.common.api.util.PageInfo;
import com.louis.common.api.wrapper.PageWrapMapper;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import org.springframework.data.domain.Page;

import java.util.Objects;

/**
 * @author louis
 * <p>
 * Date: 2019/7/17
 * Description:
 */
public abstract class BaseHandler<T,E> {

    /**
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
     *
     * @param
     * @param errorMsg
     * @param <T>
     * @return
     */
    protected <T> Wrapper<T> handlerNullResult( String errorMsg) {

        if (errorMsg == null) {
            return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "操作成功");
        } else {
            return WrapMapper.wrap(WrapperMassage.ERROR_CODE, errorMsg);
        }
    }

    /**
     * 如果是返回的分页信息那么一定是成功的，就没有errorMsg
     *注意，在查询的时候需要指定Pageable参数，否则显示的页码信息会有错误
     *
     * @param <T>
     * @return todo 这个地方不太好指定泛型类型
     */

    protected <E> Wrapper handlePageResult(T t) {
        if (t instanceof Page) {
            Page page = (Page) t;

            return PageWrapMapper.wrap(page.getContent(),
                    PageInfo.builder()
                            .currentPage(page.getNumber())
                            .pageSize(page.getSize())
                            .totalPage(page.getTotalPages())
                            .totalElement(page.getTotalElements())
                            .build());
        } else {
            throw new UnablePageException("当前查询不可分页");
        }

    }

    /**
     *
     * @param
     * @param
     * @param <T>
     * @return
     */
    protected <T> Wrapper<T> handlerNullResult() {
        return handlerNullResult( null);
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

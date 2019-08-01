package com.louis.common.api;

import com.louis.common.api.util.PageInfo;
import com.louis.common.api.util.SortInfo;
import com.louis.common.api.wrapper.PageWrapMapper;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author louis
 * <p>
 * Date: 2019/7/17
 * Description:
 */
public abstract class BaseHandler<T> {

/*
   protected final Class<T> entityClass;

    public BaseHandler() {
        this.entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
    }*/


    /**
     *
     * @param result the result
     *
     * @return the wrapper
     */
    protected <T> Wrapper<T> handleResult(T result) {
        boolean flag = isFlag(result);
        if (flag) {
            return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "success", result);
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
            return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "success", result);
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
            return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "success");
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

    @SuppressWarnings("unchecked")
    protected <T> Wrapper<T> handlePageAndSortResult(Object t) {
        if (t instanceof Page) {
            Page page = (Page) t;
            List<SortInfo> sortInfos = new ArrayList<>();
            if (page.getSort().isSorted()) {
                sortInfos=page.getSort().get().map(x->{
                    SortInfo sortInfo = new SortInfo();
                    sortInfo.setDirection(x.getDirection().name());
                    sortInfo.setProperties(x.getProperty());
                    return sortInfo;

                }).collect(Collectors.toList());
            }
            return PageWrapMapper.wrap(page.getContent(),
                    PageInfo.builder()
                            .currentPage(page.getNumber())
                            .pageSize(page.getSize())
                            .totalPage(page.getTotalPages())
                            .totalElement(page.getTotalElements())
                            .sorted(page.getSort().isSorted())
                            .sortInfos(sortInfos)
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

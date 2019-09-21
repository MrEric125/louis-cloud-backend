package com.louis.core.service;

import com.louis.common.api.dto.BaseDto;
import com.louis.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/5
 * Description:
 *  专供于有前后端交互的service,会有一个entity和dto之间的转换
 *  和在调用接口前置相关处理和调用接口后置相关处理
 */
public interface IWebService<E extends BaseEntity, Dto extends BaseDto, ID extends Serializable> extends ICRUDService<E, ID> {


    /**
     * 考虑到实体类中的属性和dto中的属性可能会有很多不一样，具体实现需要在{@link AbstractWebCRUDService}的子类中实现
     * {@link IWebService#dtoToEntity(BaseDto)}的原理是一样的
     * @param e
     * @return
     */
    Dto entityToDto(E e);

    E dtoToEntity(Dto dto);

    /**
     * 实体类的集合和dto的集合之间的相互转换，抽象类 {@link AbstractWebCRUDService}
     * 中有默认的实现方式
     * @param eList
     * @return
     */
    List<Dto> entitiesToDtos(List<E> eList);

    /**
     * dto的集合与实体类之间的相互转换，抽象类 {@link AbstractWebCRUDService}
     * 中有默认的实现方式
     * @param dtos
     * @return
     */
    List<E> dtosToEntities(List<Dto> dtos);

    /**
     * 前置处理的功能：
     * 权限验证，参数校验，参数组合等等
     * {@link AbstractWebCRUDService}默认是不做任何处理的
     * @param t 传入的参数
     * @param hook 钩子类型
     * @param <T> 传入参数类型
     */
    <T> void preHandle(T t,int hook );

    /**
     * 后置处理是考虑到对某些操作完之后，需要对其他的数据进行再调度，再处理
     * {@link AbstractWebCRUDService}默认是不做任何处理的
     * @param hook 钩子类型
     * @param <T> 传入参数类型
     */
    <T> void postHandler(T t, int hook);
}

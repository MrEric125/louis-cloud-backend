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


    Dto entityToDto(E e);

    E dtoToEntity(Dto dto);

    List<Dto> entitiesToDtos(List<E> eList);

    List<E> dtosToEntities(List<Dto> dtos);

    /**
     * 前置处理的功能主要是在数据格式调整，或者有一些参数需要从其它接口查询出来
     * @param dto
     */
    void postHandle(Dto dto);

    /**
     * 后置处理是考虑到对某些操作完之后，需要对其他的数据进行再调度，再处理
     * @param e
     */
    void afterHandler(E e);
}

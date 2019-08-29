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
 */
public interface IWebService<E extends BaseEntity, Dto extends BaseDto, ID extends Serializable> extends ICRUDService<E, ID> {


    Dto entityToDto(E e);

    E dtoToEntity(Dto dto);

    List<Dto> entitiesToDtos(List<E> eList);

     List<E> dtosToEntities(List<Dto> dtos);
}

package com.louis.core.service;

import com.louis.common.api.dto.BaseDto;
import com.louis.core.entity.BaseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Service
public abstract class WebCRUDService<T extends BaseEntity, DTO extends BaseDto, ID extends Serializable> extends CRUDService<T, ID> {

    public abstract T dtoToEntity(DTO dto);


    public abstract DTO entityToDto(T t);

    public List<DTO> entitiesToDtos(List<T> entities) {
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<T> dtosToEntities(List<DTO> dtos) {
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }



}

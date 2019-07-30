package com.louis.core.service;

import com.louis.common.api.dto.BaseDto;
import com.louis.core.entity.BaseEntity;
import com.louis.core.entity.MallEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Transactional
public abstract class WebCRUDService<T extends BaseEntity, DTO extends BaseDto, ID extends Serializable> extends CRUDService<T,ID> {



    public abstract T dtoToEntity(DTO dto);


    public abstract DTO entityToDto(T t);

    public List<DTO> entitiesToDtos(List<T> entities) {
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<T> dtosToEntities(List<DTO> dtos) {
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    public T createEntity(DTO dto) {
        T t = dtoToEntity(dto);
        T entity = createBaseData(t);
        return save(entity);
    }

    private T createBaseData(T t) {
        if (t instanceof MallEntity) {
            MallEntity mallEntity = (MallEntity) t;
            mallEntity.setCreatedTime(new Date());
            mallEntity.setUpdateTime(new Date());
            //todo 目前都设置为管理员吧
            mallEntity.setCreatorId(1L);
            return (T) mallEntity;
        }
        return t;

    }



}

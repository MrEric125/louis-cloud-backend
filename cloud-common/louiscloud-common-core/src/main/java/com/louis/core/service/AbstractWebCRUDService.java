package com.louis.core.service;

import com.louis.common.api.dto.BaseDto;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.core.constant.GlobalConstant;
import com.louis.core.entity.BaseEntity;
import com.louis.core.entity.MallEntity;
import com.louis.core.utils.ThreadLocalMap;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Transactional
public abstract class AbstractWebCRUDService<E extends BaseEntity, DTO extends BaseDto, ID extends Serializable>
        extends AbstractCRUDService<E,ID> implements IWebService<E,DTO,ID>{

    @Override
    public <T> void preHandle(T t,int hook) {
    }

    @Override
    public <T> void postHandler(T t,int hook) {
    }

    public abstract E dtoToEntity(DTO dto);

    public abstract DTO entityToDto(E e);


    public List<DTO> entitiesToDtos(List<E> entities) {
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<E> dtosToEntities(List<DTO> dtos) {
        return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }


    public E createEntity(DTO dto) {
        E e = dtoToEntity(dto);
        E entity = createBaseData(e);
        return save(entity);
    }

    @SuppressWarnings("unchecked")
    private E createBaseData(E e) {
        if (e instanceof MallEntity) {
            MallEntity mallEntity = (MallEntity) e;
            mallEntity.setCreatedTime(new Date());
            mallEntity.setUpdateTime(new Date());
            //todo 目前都设置为管理员吧
            mallEntity.setCreatorId(1L);
            return (E) mallEntity;
        }
        return e;
    }

    protected LoginAuthDto getLoginAuthDto() {
        LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
        return Optional.ofNullable(loginAuthDto).orElseThrow(() -> new BusinessException(ErrorCodeEnum.UAC10011041));
    }



}

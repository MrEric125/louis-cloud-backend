package com.louis.security.oauth.dto;

import com.louis.core.dto.BaseDto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Data
public class IdName<E> extends BaseDto<E > {


    private String name;




}

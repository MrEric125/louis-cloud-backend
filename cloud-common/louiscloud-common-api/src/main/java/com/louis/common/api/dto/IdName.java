package com.louis.common.api.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Data;


/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Data
public class IdName<E> extends BaseDto<E > {


    private String name;




}

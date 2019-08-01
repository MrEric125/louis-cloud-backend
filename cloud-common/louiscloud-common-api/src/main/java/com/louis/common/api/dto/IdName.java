package com.louis.common.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author John·Louis
 * @date create in 2019/5/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IdName<E> extends BaseDto<E > {


    private String name;


    public IdName(E id, String name) {
        this.name = name;
        this.id = id;
    }




}

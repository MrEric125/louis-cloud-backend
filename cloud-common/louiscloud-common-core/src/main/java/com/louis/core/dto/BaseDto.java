package com.louis.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Setter
@Getter
public class BaseDto<ID extends Serializable> implements Serializable {


    private static final long serialVersionUID = -1221154456530058105L;
    private ID id;


}

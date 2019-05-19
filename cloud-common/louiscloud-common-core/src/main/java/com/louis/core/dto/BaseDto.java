package com.louis.core.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Setter
@Getter
public class BaseDto<ID>  {


    private static final long serialVersionUID = -1221154456530058105L;
    private ID id;


}

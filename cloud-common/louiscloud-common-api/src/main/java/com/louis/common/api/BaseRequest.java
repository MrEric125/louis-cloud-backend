package com.louis.common.api;

import lombok.Getter;
import lombok.Setter;

/**
 * @author John·Louis
 * @date create in 2019/5/25
 */
@Setter
@Getter
public class BaseRequest {


    private Integer currentPage=0;

    private Integer pageSize = 10;


}

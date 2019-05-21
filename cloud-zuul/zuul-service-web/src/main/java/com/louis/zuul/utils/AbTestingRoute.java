package com.louis.zuul.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/5/21
 */
@Setter
@Getter
public class AbTestingRoute {

    String serviceName;
    String active;
    String endpoint;
    Integer weight;
}

package com.louis.es;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Setter
@Getter
public class BaseDocument<ID extends Serializable> extends AbstractDocument<ID>{
}

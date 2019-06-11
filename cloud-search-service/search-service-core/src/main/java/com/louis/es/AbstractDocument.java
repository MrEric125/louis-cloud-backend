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
public abstract class AbstractDocument<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 5071248879998994116L;

    public abstract ID getId();

    public abstract void setId(final ID id);
}

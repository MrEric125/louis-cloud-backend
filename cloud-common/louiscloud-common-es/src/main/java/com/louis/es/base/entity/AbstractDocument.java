package com.louis.es.base.entity;

import java.io.Serializable;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
public abstract class AbstractDocument<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 5071248879998994116L;

    public abstract Long getId();

    public abstract void setId(final Long id);
}

package com.louis.core.entity;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * @author John·Louis
 * @date create in 2019/5/6
 */
public abstract class AbstractEntity <ID extends Serializable> implements Persistable<ID> ,Serializable {

    private static final long serialVersionUID = 8513406771296804237L;

    @Override
    public abstract ID getId();

    public abstract void setId(final ID id);




    @Override
    public boolean isNew() {
        return null == getId();
    }

}

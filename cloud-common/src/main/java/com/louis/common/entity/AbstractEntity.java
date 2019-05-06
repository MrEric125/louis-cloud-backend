package com.louis.common.entity;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * @author Eric
 * @date create in 2019/5/6
 */
public abstract class AbstractEntity <ID extends Serializable> implements Persistable<ID> {

    @Override
    public abstract ID getId();

    public abstract void setId(final ID id);




    @Override
    public boolean isNew() {
        return null == getId();
    }

}

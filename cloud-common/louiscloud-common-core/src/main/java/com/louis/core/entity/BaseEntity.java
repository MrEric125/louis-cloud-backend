package com.louis.core.entity;



import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author John·Louis
 * @date create in 2019/5/6
 */
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> extends AbstractEntity<Long> {

    private static final long serialVersionUID = -2430797350775093998L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    @NonNull
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getIdToString(){
        return String.valueOf(id);
    }

    public static class Builder {
        private final long id;
        private int status;

        public Builder(long id) {
            this.id = id;
        }

        public Builder entity(int status) {
            this.status = status;
            return this;
        }
    }

    private BaseEntity(Builder builder) {
        this.id = builder.id;

    }
}

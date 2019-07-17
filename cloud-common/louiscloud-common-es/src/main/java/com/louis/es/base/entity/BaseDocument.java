package com.louis.es.base.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */

public class BaseDocument<ID extends Serializable> extends AbstractDocument<ID>{
    private static final long serialVersionUID = -822377468826016832L;

    @Id
    private ID id;


    @Setter
    @Getter
    @Field(format = DateFormat.basic_date_time)
    private LocalDateTime startTime;

    @Setter
    @Getter
    @Field(format = DateFormat.basic_date_time)
    private Date endTime;



    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }

    public String getIdToString(){
        return String.valueOf(id);
    }


}

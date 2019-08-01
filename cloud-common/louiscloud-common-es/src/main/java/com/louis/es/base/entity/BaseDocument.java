package com.louis.es.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
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
    private long id;


    /**
     * todo 其实我想把这个地方改成 java8 中新增的api localDateTime  但是总是报错，算了，以后再说吧、
     *
     */
//    @Setter
//    @Getter
//    @Field(format = DateFormat.basic_date_time)
////    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
////    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private Date startTime;

//    @Setter
//    @Getter
//    @Field(format = DateFormat.basic_date_time)
//    private Date endTime;



    @Override
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


}

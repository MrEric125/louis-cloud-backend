package com.louis.es;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Setter
@Getter
public class BaseDocument<ID extends Serializable> extends AbstractDocument<ID>{
    private static final long serialVersionUID = -822377468826016832L;

    @Id
    private ID id;

    private Date startTime;

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

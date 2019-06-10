package com.louis.es;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Setter
@Getter
public class AbstractDocument<ID extends Serializable> implements Serializable {

    @Id
    private ID id;
}

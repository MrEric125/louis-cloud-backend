package com.louis.es.framework;

import com.louis.es.BaseDocument;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
public class BaseESService<D extends BaseDocument,ID extends Serializable> {

    @Autowired
    BaseESRepository baseESRepository;



}

package com.louis.es;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
public class BaseESService<D extends BaseDocument ,ID extends Serializable> {

    @Autowired
    BaseESRepository baseESRepository;

    //查询当天产生的实体，用户定时任务，导入到es






}

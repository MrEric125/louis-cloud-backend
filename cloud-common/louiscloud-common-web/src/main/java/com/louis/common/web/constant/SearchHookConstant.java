package com.louis.common.web.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 * 保证钩子的值可配置，并且能够达到无侵入的方式来生效功能
 */
@Service
public class SearchHookConstant {

    /**
     * 实现前后置处理中模板方法的钩子
     */
    @Value("${search.add.hook}")
    public  int ADD ;
    @Value("${search.delete.hook}")
    public  int DELETE ;
    @Value("${search.query.hook}")
    public  int QUERY ;
    @Value("${search.edit.hook}")
    public  int EDIT ;



}

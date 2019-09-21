package com.louis.common.web.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 * 保证钩子的值可配置，并且能够达到无侵入的方式来生效功能
 */
@Service
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "search")
public class SearchHookConstant {

    /**
     * 实现前后置处理中模板方法的钩子
     */
//    @Value("${add.hook}")
    public  int ADD=10 ;
//    @Value("${delete.hook}")
    public  int DELETE=20 ;
//    @Value("${query.hook}")
    public  int QUERY=30 ;
//    @Value("${edit.hook}")
    public  int EDIT=40 ;



}

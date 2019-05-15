package com.louis.search.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/14
 * Description:
 */
@Data
@Document(indexName = "aaa",type = "bb")
public class ESEntity {


    private Long id;

    private String ESName;

    private String ESAge;




}

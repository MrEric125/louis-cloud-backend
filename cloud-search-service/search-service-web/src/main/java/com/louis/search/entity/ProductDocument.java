package com.louis.search.entity;

import com.louis.es.BaseDocument;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product_index",type = "",replicas = 0,shards = 5)
public class ProductDocument extends BaseDocument<Long> {


    @Field(type = FieldType.Keyword)
    private String productName;

    private String description;





}








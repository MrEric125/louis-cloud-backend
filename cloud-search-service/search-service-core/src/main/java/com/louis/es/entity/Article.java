package com.louis.es.entity;

import com.louis.es.base.entity.BaseDocument;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author John·Louis
 * @date create in 2019/7/9
 * description:
 */
@Builder
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "article",type = "license")
public class Article extends BaseDocument<Long> {
    private static final long serialVersionUID = 7367579973419835263L;


    private String title;

    private String content;

}

package com.louis.search.entity;

import com.louis.es.BaseDocument;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

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
@Document(indexName = "product_index",type = "product",replicas = 0,shards = 3)
public class ProductDocument extends BaseDocument<Long> {


    private static final long serialVersionUID = -5096289732498734242L;

    private int categoryId;

    private String productTitle;

    private long sellerId;

    private String sellerName;

    private BigDecimal price;

    private BigDecimal oldPrice;

    private String productImg;

    private Date publishTime;

    private String summary;

    private Date discountTime;

    private Date discountEndTime;

    private int storeUp;

    private String description;





}








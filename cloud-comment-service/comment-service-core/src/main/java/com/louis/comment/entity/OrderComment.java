package com.louis.comment.entity;

import com.louis.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "order_comment")
public class OrderComment extends BaseEntity<Long> {

    private static final long serialVersionUID = -6124785159120672329L;

    @Column(name = "oc_order_id")
    private long orderId;

    @Column(name = "oc_user_id")
    private long commentUserId;

    @Column(name = "oc_began_time")
    private Date commentTime;

    @Column(name = "oc_update_time")
    private Date updateTime;


    @Column(name = "oc_goods_name")
    private String goodsName;

    @Column(name = "oc_goods_id")
    private long goodsId;

    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "oc_content")
    private String  content;

    @Column(name = "oc_title")
    private String title;


    @Column(name = "oc_pic_path")
    private String picPath;


}

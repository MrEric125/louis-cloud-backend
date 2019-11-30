package com.louis.oauth.entity;

import com.louis.core.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;



/**
 * @author John·Louis
 * @date create in 2019/11/9
 * description:
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_content_category")
@EqualsAndHashCode(callSuper = false)
public class ContentCategory extends BaseEntity<Long> {

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @Column(name = "sort_order")
    private int sortOrder;

    @Column(name = "is_parent")
    private int isParent;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;


}

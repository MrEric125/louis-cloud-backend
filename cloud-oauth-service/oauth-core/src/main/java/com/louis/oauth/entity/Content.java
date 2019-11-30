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
@Table(name = "tb_content")
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Content extends BaseEntity<Long> {

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTile;

    @Column(name = "url")
    private String url;

    @Column(name = "title_desc")
    private String titleDesc;

    @Column(name = "pic")
    private String pic;

    @Column(name = "pic2")
    private String pic2;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;



}

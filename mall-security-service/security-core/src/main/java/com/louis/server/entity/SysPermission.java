package com.louis.server.entity;

import com.louis.core.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/6/16
 */
@Entity
@Table(name = "sys_permission")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysPermission extends BaseEntity<Long> {


    private static final long serialVersionUID = -8299012669091906505L;


    @Column(name = "parent_id")
    private long parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "en_name")
    private String enName;

    @Column(name = "url")
    private String url;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Date createdTime;

    @Column(name = "update_time")
    private Date updatedTime;


}

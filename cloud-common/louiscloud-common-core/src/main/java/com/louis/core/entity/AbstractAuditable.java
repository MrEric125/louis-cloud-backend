package com.louis.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author louis
 * <p>
 * Date: 2019/6/20
 * Description:
 */
//AbstractPersistable.class
//@EntityListeners(AuditingEntityListener.class)
@Setter
@Data
@EqualsAndHashCode(of = {}, callSuper = false)
@MappedSuperclass
public class AbstractAuditable<ID extends Serializable> extends BaseEntity<ID> {
    private static final long serialVersionUID = -7845283411758422624L;

    @NotNull
    @Size(max = 50)
    @Column(name = "created_by", length = 50, updatable = false, nullable = false)
    private String createdBy;

    @NotNull
    @Column(name = "created_date", updatable = false, nullable = false)
    private Date createdDate;

    @Size(max = 50)
    @Column(name = "last_modified_by", length = 50)
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;







}

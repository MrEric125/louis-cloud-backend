package com.louis.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/20
 * Description:
 */
//AbstractPersistable.class
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditable<ID extends Serializable> extends BaseEntity<ID> {
    private static final long serialVersionUID = -7845283411758422624L;

    @NotNull
    @Size(max = 50)
    @Column(name = "created_by", length = 50, updatable = false, nullable = false)
    private String createdBy;

    @NotNull
    @Column(name = "created_date", updatable = false, nullable = false)
    private LocalDateTime createdDate=LocalDateTime.now();

    @Size(max = 50)
    @Column(name = "last_modified_by", length = 50)
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();







}

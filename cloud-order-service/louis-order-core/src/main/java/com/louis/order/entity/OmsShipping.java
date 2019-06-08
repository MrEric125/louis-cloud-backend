package com.louis.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John·Louis
 * @date create in 2019/5/31
 * <p>
 * description:
 */
@Setter
@Getter
@Entity
@Table(name = "oms_shipping")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmsShipping extends BaseEntity<Long> {
    private static final long serialVersionUID = 6812908940059297506L;
}

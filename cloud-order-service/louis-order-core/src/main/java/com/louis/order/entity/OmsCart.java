

package com.louis.order.entity;

import com.louis.core.entity.LogicDeleteable;
import com.louis.core.entity.MallEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The class Omc cart.
 *
 * @author paascloud.net@gmail.com
 */
@Data
@Entity
@Table(name = "oms_cart")
public class OmsCart extends MallEntity<Long> implements LogicDeleteable {

	private static final long serialVersionUID = 5333646386138778574L;

	@NotNull
	@Column(name = "user_id")
	private Long userId;

	@NotNull
	@Column(name = "product_id")
	private Long productId;

	/**
	 * 数量
	 */
	private Integer quantity=1;


	private boolean delete;

	/**
	 * 是否选择,1=已勾选,0=未勾选
	 */

	private boolean checked=Boolean.TRUE;

	@Override
	public Boolean getDeleted() {
		return delete;
	}

	@Override
	public void setDeleted(Boolean deleted) {
		this.delete = deleted;
	}

	@Override
	public void markDeleted() {
		delete = Boolean.TRUE;

	}
}
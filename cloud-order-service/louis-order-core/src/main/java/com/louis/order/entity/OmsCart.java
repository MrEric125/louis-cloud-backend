

package com.louis.order.entity;

import com.louis.core.entity.LogicDeleteable;
import com.louis.core.entity.MallEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 *
 * @author Eric
 * @date  2019年5月25日20:22:00
 * 每个人都只有一个购物车，但是购物车中的商品是可以有多个的
 */
@Data
@Entity
@Table(name = "oms_cart")
@Builder
public class OmsCart extends MallEntity<Long> implements LogicDeleteable {

	private static final long serialVersionUID = 5333646386138778574L;

	@NotNull
	@Column(name = "user_id")
	private Long userId;

	@NotNull
	@Column(name = "product_id")
	private Long productId;

	/**
	 * 商家
	 */
	private Long merchant;

	/**
	 * 数量
	 */
	@Builder.Default
	@Column(name = "quantity")
	private Integer quantity=1;


	@Column(name = "deleted")
	private boolean delete;

	/**
	 * 是否选择,1=已勾选,0=未勾选
	 */

	@Builder.Default
	@Column(name = "checked")
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


package com.louis.order.entity;

import com.louis.core.entity.MallEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The class Omc cart.
 *
 * @author paascloud.net@gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oms_cart")
public class OmsCart extends MallEntity<Long> {

	private static final long serialVersionUID = 5333646386138778574L;
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "product_id")
	private Long productId;

	/**
	 * 数量
	 */
	private Integer quantity;

	/**
	 * 是否选择,1=已勾选,0=未勾选
	 */
	private boolean checked;
}
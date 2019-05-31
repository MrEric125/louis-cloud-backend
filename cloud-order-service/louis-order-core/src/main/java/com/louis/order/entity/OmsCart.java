

package com.louis.order.entity;

import com.louis.core.entity.BaseEntity;
import com.louis.core.entity.LogicDeleteable;
import com.louis.core.entity.MallEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

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

public class OmsCart extends BaseEntity<Long> implements LogicDeleteable {

	private static final long serialVersionUID = 5333646386138778574L;

	@NotNull
	@Column(name = "user_id")
	private Long userId;


//	private List<OmsCartDetail> cartDetailList;


	@Column(name = "deleted")
	private boolean delete=Boolean.FALSE;

	/**
	 * 是否选择,1=已勾选,0=未勾选
	 */

//	@Builder.Default
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
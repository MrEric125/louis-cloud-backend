

package com.louis.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.MallEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author john louis
 * @date  2019年5月25日23:50:29
 * 订单详情表，用于记录一个订单上商品的详情，避免商品修改后，关联订单上的信息和当初提交订单信息不一致
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oms_order_detail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmsOrderDetail extends MallEntity<Long> {

	private static final long serialVersionUID = -2167960069551022897L;
	/**
	 * 订单明细序列号
	 */
	@Column(name = "detail_no")
	private String detailNo;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "seller_name")
	private String sellerName;

	@Column(name = "seller_id")
	private String sellerId;

	/**
	 * 商品名称
	 */
	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_image")
	private String productImage;

	/**
	 * 生成订单时的商品单价, 单位是元,保留两位小数
	 */
	@Column(name = "unit_price")
	private BigDecimal UnitPrice;

	private String sku;

	@Column(name = "discount_rate")
	private int discountRate;

	/**
	 * 客户备注
	 */
	private String remark;


	/**
	 * 商品数量
	 */
	private Integer quantity;

	/**
	 * 商品总价,单位是元,保留两位小数
	 */
	@Column(name = "total_price")
	private BigDecimal totalPrice;
}
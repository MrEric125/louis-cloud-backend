

package com.louis.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.MallEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Table(name = "oms_pay_info")
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmsPayInfo extends MallEntity<Long> {

	private static final long serialVersionUID = 7949091072343450552L;
	/**
	 * 用户id
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 订单号
	 */
	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "payment_amount")
	private BigDecimal paymentAmount;

	/**
	 * 支付平台:1-支付宝,2-微信
	 */
	@Column(name = "pay_platform")
	private Integer payPlatform;

	/**
	 * 支付流水号
	 */
	@Column(name = "platform_number")
	private String platformNumber;

	/**
	 * 支付状态
	 */
	@Column(name = "platform_status")
	private String platformStatus;

}
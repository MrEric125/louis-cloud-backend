

package com.louis.order.entity;

import com.louis.core.entity.MallEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 送货信息
 * @author john louis
 * @date 2019年5月25日22:37:46
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oms_shipping")
public class OmsShipping extends MallEntity<Long> {

	private static final long serialVersionUID = 7337074530378267740L;
	/**
	 * 用户id
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 收货姓名
	 */
	@Column(name = "receiver_name")
	private String receiverName;

	/**
	 * 收货固定电话
	 */
	@Column(name = "receiver_phone_no")
	private String receiverPhoneNo;

	/**
	 * 收货移动电话
	 */
	@Column(name = "receiver_mobile_no")
	private String receiverMobileNo;

	/**
	 * 收货人省ID
	 */
	@Column(name = "province_id")
	private Long provinceId;

	/**
	 * 省份
	 */
	@Column(name = "province_name")
	private String provinceName;

	/**
	 * 收货人城市ID
	 */
	@Column(name = "city_id")
	private Long cityId;

	/**
	 * 收货人城市名称
	 */
	@Column(name = "city_name")
	private String cityName;

	/**
	 * 区/县
	 */
	@Column(name = "district_name")
	private String districtName;

	/**
	 * 区/县 编码
	 */
	@Column(name = "district_id")
	private Long districtId;

	/**
	 * 街道ID
	 */
	@Column(name = "street_id")
	private Long streetId;

	/**
	 * 接到名称
	 */
	@Column(name = "street_name")
	private String streetName;

	/**
	 * 详细地址
	 */
	@Column(name = "detail_address")
	private String detailAddress;

	/**
	 * 邮编
	 */
	@Column(name = "receiver_zip_code")
	private String receiverZipCode;

	/**
	 * 邮编
	 */
	@Column(name = "default_address")
	private Integer defaultAddress;
}
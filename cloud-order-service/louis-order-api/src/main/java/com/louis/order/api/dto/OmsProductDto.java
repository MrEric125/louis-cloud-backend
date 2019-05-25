package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author louis
 * <p>
 * Date: 2019/5/15
 * Description: 订单系统中 商品相关dto
 */
@Setter
@Getter
@ApiModel("商品详情")
public class OmsProductDto extends BaseDto<Long> {

    @ApiModelProperty("商品id")
    private long productId;

    @ApiModelProperty("商品分类")
    private long categoryId;

    @ApiModelProperty("商品图片地址")
    private long productPic;

    @ApiModelProperty("商品名称")
    private String productName;

    @ApiModelProperty("商家")
    private String seller;


    @ApiModelProperty("商家Id")
    private Long sellerId;


    @ApiModelProperty("商品数量")
    private int productNum;

    @ApiModelProperty("商品编码")
    private String barCode;


    @ApiModelProperty("商品优惠券")
    private BigDecimal coupon;

    @ApiModelProperty("折扣")
    private BigDecimal discount;

    /**
     * 商品的属性，
     */
    @ApiModelProperty("商品其它属性 比方说大小，尺寸之类的")
    private Map<String, Object> productAttr;

    @ApiModelProperty("商品单价")
    private BigDecimal unitPrice;

    /**
     * 是否选择,1=已勾选,0=未勾选
     */
    @ApiModelProperty("是否勾选")
    private boolean checked;

    @ApiModelProperty("消费者享受的保障")
    private List<Object> consumerProtections;



}

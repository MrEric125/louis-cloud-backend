package com.louis.order.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Eric
 * @date create in 2019/5/26
 */
@Setter
@Getter
@ApiModel
public class OmsCartDetailDto {

    @ApiModelProperty("購物車号")
    private long cartId;

    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("商品号")
    private long productId;

    @ApiModelProperty("商品详情")
    private String productName;

    @ApiModelProperty("商品图片地址")
    private String productPic;

    @ApiModelProperty("卖家")
    private String seller;

    @ApiModelProperty("商品数量")
    private String productNum;

    @ApiModelProperty("商品sku号")
    private String barCode;

    @ApiModelProperty("总数量")
    private BigDecimal totalAmount;

    @ApiModelProperty("是否被选中")
    private int checked;

    @ApiModelProperty("商品单价")
    private BigDecimal unitPrice;

    @ApiModelProperty("折扣")
    private int discount;




}

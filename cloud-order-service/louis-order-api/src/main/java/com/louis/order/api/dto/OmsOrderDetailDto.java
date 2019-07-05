package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/15
 * Description: 订单详情dto
 */
@Setter
@Getter
@ApiModel("订单详情")
public class OmsOrderDetailDto extends BaseDto<Long> {



    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("产品号")
    private Long productId;

    @ApiModelProperty("商品名称")
    private String productName;

    @ApiModelProperty("商品图片地址链接")
    private String productImage;

    @ApiModelProperty("生成订单时候的订单单价")
    private BigDecimal unitPrice;

    @ApiModelProperty("商品SKU码")
    private String sku;

    @ApiModelProperty("折扣率")
    private int discountRate;

    @ApiModelProperty("商家名称")
    private String sellerName;

    @ApiModelProperty("商家Id")
    private String sellerId;

    @ApiModelProperty("用户备注信息")
    private String remark;

    @ApiModelProperty("商品數量")
    private Integer quantity;

    @ApiModelProperty("商品总价,单位是元,保留两位小数")
    private BigDecimal totalPrice;

}

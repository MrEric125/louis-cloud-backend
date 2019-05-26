package com.louis.product.api.dto;

import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/26
 */
@Setter
@Getter
@ApiModel
public class PmsProductDto extends BaseDto {

    @ApiModelProperty("商品类目")
    private int categoryId;

    @ApiModelProperty("商品标题")
    private String productTitle;

    @ApiModelProperty("卖家id")
    private long sellerId;

    @ApiModelProperty("卖家名")
    private String sellerName;

    @ApiModelProperty("商品單價")
    private BigDecimal price;

    @ApiModelProperty("商品原價")
    private BigDecimal oldPrice;

    @ApiModelProperty("商品图片地址")
    private String productImg;

    @ApiModelProperty("购买商品地址")
    private String buyUrl;

    @ApiModelProperty("商品发布日期")
    private Date publishTime;

    @ApiModelProperty("商品简介")
    private String summary;

    @ApiModelProperty("打折时间")
    private Date discountTime;

    @ApiModelProperty("打折结束时间")
    private Date discountEndTime;

    @ApiModelProperty("商品被收藏次数")
    private int storeUp;

    @ApiModelProperty("商品通过审核时间")
    private boolean audit;




}

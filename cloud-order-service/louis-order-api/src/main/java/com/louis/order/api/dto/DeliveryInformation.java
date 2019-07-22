package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/15
 * Description:
 */
@Setter
@Getter
@ApiModel("收货地址")
public class DeliveryInformation extends BaseDto<Long> {


    private Long userId;


    @ApiModelProperty("收货姓名")
    private String receiverName;


    @ApiModelProperty("收货固定电话")
    private String receiverPhoneNo;


    @ApiModelProperty("收货移动电话")
    private String receiverMobileNo;


    @ApiModelProperty("收货人省ID")
    private Long provinceId;


    @ApiModelProperty("省份")
    private String provinceName;


    @ApiModelProperty("收货人城市ID")
    private Long cityId;


    @ApiModelProperty("收货人城市名称")
    private String cityName;


    @ApiModelProperty(" 区/县")
    private String districtName;


    @ApiModelProperty("区/县 编码")
    private Long districtId;

    @ApiModelProperty("街道ID")
    private Long streetId;


    @ApiModelProperty("街道名称")
    private String streetName;



    @ApiModelProperty("详细地址")
    private String detailAddress;


    @ApiModelProperty("邮编")
    private String receiverZipCode;


}

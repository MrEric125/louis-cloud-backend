package com.louis.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.louis.core.entity.MallEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 * 购物车中的详情，和购物车是多对一的关系，和商品是一对一的关系，
 * 但有一点需要注意的是，订单详情中商品的信息是不会再变化的，但是购物车中的商品详情是可能会再变化的
 */
@Entity
@Table(name = "oms_cart_detail")
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmsCartDetail extends MallEntity<Long> {


    private static final long serialVersionUID = -3476279716136651060L;

    @Column(name = "cart_id")
    private long cartId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_pic")
    private String productPic;
    @Column(name = "seller")
    private String seller;

    @Column(name = "product_num")
    private String productNum;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "checked")
    private int checked;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "discount")
    private int discount;









}

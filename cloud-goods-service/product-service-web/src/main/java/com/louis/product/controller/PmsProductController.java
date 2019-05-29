package com.louis.product.controller;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.CRUDController;

import com.louis.core.search.Searchable;
import com.louis.product.api.dto.PmsProductDto;
import com.louis.product.entity.PmsProduct;
import com.louis.product.service.PmsProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Eric
 * @date create in 2019/5/26
 * description:
 */
@Controller
@Api("pms 商品管理")
@RequestMapping("/product")
public class PmsProductController extends CRUDController<PmsProduct,Long> {

    @Autowired
    PmsProductService productService;

    @PostMapping("/addproduct")
    public Wrapper addProduct(@RequestBody PmsProductDto dto) {
        //todo 验证权限
        PmsProduct product = new PmsProduct();
        BeanUtils.copyProperties(dto, product);
        return this.add(product);
    }


    @PostMapping("/edit")
    public Wrapper editProduct() {

        return null;
    }

    @GetMapping("/searchProduct/{productName}/{sellerName}")
    public Wrapper<PmsProductDto> searchByProductNameAndSeller(
            @PathVariable("productName") String productName,
            @PathVariable("sellerName") String sellerName
    ) {
        return null;
    }

    /**
     * 查询分页
     * @param searchable
     * @return
     */
    public Wrapper<Page<PmsProductDto>> searchProduct(Searchable searchable) {
        return null;

    }

    /**
     * 下架商品
     * @param productId
     * @return
     */
    @PostMapping("/underTheShelf")
    public Wrapper deleteProduct(long productId) {
        PmsProduct byId = productService.findById(productId);
        return handleResult(byId, "对应商品没有找到");
    }






}

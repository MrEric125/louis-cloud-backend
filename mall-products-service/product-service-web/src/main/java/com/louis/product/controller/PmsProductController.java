package com.louis.product.controller;

import com.louis.common.api.search.SearchOperator;
import com.louis.common.api.search.Searchable;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;

import com.louis.common.web.web.WebCRUDController;
import com.louis.product.api.dto.PmsProductDto;
import com.louis.product.entity.PmsProduct;
import com.louis.product.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 * description: todo 后期需要添加权限相关操作，这里主要都是交给seller操作的
 */
@Controller
@Api(tags = "PmsProductController",description = "pms 商品管理")
@RequestMapping(value = "/product",produces = "applicaton/json")
@Slf4j
@ResponseBody
public class PmsProductController extends WebCRUDController<PmsProduct,PmsProductDto,Long> {

    private final PmsProductService productService;

    @Autowired
    public PmsProductController(PmsProductService productService) {
        this.productService = productService;
    }




    /**
     * 用于卖家修改商品
     *
     * @return
     */
    @ApiOperation("修改操作")
    @PostMapping(value = "/edit")
    public Wrapper editProduct(@RequestBody PmsProductDto dto) {
        PmsProduct product = productService.findById(dto.getId());

        Optional.ofNullable(product).orElseThrow(()->new NullPointerException("对应商品没有找到"));
        BeanUtils.copyProperties(dto, product);
        PmsProduct save = productService.save(product);
        return handleResult(save);
    }



    /**
     * 查询分页，通过条件来查找商品,至于说用户查找商品到时候在es模块中操作
     * @param searchable
     * @return
     */
    @ApiOperation("通过条件查找，下架商品不显示")
    @GetMapping(value = "/searchProduct",produces = "application/json")
//    @SearchableDefaults
    public Wrapper searchProduct( Searchable search) {
        log.info("search product by searchable");
        search.addSearchFilter("deleted", SearchOperator.eq, Boolean.FALSE);
        Page<PmsProduct> page = productService.findAll(search);
        return handleResult(page);
    }

    /**
     * 下架商品
     * @param productId
     * @return
     */
    @ApiOperation("下架商品")
    @PostMapping(value = "/underTheShelf",produces = "application/json")
    public Wrapper deleteProduct(long productId) {
        log.info("mark product as deleted");

        productService.delete(productId);

        return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE);
    }


}

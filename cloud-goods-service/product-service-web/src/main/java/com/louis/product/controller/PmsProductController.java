package com.louis.product.controller;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import com.louis.common.web.web.CRUDController;

import com.louis.core.search.SearchOperator;
import com.louis.core.search.Searchable;
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
 * @author Eric
 * @date create in 2019/5/26
 * description: todo 后期需要添加权限相关操作，这里主要都是交给seller操作的
 */
@Controller
@Api("pms 商品管理")
@RequestMapping("/product")
@Slf4j
public class PmsProductController extends CRUDController<PmsProduct,PmsProductDto,Long> {

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
    @PostMapping("/edit")
    public Wrapper editProduct(@RequestBody PmsProductDto<Long> dto) {
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
    @GetMapping("/searchProduct")
    public Wrapper searchProduct(Searchable searchable) {
        log.info("search product by searchable");
        searchable.addSearchFilter("deleted", SearchOperator.eq, Boolean.FALSE);
        Page<PmsProduct> page = productService.findAll(searchable);
        return handleResult(page);
    }

    /**
     * 下架商品
     * @param productId
     * @return
     */
    @ApiOperation("下架商品")
    @PostMapping("/underTheShelf")
    public Wrapper deleteProduct(long productId) {
        log.info("mark product as deleted");
        PmsProduct product = productService.findById(productId);
        Optional.ofNullable(product).orElseThrow(()->new NullPointerException("对应商品没有找到"));
        product.markDeleted();
        return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE);
    }

    @Override
    protected PmsProduct dtoToEntity(PmsProductDto d) {
        return null;
    }

    @Override
    protected PmsProductDto entityToDto(PmsProduct dto) {
        return null;
    }
}

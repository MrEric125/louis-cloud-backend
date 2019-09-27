package com.louis.product.controller;

import com.google.common.collect.Lists;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.product.entity.PmsProduct;
import com.louis.product.entity.ProductCategory;
import com.louis.product.service.PmsProductCategoryService;
import com.louis.product.service.PmsProductService;
import com.sun.scenario.effect.impl.prism.PrCropPeer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@RestController
@Api(tags = "DataGenerateController",description = "测试数据生成")
@RequestMapping("data")
public class DataGenerateController extends BaseController {
    private static final String url = "https://www.suibian.com/";

    private String[] categoryNameArray = {"衣","食","住","行"};

    @Autowired
    private PmsProductService pmsProductService;

    @Autowired
    private PmsProductCategoryService categoryService;

    @PostMapping("/product/{num}")
    public Wrapper productGenarate(@PathVariable long num) {

        List<ProductCategory> all = categoryService.findAll();


        List<PmsProduct> productList = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            ProductCategory category;
            if (i<all.size()) {
                category = all.get(i);
            } else {
                Random random = new Random();
                int index = random.nextInt(all.size());
                category = all.get(index);
            }

            PmsProduct product = PmsProduct.builder()
                    .productImg(url)
                    .productTitle("product" + i)
                    .price(randomPrice(100))
                    .oldPrice(BigDecimal.ZERO)
                    .categoryId(category.getId())
                    .sellerId(1L)
                    .sellerName("admin")
                    .discountEndTime(new Date())
                    .publishTime(new Date())
                    .discountTime(new Date())
                    .storeUp(0)
                    .summary("summary")
                    .stock(1000)
                    .build();
            productList.add(product);
        }
        List<PmsProduct> pmsProducts = pmsProductService.saveBatch(productList);
        return WrapMapper.success(pmsProducts);
    }

    @PostMapping("/category/{num}")
    public Wrapper categoryGenarate(@PathVariable long num) {

        List<ProductCategory> list = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            String categoryName ;
            if (i < categoryNameArray.length) {
                categoryName = categoryNameArray[i];
            } else {
                Random random = new Random();
                int index = random.nextInt(categoryNameArray.length);
                categoryName = categoryNameArray[index];
            }
            ProductCategory category = ProductCategory.builder()
                    .categoryName(categoryName)
                    .icon(categoryName)
                    .sorted(1)
                    .status(0)
                    .build();
            category.setCreateTime(new Date());
            category.setUpdateTime(new Date());
            category.setHasChildren(false);
            category.setParentId(0L);

            list.add(category);
        }
        List<ProductCategory> list1 = categoryService.saveBatch(list);
        return WrapMapper.success(list1);
    }

    private BigDecimal randomPrice(int i) {
        double v = Math.random() * i;
        return BigDecimal.valueOf(v);
    }
}

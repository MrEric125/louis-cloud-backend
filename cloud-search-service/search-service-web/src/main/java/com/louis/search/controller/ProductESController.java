package com.louis.search.controller;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.search.Searchable;
import com.louis.es.BaseESController;
import com.louis.search.entity.ProductDocument;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/6/11
 */
@Api("产品es")
@RestController
public class ProductESController extends BaseESController<ProductDocument, Long> {


    @ApiOperation("定时任务，往es中导入数据")
    public Wrapper timedTask() {
        return null;
    }

    @ApiOperation("简单搜索")
    @GetMapping("search/simple/{keyWord}")
    public Wrapper searchSimple(@PathVariable("keyWord") String keyWord) {

        return null;
    }
    @ApiOperation("綜合查询")
    @GetMapping("search/")
    public Wrapper search(Searchable searchable) {
        return null;
    }

    @ApiOperation("推荐")
    @GetMapping("recommend/{id}")
    public Wrapper recommend(@PathVariable("id") long id) {

        return null;
    }
    @ApiOperation("获取产品相关信息")
    @GetMapping("/relate")
    public Wrapper relatedInfo() {
        return null;
    }


}

package com.louis.es;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.core.search.Searchable;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author John·Louis
 * @date create in 2019/6/11
 */
@RestController
public class BaseESController<E extends BaseDocument, ID extends Serializable> extends BaseController {

    @Autowired
    private BaseESService<E, ID> baseESService;


    @Scheduled
    @ApiOperation("定时任务，往es中导入数据")

    public void timedTask() {

    }

    @ApiOperation("简单搜索")
    @GetMapping("search/simple/{keyWord}")
    public Wrapper searchSimple(@PathVariable("keyWord") String keyWord,Searchable searchable) {
        Page<E> productDocuments = baseESService.searchSimple(keyWord, searchable);
        return handleResult(productDocuments);
    }

    @ApiOperation("綜合查询")
    @GetMapping("search/")
    public Wrapper search(String keyword,Searchable searchable) {
        Page<E> search = baseESService.search(keyword, searchable);
        return handleResult(search);
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


    @ApiOperation("单个新增")
    @PostMapping("add")
    public Wrapper addOne() {

        return null;
    }

    @ApiOperation("批量新增")
    @PostMapping("addBatch")
    public Wrapper addBatch() {

        return null;

    }


}

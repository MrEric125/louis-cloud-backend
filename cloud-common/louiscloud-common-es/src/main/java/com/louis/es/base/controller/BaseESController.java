package com.louis.es.base.controller;

import com.louis.common.api.BaseHandler;
import com.louis.common.api.EntityNotFoundException;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.es.base.entity.BaseDocument;
import com.louis.es.base.service.BaseEsCRUDService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * @author Eric
 * @date create in 2019/6/11
 */
@Slf4j
public class BaseESController<E extends BaseDocument, ID extends Serializable> extends BaseHandler {

    @Autowired
    private BaseEsCRUDService<E, ID> baseESService;

    public Class<E> getDocumentClass() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        return (Class<E>) pt.getActualTypeArguments()[0];



    }


    @Scheduled
    @ApiOperation("定时任务，往es中导入数据")
    public void timedTask() {

    }

    @ApiOperation("简单搜索")
    @GetMapping("/simpleSearch/{keyWord}")
    public Wrapper searchSimple(@PathVariable("keyWord") String keyWord) {
        Page<E> productDocuments = baseESService.searchSimple(keyWord);
        return handlePageAndSortResult(productDocuments);
    }

    @ApiOperation("綜合查询")
    @GetMapping("/search")
    public Wrapper search(@RequestParam("currentPage")int currentPage, @RequestParam("pageSize")int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.Direction.ASC,"id");
        Page<E> search = baseESService.searchPageable(null, pageable);
        return handleResult(search);
//        return handlePageAndSortResult(search);
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
    @PostMapping("/add")
    public Wrapper addOne(@RequestBody  E e) {
        E document = baseESService.add(e);
        return handlerNullResult();
    }

    @ApiOperation("批量新增")
    @PostMapping("/addBatch")
    public Wrapper addBatch(@RequestBody  List<E> list) {
        return null;

    }

    @GetMapping("/findById/{id}")
    public Wrapper findById(@PathVariable("id") ID id) {
        Optional<E> optionalE = baseESService.findById(id);
        E e = optionalE.orElseThrow(
                () -> new EntityNotFoundException(404, "es中没有找到对应的实体"));
       return handleResult(e);
    }


}

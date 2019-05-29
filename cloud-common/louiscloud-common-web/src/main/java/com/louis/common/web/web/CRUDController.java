package com.louis.common.web.web;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.entity.BaseEntity;
import com.louis.core.service.CRUDService;
import com.louis.core.response.ResponseData;
import com.louis.core.search.Searchable;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/5/8
 * Description:
 *   封装的一些基本的controller
 *
 */
public  abstract class CRUDController<T extends BaseEntity,ID extends Serializable>extends BaseController{

    private CRUDService<T, ID> crudService;

    @Autowired
    public void setBaseService(CRUDService<T, ID> crudService) {
        this.crudService = crudService;
    }

    /**
     * 增加一个实体
     * @param t 实体
     * @return 返回数据
     */
    @ApiOperation("新增操作")
    @PostMapping(value = "/addBy")
    public Wrapper add(T t) {
        T save = crudService.save(t);
        return handleResult(save);
    }


    /**
     * 通过id 删除
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id 删除")
    @PostMapping(value = "/deleteBy")
    public Wrapper delete(ID id) {
        crudService.deleteById(id);

        return handleResult("success");
    }

    /**
     * 查询所有数据
     * @return 返回数据
     */
    @ApiOperation("查询所有")
    @GetMapping(value = "/allBy")
    public Wrapper findAll() {
        List<T> all = crudService.findAll();
        return handleResult(all);
    }

    /**
     * 通过id查询
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id查询，如果没有回抛出异常")
    @GetMapping(value = "/findBy/{id}")
    public Wrapper findById(@PathVariable ID id) {
        T byId = crudService.findById(id);
        return handleResult( byId);
    }

    /**
     * 通过条件查询分页
     * @param searchable 查询条件
     * @return 返回数据
     */
    @ApiOperation("通过searchable条件查询")
    @GetMapping(value = "/listBy")
    public Wrapper findAll(Searchable searchable) {
        searchable = searchable == null ?  Searchable.newSearchable() : searchable;
        if (!searchable.hasPageable())
            searchable.setPage(0, 10);

        Page<T> all = crudService.findAll(searchable);
        return handleResult(all);
    }

}

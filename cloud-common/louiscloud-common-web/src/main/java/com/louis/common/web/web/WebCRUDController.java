package com.louis.common.web.web;
import com.louis.common.api.dto.BaseDto;
import com.louis.common.api.search.Searchable;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.constant.SearchHookConstant;
import com.louis.core.entity.BaseEntity;
import com.louis.core.service.AbstractWebCRUDService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/8
 * Description:
 * 封装的一些简单的增删改查功能的controller
 */
public abstract class WebCRUDController<Entity extends BaseEntity, Dto extends BaseDto, ID extends Serializable>
        extends BaseController<Entity, ID> {

    protected AbstractWebCRUDService<Entity, Dto,ID> abstractWebCRUDService;

    @Autowired
    SearchHookConstant searchHookConstant;

    @Autowired
    public void setBaseService(AbstractWebCRUDService<Entity,Dto,ID> abstractWebCRUDService) {
        this.abstractWebCRUDService = abstractWebCRUDService;
    }

    /**
     * 增加一个实体
     *
     * @param t 实体
     * @return 返回数据
     */
    @ApiOperation("新增操作")
    @PostMapping(value = "/add",produces = "application/json")
    public Wrapper add(@RequestBody Dto t) {
        if (t == null) {
            return handleResult(null,"您没有传入数据");
        }

        abstractWebCRUDService.preHandle(t, searchHookConstant.ADD);

        Entity entity = abstractWebCRUDService.dtoToEntity(t);

        abstractWebCRUDService.save(entity);

        abstractWebCRUDService.postHandler(entity,searchHookConstant.ADD);
        return handleResult(entity);
    }

    /**
     * 通过id 删除
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id 删除")
    @DeleteMapping(value = "/delete",produces = "application/json")
    public Wrapper delete(@ApiParam("实体id") ID id) {

        abstractWebCRUDService.preHandle(id, searchHookConstant.DELETE);

        abstractWebCRUDService.deleteById(id);

        abstractWebCRUDService.postHandler(id,searchHookConstant.DELETE);
        return handleResult("success");
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id查询，如果没有回抛出异常")
    @GetMapping(value = "/findOne/{id}",produces = "application/json")
    public Wrapper findById(@ApiParam("实体id") @PathVariable ID id) {

        abstractWebCRUDService.preHandle(id, searchHookConstant.QUERY);

        Entity entity = abstractWebCRUDService.findById(id);
        if (entity == null) {
            return handlerNullResult();
        }
        Dto dto = abstractWebCRUDService.entityToDto(entity);

        abstractWebCRUDService.postHandler(dto, searchHookConstant.QUERY);
        return handleResult(dto);
    }

    /**
     * 通过条件查询分页
     * // TODO: 2019/8/1  后期需要优化Searchable 参数总是绑定不上去 
     *
     * @param searchable 查询条件
     * @return 返回数据
     */
    @ApiOperation("通过searchable条件查询")
    @GetMapping(value = "/listPageBy",produces = "application/json")
    public Wrapper findAllWithPage( Searchable searchable) {
        searchable = searchable == null ? Searchable.newSearchable() : searchable;
        if (!searchable.hasPageable())
            searchable.setPage(0, 10);

        abstractWebCRUDService.preHandle(searchable,searchHookConstant.QUERY);

        Page<Entity> entityPage = abstractWebCRUDService.findAll(searchable);

        abstractWebCRUDService.postHandler(entityPage, searchHookConstant.QUERY);

        if (CollectionUtils.isEmpty(entityPage.getContent())) {
            return handlerNullResult();
        }
        return handlePageAndSortResult(entityPage);
    }

    @Deprecated
    @ApiOperation("不分页查找集合，测试使用")
    @GetMapping("/queryAll")
    public Wrapper findAllList(Searchable searchable) {
        searchable = searchable == null ? Searchable.newSearchable() : searchable;
        if (searchable.hasPageable())
           searchable.removePageable();
        List<Entity> allList = abstractWebCRUDService.findAllList(searchable);
        return handleResult(allList);
    }

}

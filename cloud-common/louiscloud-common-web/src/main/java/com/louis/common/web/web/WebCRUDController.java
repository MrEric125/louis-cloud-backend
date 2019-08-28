package com.louis.common.web.web;
import com.louis.common.api.dto.BaseDto;
import com.louis.common.api.search.Searchable;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.entity.BaseEntity;
import com.louis.core.service.CRUDService;
import com.louis.core.service.WebCRUDService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public abstract class WebCRUDController<Entity extends BaseEntity, Dto extends BaseDto, ID extends Serializable> extends BaseController<Entity, ID> {

    protected WebCRUDService<Entity, Dto,ID> webCrudService;

    @Autowired
    public void setBaseService(WebCRUDService<Entity,Dto,ID> webCrudService) {
        this.webCrudService = webCrudService;
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

//        BeanUtils.copyProperties(t, entity);
        //新增和编辑是在一起的
        Entity entity = webCrudService.dtoToEntity(t);
        Entity save = webCrudService.save(entity);
        return handleResult(save);
    }


    /**
     * 通过id 删除
     *
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id 删除")
    @DeleteMapping(value = "/delete",produces = "application/json")
    public Wrapper delete(@ApiParam("实体id") ID id) {
        webCrudService.deleteById(id);
        return handleResult("success");
    }

    /**
     * 查询所有数据
     *
     * @return 返回数据
     */
//    @Deprecated
//    @ApiOperation("查询所有")
//    @GetMapping(value = "/queryAll",produces = "application/json" )
//    public Wrapper findAll() {
//        List<Entity> all = webCrudService.findAll();
//        if (CollectionUtils.isEmpty(all)) {
//            return handlerNullResult();
//        }
////        List<Dto> dtos = webCrudService.entitiesToDtos(all);
//        return handleResult(all);
//    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id查询，如果没有回抛出异常")
    @GetMapping(value = "/findOne/{id}",produces = "application/json")
    public Wrapper findById(@ApiParam("实体id") @PathVariable ID id) {
        Entity entity = webCrudService.findById(id);
        if (entity == null) {
            return handlerNullResult();
        }
//        Dto dto = webCrudService.entityToDto(entity);
        return handleResult(entity);
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

        Page<Entity> entityPage = webCrudService.findAll(searchable);
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
        List<Entity> allList = webCrudService.findAllList(searchable);
        return handleResult(allList);
    }

}

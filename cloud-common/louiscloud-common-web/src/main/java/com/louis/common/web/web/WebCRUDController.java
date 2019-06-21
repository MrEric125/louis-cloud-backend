package com.louis.common.web.web;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.louis.common.api.dto.BaseDto;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.entity.BaseEntity;
import com.louis.core.search.Searchable;
import com.louis.core.service.WebCRUDService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/8
 * Description:
 * 封装的一些简单的增删改查功能的controller
 */
@Slf4j
public abstract class WebCRUDController<Entity extends BaseEntity, Dto extends BaseDto, ID extends Serializable> extends BaseController<Entity, ID> {




    private WebCRUDService<Entity, Dto,ID> webCrudService;

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
    public Wrapper delete(ID id) {
        webCrudService.deleteById(id);

        return handleResult("success");
    }

    /**
     * 查询所有数据
     *
     * @return 返回数据
     */
    @Deprecated
    @ApiOperation("查询所有")
    @GetMapping(value = "/queryAll",produces = "application/json" )
    public Wrapper findAll() {
        List<Entity> all = webCrudService.findAll();
        if (CollectionUtils.isEmpty(all)) {
            return returnNullResult();
        }
        List<Dto> dtos = webCrudService.entitiesToDtos(all);
        return handleResult(dtos);
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id查询，如果没有回抛出异常")
    @GetMapping(value = "/findBy/{id}",produces = "application/json")
    public Wrapper findById(@PathVariable ID id) {
        Entity entity = webCrudService.findById(id);
        if (entity == null) {
            return returnNullResult();
        }
        Dto dto = webCrudService.entityToDto(entity);
        return handleResult(dto);
    }

    /**
     * 通过条件查询分页
     *
     * @param searchable 查询条件
     * @return 返回数据
     */
    @ApiOperation("通过searchable条件查询")
    @GetMapping(value = "/listPageBy",produces = "application/json")
    public Wrapper findAll(@RequestBody Searchable searchable) {
        searchable = searchable == null ? Searchable.newSearchable() : searchable;
        if (!searchable.hasPageable())
            searchable.setPage(0, 10);

        Page<Entity> entityPage = webCrudService.findAll(searchable);
        if (CollectionUtils.isEmpty(entityPage.getContent())) {
            return returnNullResult();

        }
        List<Dto> dtos = webCrudService.entitiesToDtos(entityPage.getContent());
        Map<String, Object> map = Maps.newHashMap();
        map.put("totalItems", entityPage.getTotalElements());
        map.put("currentPage", searchable.getPage().getPageNumber());
        return handleResult(ImmutableMap.of("items", dtos, "pagination", map));
    }

    @ApiOperation("不分页查找集合")
    @GetMapping("/queryAll")
    public Wrapper findAllList(Searchable searchable) {
        searchable = searchable == null ? Searchable.newSearchable() : searchable;
        if (searchable.hasPageable())
           searchable.removePageable();
        List<Entity> allList = webCrudService.findAllList(searchable);
        return handleResult(allList);
    }

}

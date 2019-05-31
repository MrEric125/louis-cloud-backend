package com.louis.common.web.web;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.louis.common.api.dto.BaseDto;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.entity.BaseEntity;
import com.louis.core.service.CRUDService;
import com.louis.core.response.ResponseData;
import com.louis.core.search.Searchable;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author louis
 * <p>
 * Date: 2019/5/8
 * Description:
 * 封装的一些简单的增删改查功能的controller
 */
public abstract class CRUDController<Entity extends BaseEntity, Dto extends BaseDto, ID extends Serializable> extends BaseController<Entity, ID> {



    private CRUDService<Entity, ID> crudService;

    @Autowired
    public void setBaseService(CRUDService<Entity, ID> crudService) {
        this.crudService = crudService;
    }

    protected abstract Entity dtoToEntity(Dto d);

    protected abstract Dto entityToDto(Entity dto);

    public List<Dto> entitiesToDtos(List<Entity> entities) {
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * 增加一个实体
     *
     * @param t 实体
     * @return 返回数据
     */
    @ApiOperation("新增操作")
    @PostMapping(value = "/add")
    public Wrapper add(@RequestBody Dto t) {
        Entity entity = dtoToEntity(t);
        Entity save = crudService.save(entity);
        return handleResult(save);
    }


    /**
     * 通过id 删除
     *
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
     *
     * @return 返回数据
     */
    @Deprecated
    @ApiOperation("查询所有")
    @GetMapping(value = "/queryAll")
    public Wrapper findAll() {
        List<Entity> all = crudService.findAll();
        List<Dto> dtos = entitiesToDtos(all);
        return handleResult(dtos);
    }

    /**
     * 通过id查询
     *
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id查询，如果没有回抛出异常")
    @GetMapping(value = "/findBy/{id}")
    public Wrapper findById(@PathVariable ID id) {
        Entity entity = crudService.findById(id);
        Dto dto = entityToDto(entity);
        return handleResult(dto);
    }

    /**
     * 通过条件查询分页
     *
     * @param searchable 查询条件
     * @return 返回数据
     */
    @ApiOperation("通过searchable条件查询")
    @GetMapping(value = "/listPageBy")
    public Wrapper findAll(Searchable searchable) {
        searchable = searchable == null ? Searchable.newSearchable() : searchable;
        if (!searchable.hasPageable())
            searchable.setPage(0, 10);

        Page<Entity> entityPage = crudService.findAll(searchable);
        List<Dto> dtos = entitiesToDtos(entityPage.getContent());
        Map<String, Object> map = Maps.newHashMap();
        map.put("totalItems", entityPage.getTotalElements());
        map.put("currentPage", searchable.getPage().getPageNumber());
        return handleResult(ImmutableMap.of("items", dtos, "pagination", map));
    }

}

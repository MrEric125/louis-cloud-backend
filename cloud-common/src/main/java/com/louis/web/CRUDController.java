package com.louis.web;
import com.louis.entity.BaseEntity;
import com.louis.service.CRUDService;
import com.louis.response.ResponseData;
import com.louis.search.Searchable;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public  abstract class CRUDController<T extends BaseEntity,ID extends Serializable>{

    private CRUDService<T, ID> crudService;

    @Autowired
    public void setBaseService(CRUDService<T, ID> baseService) {
        this.crudService = baseService;
    }

    /**
     * 增加一个实体
     * @param t 实体
     * @return 返回数据
     */
    @ApiOperation("新增操作")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseData add(T t) {
        T save = crudService.save(t);
        return new ResponseData(save);
    }


    /**
     * 通过id 删除
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id 删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseData delete(ID id) {
        crudService.deleteById(id);

        return new ResponseData("success");
    }

    /**
     * 查询所有数据
     * @return 返回数据
     */
    @ApiOperation("查询所有")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseData findAll() {
        List<T> all = crudService.findAll();
        return new ResponseData(all);
    }

    /**
     * 通过id查询
     * @param id id
     * @return 返回数据
     */
    @ApiOperation("通过id查询，如果没有回抛出异常")
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public ResponseData findById(@PathVariable ID id) {
        T byId = crudService.findById(id);
        return new ResponseData( byId);
    }

    /**
     * 通过条件查询分页
     * @param searchable 查询条件
     * @return 返回数据
     */
    @ApiOperation("通过searchable条件查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)

    public ResponseData findAll(Searchable searchable) {
        searchable = searchable == null ?  Searchable.newSearchable() : searchable;
        if (!searchable.hasPageable())
            searchable.setPage(0, 10);

        Page<T> all = crudService.findAll(searchable);
        return new ResponseData( all.getContent());
    }

}

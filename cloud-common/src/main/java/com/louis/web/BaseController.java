package com.louis.web;

import com.louis.common.entity.AbstractEntity;
import com.louis.common.service.BaseService;
import com.louis.response.ResponseData;
import com.louis.search.Searchable;
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
public  abstract class BaseController<T extends AbstractEntity,ID extends Serializable>{

    private BaseService<T, ID> baseService;

    @Autowired
    public void setBaseService(BaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    /**
     * 增加一个实体
     * @param t 实体
     * @return 返回数据
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseData add(T t) {
        T save = baseService.save(t);
        return new ResponseData(save);
    }


    /**
     * 通过id 删除
     * @param id id
     * @return 返回数据
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseData delete(ID id) {
         baseService.deleteById(id);

        return new ResponseData("success");
    }

    /**
     * 查询所有数据
     * @return 返回数据
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseData findAll() {
        List<T> all = baseService.findAll();
        return new ResponseData(all);
    }

    /**
     * 通过id查询
     * @param id id
     * @return 返回数据
     */
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public ResponseData findById(@PathVariable ID id) {
        T byId = baseService.findById(id);
        return new ResponseData( byId);
    }

    /**
     * 通过条件查询分页
     * @param searchable 查询条件
     * @return 返回数据
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseData findAll(Searchable searchable) {
        Page<T> all = baseService.findAll(searchable);
        return new ResponseData( all.getContent());
    }

}

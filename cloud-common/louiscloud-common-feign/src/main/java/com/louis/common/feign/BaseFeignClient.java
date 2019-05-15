package com.louis.common.feign;

import com.louis.common.api.response.wrapper.Wrapper;
import com.louis.core.dto.BaseDto;
import com.louis.core.entity.BaseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


/**
 * feign client base class
 * @author Eric
 * @date create in 2019/5/12
 */
public interface BaseFeignClient<E extends BaseEntity,D extends BaseDto,ID extends Serializable> {


    /**
     * 更新產品族
     * @param eList 对象集合
     * @return
     */
    @PostMapping(value = "/updateList")
    Wrapper updateList(@RequestBody List<D> eList);

    /**
     * 单个对象
     * @param e 更行
     * @return
     */
    @RequestMapping(value = "update")
    Wrapper update(@RequestBody D e);


    /**
     *
     * @param e 對象
     * @return
     */
    @PostMapping(value = "/add")
    Wrapper add(@RequestBody D e);


    /**
     *  刪除
     * @param id 主鍵
     * @return
     */
    @GetMapping("/delete/{id}")
    Wrapper deleteById(@PathVariable("id") ID id);


    /**
     * 通过id查找
     * @param id
     * @return
     */
    @GetMapping("/findOne/{id}")
    Wrapper findOne(@PathVariable("id") ID id);


    /**
     * 查找所有
     * @return
     */
    @GetMapping("/findAll")
    Wrapper findAll();




}

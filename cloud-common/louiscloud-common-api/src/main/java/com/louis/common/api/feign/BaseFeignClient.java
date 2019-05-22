package com.louis.common.api.feign;


import com.louis.common.api.dto.BaseDto;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


/**
 * feign client base class
 * @author Eric
 * @date create in 2019/5/12
 */
public interface BaseFeignClient<D extends BaseDto,ID extends Serializable> {


    /**
     * 更新產品族
     * @param eList 对象集合
     * @return
     */
    @PostMapping(value = "/updateList")
    BaseDto updateList(@RequestBody List<D> eList);

    /**
     * 单个对象
     * @param e 更行
     * @return
     */
    @RequestMapping(value = "update")
    BaseDto update(@RequestBody D e);


    /**
     *
     * @param e 對象
     * @return
     */
    @PostMapping(value = "/add")
    BaseDto add(@RequestBody D e);


    /**
     *  刪除
     * @param id 主鍵
     * @return
     */
    @GetMapping("/delete/{id}")
    BaseDto deleteById(@PathVariable("id") ID id);


    /**
     * 通过id查找
     * @param id
     * @return
     */
    @GetMapping("/findOne/{id}")
    BaseDto findOne(@PathVariable("id") ID id);


    /**
     * 查找所有
     * @return
     */
    @GetMapping("/findAll")
    BaseDto findAll();




}

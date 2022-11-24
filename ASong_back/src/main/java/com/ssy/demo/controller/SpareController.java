package com.ssy.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssy.demo.common.CommonUtil;
import com.ssy.demo.common.Responseresult;
import com.ssy.demo.entity.Spare;
import com.ssy.demo.service.iml.SpareServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "sparecontroller")
public class SpareController {

    @Autowired
    SpareServiceIml spareServiceIml;

    @Autowired
    Responseresult result;

    //获取全部信息
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public Responseresult page(String search, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        try {
            Page<Spare> page = spareServiceIml.findAll(pageNum,pageSize,search);
            result = CommonUtil.setResult("0","查询成功",page);
        } catch (Exception e) {
            result = CommonUtil.setResult("1","失败",e.getMessage());
        }
        return result;
    }
    //编辑
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public Responseresult edit(@RequestBody Spare spare){
        try {
            spareServiceIml.edit(spare);
            result = CommonUtil.setResult("0","修改成功","");
        } catch (Exception e) {
            result = CommonUtil.setResult("1","修改失败",e.getMessage());
        }
        return  result;
    }

    /**删除*/
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Responseresult del(@PathVariable int id){
        spareServiceIml.del(id);
        result = CommonUtil.setResult("0","删除成功","");
        return  result;
    }
    //添加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Responseresult add(@RequestBody Spare spare) {
        try {
            spareServiceIml.add(spare);
            result = CommonUtil.setResult("0", "添加成功", "");
        } catch (Exception e) {
            result = CommonUtil.setResult("1", "添加失败", e.getMessage());
        }
        return result;
    }
}

package com.ssy.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssy.demo.common.CommonUtil;
import com.ssy.demo.common.Responseresult;
import com.ssy.demo.entity.Knight;
import com.ssy.demo.service.iml.KnightServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "knightcontroller")
public class KnightController {

    @Autowired
    KnightServiceIml knightServiceIml;

    @Autowired
    Responseresult result;
//获取全部信息
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public Responseresult page(String search, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        try {
            Page<Knight> page = knightServiceIml.findAll(pageNum,pageSize,search);
            result = CommonUtil.setResult("0","查询成功",page);
        } catch (Exception e) {
            result = CommonUtil.setResult("1","失败",e.getMessage());
        }
        return result;
    }
//编辑
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public Responseresult edit(@RequestBody Knight knight){
        try {
            knightServiceIml.edit(knight);
            result = CommonUtil.setResult("0","修改成功","");
        } catch (Exception e) {
            result = CommonUtil.setResult("1","修改失败",e.getMessage());
        }
        return  result;
    }

    /**删除*/
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Responseresult del(@PathVariable int id){
        knightServiceIml.del(id);
        result = CommonUtil.setResult("0","删除成功","");
        return  result;
    }
//添加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Responseresult add(@RequestBody Knight knight) {
        try {
                knightServiceIml.add(knight);
                result = CommonUtil.setResult("0", "添加成功", "");
        } catch (Exception e) {
            result = CommonUtil.setResult("1", "添加失败", e.getMessage());
        }
        return result;
    }
}

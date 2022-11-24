package com.ssy.demo.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssy.demo.entity.Knight;
import com.ssy.demo.mapper.KnightMapper;
import com.ssy.demo.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class KnightServiceIml  extends ServiceImpl<KnightMapper, Knight> implements KnightService {

    @Autowired
    KnightMapper knightMapper;

    public Page<Knight> findAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String search) {
        QueryWrapper<Knight> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("name", search);
        }
        Page<Knight> page = new Page<>(pageNum, pageSize);
        return knightMapper.selectPage(page,wrapper);
    }

    public int edit(Knight knight){
        return knightMapper.updateById(knight);
    }

    public int del(int id){
        return knightMapper.deleteById(id);
    }

    public int add(Knight knight){
        return knightMapper.insert(knight);
    }
}

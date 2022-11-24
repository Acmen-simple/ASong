package com.ssy.demo.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssy.demo.entity.Spare;
import com.ssy.demo.mapper.SpareMapper;
import com.ssy.demo.service.SpareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SpareServiceIml  extends ServiceImpl<SpareMapper, Spare> implements SpareService {

    @Autowired
    SpareMapper spareMapper;

    public Page<Spare> findAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String search) {
        QueryWrapper<Spare> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("name", search);
        }
        Page<Spare> page = new Page<>(pageNum, pageSize);
        return spareMapper.selectPage(page,wrapper);
    }

    public int edit(Spare spare){
        return spareMapper.updateById(spare);
    }

    public int del(int id){
        return spareMapper.deleteById(id);
    }

    public int add(Spare spare){
        return spareMapper.insert(spare);
    }
}

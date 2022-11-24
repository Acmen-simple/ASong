package com.ssy.demo.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssy.demo.entity.Moto;
import com.ssy.demo.mapper.MotoMapper;
import com.ssy.demo.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MotoServiceIml extends ServiceImpl<MotoMapper, Moto> implements MotoService {

    @Autowired
    MotoMapper motoMapper;

    /**
     * 获取全部信息
     */
    public Page<Moto> findAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String search) {
        QueryWrapper<Moto> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("moto_model", search);
        }
        Page<Moto> page = new Page<>(pageNum, pageSize);
        return motoMapper.selectPage(page, wrapper);
    }

    public int editmoto(Moto moto) {
        return motoMapper.updateById(moto);
    }

    public int del(int id) {
        return motoMapper.deleteById(id);
    }
}

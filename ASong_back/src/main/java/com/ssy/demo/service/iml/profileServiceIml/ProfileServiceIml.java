package com.ssy.demo.service.iml.profileServiceIml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssy.demo.entity.profile.Profile;
import com.ssy.demo.mapper.profile.ProfileMapper;
import com.ssy.demo.service.profileService.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceIml extends ServiceImpl<ProfileMapper, Profile> implements ProfileService {

    @Autowired
    ProfileMapper usMapper;

    public Page<Profile> getAllData(){
        QueryWrapper<Profile> wrapper = new QueryWrapper<>();
        Page<Profile> page = new Page<>();
        return usMapper.selectPage(page,wrapper);
    }
}

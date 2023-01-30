package com.ssy.demo.controller.profile;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssy.demo.common.CommonUtil;
import com.ssy.demo.common.Responseresult;
import com.ssy.demo.entity.profile.Profile;
import com.ssy.demo.service.iml.profileServiceIml.ProfileServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "usController")
public class ProfileController {

    @Autowired
    ProfileServiceIml profileServiceIml;

    @Autowired
    Responseresult result;

    //获取全部信息
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public Responseresult page() {
        try {
            Page<Profile> page = profileServiceIml.getAllData();
            result = CommonUtil.setResult("0","查询成功",page);
        } catch (Exception e) {
            result = CommonUtil.setResult("1","失败",e.getMessage());
        }
        return result;
    }

}

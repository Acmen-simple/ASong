package com.ssy.demo.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssy.demo.entity.Login;
import com.ssy.demo.mapper.LoginMapper;
import com.ssy.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class LoginServiceIml extends ServiceImpl<LoginMapper, Login> implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    /**
     * 获取全部信息
     */
    @Override
    //Override代表重写
    public Page<Login> find(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String search) {
        QueryWrapper<Login> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("account", search);
        }
        Page<Login> page = new Page<>(pageNum, pageSize);
        return loginMapper.selectPage(page, wrapper);
    }

    public List<Login> findone(String oneaccount) {
        QueryWrapper<Login> wrapper = new QueryWrapper<>();
        wrapper.eq("account", oneaccount);
        return loginMapper.selectList(wrapper);
    }

    /**
     * 判断账号和密码对不对
     */
    @Override
    public Login judge(String account) {
        QueryWrapper<Login> wrapper = new QueryWrapper<>();
        wrapper.eq("account", account);
        return loginMapper.selectOne(wrapper);
    }
    /**
     * 修改密码
     * */
    public Login forgetpw(String account) {
        QueryWrapper<Login> wrapper = new QueryWrapper<>();
        wrapper.eq("account", account);
        return loginMapper.selectOne(wrapper);
    }

    /**
     * 添加
     */
    public int add(Login login) {
        return loginMapper.insert(login);
    }

    /**
     * 判是否重复
     */
    public List<Login> findsame(@RequestParam String account) {
        QueryWrapper<Login> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(account)) {
            wrapper.eq("account", account);
        }
        return loginMapper.selectList(wrapper);
    }

    public int editUser(Login login) {
        return loginMapper.updateById(login);
    }

    public int del(int id) {
        return loginMapper.deleteById(id);
    }

}

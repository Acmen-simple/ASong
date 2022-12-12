package com.ssy.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssy.demo.entity.Login;

public interface LoginService {


    public Page<Login> find(Integer pageNum, Integer pageSize, String search);

    public Login judge(String account);

//    public int forgetpw(Login login);
}

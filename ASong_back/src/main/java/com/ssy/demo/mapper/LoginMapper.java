package com.ssy.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssy.demo.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper extends BaseMapper<Login> {

}

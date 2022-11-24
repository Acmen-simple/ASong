package com.ssy.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

//使用这个注解可以省去代码中大量的get()、 set()、 toString()等方法；
@Data
//它是lombok中的注解,作用在类上;
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
// 生成一个无参数的构造方法
@NoArgsConstructor
public class PageParameter {

    int page;
    int size;
    String dir;
    String sort;
    int excel = 0;
    HashMap parameters;
    Boolean dataScope = false;

//    String deptIds = "";
//    String userIds = "";
//    String gridIds = "";

}

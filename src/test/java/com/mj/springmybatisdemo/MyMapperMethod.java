package com.mj.springmybatisdemo;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Method;

public class MyMapperMethod extends MapperMethod {

    public MyMapperMethod(Class<?> mapperInterface, Method method, Configuration config) {
       super(mapperInterface,method,config);
    }
}

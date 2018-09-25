package com.mj.springmybatisdemo;

import com.mj.springmybatisdemo.mapper.UserMapper;
import org.apache.ibatis.session.Configuration;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy<T> implements InvocationHandler, Serializable
 {
     private Configuration _configuration;
     //接口的类型对象
     private final Class<T> mapperInterface;


 public MyMapperProxy( Configuration configuration,Class<T> mapperInterface ){
     _configuration=configuration;
     this.mapperInterface = mapperInterface;


 }

     @Override
     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         //判断是不是基础方法 比如toString() hashCode()等，这些方法直接调用不需要处理
         if (Object.class.equals(method.getDeclaringClass())) {
             return method.invoke(this, args);
         }
       String sql=  SqlHelper.getMapperSql(_configuration,mapperInterface,method.getName(),args);
         //TODO 根据不同的sql返回不同的结果集
        System.out.println(sql);
return 0;
     }
 }

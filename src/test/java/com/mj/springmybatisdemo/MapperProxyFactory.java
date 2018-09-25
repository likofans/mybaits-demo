package com.mj.springmybatisdemo;

import org.apache.ibatis.binding.MapperProxy;

import java.lang.reflect.Proxy;

public class MapperProxyFactory
 {
    @SuppressWarnings("unchecked")
    public static<T> T newInstance(Class mapperInterface) {
        //创建了一个代理类并返回
        //关于Proxy的API 可以查看java官方的API
        MyMapperProxy<T> mapperProxy=new MyMapperProxy(MainTest.configuration,mapperInterface);
        return (T) Proxy.newProxyInstance(MapperProxyFactory.class.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
    }


}

package com.mj.springmybatisdemo;

import com.mj.springmybatisdemo.mapper.UserMapper;
import com.mj.springmybatisdemo.model.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static SqlSessionFactory sqlSessionFactory;
    public static  Configuration configuration;
     static{
                InputStream inputStream = MainTest.class.getClassLoader().getResourceAsStream("mybatis-configuration.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                configuration=sqlSessionFactory.getConfiguration();
           }
    public static void main(String[] args) {
        String sql=	configuration.getMappedStatement("com.mj.springmybatisdemo.mapper.UserMapper.selectByPrimaryKey").getBoundSql(new HashMap<>()).getSql();
        System.out.println(sql);

        User user=new User();
        user.setUserName("AK");
        user.setPassword("OK");
        user.setUserId(90780880);
        sql=SqlHelper.getMapperSql(configuration,UserMapper.class,"insert",user);


        UserMapper userMapper= MapperProxyFactory.newInstance(UserMapper.class);
        userMapper.selectAllUser();
        //getMyBatisSql("com.mj.springmybatisdemo.mapper.UserMapper.selectByPrimaryKey",new HashMap<>());
        //System.out.println(sql);
    }
    public static String getMyBatisSql(String id, Map<String,Object> parameterMap) {
        MyBatisSql sql = MyBatisSqlUtils.getMyBatisSql(id, parameterMap, sqlSessionFactory);
        return sql.toString();
    }


}

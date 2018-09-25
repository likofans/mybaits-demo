package com.mj.springmybatisdemo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMybatisDemoApplicationTests {

	@Autowired
SqlSessionFactory sqlSessionFactory;


	@Test
	public void contextLoads() {
	String sql=	sqlSessionFactory.getConfiguration().getMappedStatement("com.mj.springmybatisdemo.mapper.UserMapper.selectByPrimaryKey").getBoundSql(new HashMap<>()).getSql();
		System.out.println(sql);

	}

}

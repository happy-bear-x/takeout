package com.takeout.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.takeout.pojo.User;

public class test {

	public static void main(String[] args) throws Exception {
		UserDaoImpl ud=new UserDaoImpl();
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		ud.setSqlSessionFactory(sqlSessionFactory);
		
		User user=ud.findUserById(1002);
		System.out.println(user);
	}

}

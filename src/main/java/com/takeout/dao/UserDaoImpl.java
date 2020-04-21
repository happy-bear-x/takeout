package com.takeout.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.takeout.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	SqlSession sqlSession;
	@Override
	public User findUserById(int id) throws Exception {
		//继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSessoin
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession=sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);

		return user;

	}
	
	


}

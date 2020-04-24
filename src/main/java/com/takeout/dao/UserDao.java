package com.takeout.dao;


import com.takeout.pojo.User;


public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	

}

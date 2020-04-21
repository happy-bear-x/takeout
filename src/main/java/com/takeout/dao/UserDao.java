package com.takeout.dao;


import com.takeout.entity.User;


public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	

}

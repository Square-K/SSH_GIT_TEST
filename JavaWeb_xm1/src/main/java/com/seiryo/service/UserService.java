package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.MyUser;

/**
 *@ClassName: UserService
 *@Description: 用户服务层接口
 *@author carry
 *@date 2024-10-10 10:21:59
 */
public interface UserService {

	//用户登录的方法
	boolean userLogin(String userName,String userPass);
	
	//获取所有的用户信息
	List<MyUser> getAllUserInfo();
	
}

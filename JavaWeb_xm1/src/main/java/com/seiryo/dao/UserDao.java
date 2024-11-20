package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.MyUser;

/**
 *@ClassName: UserDao
 *@Description: 用户数据层接口
 *@author carry
 *@date 2024-10-10 10:25:56
 */
public interface UserDao {
	
	//获取数据库中所有用户的信息
	List<MyUser> selectAllUser();

}

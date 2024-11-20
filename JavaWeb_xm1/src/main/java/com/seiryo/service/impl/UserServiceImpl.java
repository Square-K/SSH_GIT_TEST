package com.seiryo.service.impl;

import java.util.List;

import com.seiryo.dao.UserDao;
import com.seiryo.dao.impl.UserDaoImpl;
import com.seiryo.entity.MyUser;
import com.seiryo.service.UserService;

/**
 *@ClassName: UserServiceImpl
 *@Description: 用户服务层实现类
 *@author carry
 *@date 2024-10-10 10:23:02
 */
public class UserServiceImpl implements UserService{
	
	//接口指向实现类
	private UserDao userDao = new UserDaoImpl();

	/**
	 *@MethodName: userLogin
	 *@Description: 用户登录验证
	 *@author carry
	 *@date 2024-10-10 10:23:25
	 */
	@Override
	public boolean userLogin(String userName, String userPass) {
		
		//缺少数据库中的用户信息
		List<MyUser> userList = userDao.selectAllUser();
		
		//判断登录数据
		if(userList.size() > 0) {
			for(MyUser user:userList) {
				if(user.getUserName().equals(userName)) {
					if(user.getUserPass().equals(userPass)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 *@MethodName: getAllUserInfo
	 *@Description: 获取数据库中所有用户信息的方法
	 *@author carry
	 *@date 2024-10-10 10:47:44
	 */
	@Override
	public List<MyUser> getAllUserInfo() {
		return userDao.selectAllUser();
	}

}

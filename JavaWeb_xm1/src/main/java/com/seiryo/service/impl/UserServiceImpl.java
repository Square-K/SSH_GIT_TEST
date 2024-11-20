package com.seiryo.service.impl;

import java.util.List;

import com.seiryo.dao.UserDao;
import com.seiryo.dao.impl.UserDaoImpl;
import com.seiryo.entity.MyUser;
import com.seiryo.service.UserService;

/**
 *@ClassName: UserServiceImpl
 *@Description: �û������ʵ����
 *@author carry
 *@date 2024-10-10 10:23:02
 */
public class UserServiceImpl implements UserService{
	
	//�ӿ�ָ��ʵ����
	private UserDao userDao = new UserDaoImpl();

	/**
	 *@MethodName: userLogin
	 *@Description: �û���¼��֤
	 *@author carry
	 *@date 2024-10-10 10:23:25
	 */
	@Override
	public boolean userLogin(String userName, String userPass) {
		
		//ȱ�����ݿ��е��û���Ϣ
		List<MyUser> userList = userDao.selectAllUser();
		
		//�жϵ�¼����
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
	 *@Description: ��ȡ���ݿ��������û���Ϣ�ķ���
	 *@author carry
	 *@date 2024-10-10 10:47:44
	 */
	@Override
	public List<MyUser> getAllUserInfo() {
		return userDao.selectAllUser();
	}

}

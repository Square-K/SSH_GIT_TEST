package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.MyUser;

/**
 *@ClassName: UserService
 *@Description: �û������ӿ�
 *@author carry
 *@date 2024-10-10 10:21:59
 */
public interface UserService {

	//�û���¼�ķ���
	boolean userLogin(String userName,String userPass);
	
	//��ȡ���е��û���Ϣ
	List<MyUser> getAllUserInfo();
	
}

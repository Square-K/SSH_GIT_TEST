package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.MyUser;

/**
 *@ClassName: UserDao
 *@Description: �û����ݲ�ӿ�
 *@author carry
 *@date 2024-10-10 10:25:56
 */
public interface UserDao {
	
	//��ȡ���ݿ��������û�����Ϣ
	List<MyUser> selectAllUser();

}

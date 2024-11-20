package com.seiryo.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.UserDao;
import com.seiryo.entity.MyUser;
import com.seiryo.utile.JDBCUTILE;

/**
 *@ClassName: UserDaoImpl
 *@Description: 用户数据层实现类
 *@author carry
 *@date 2024-10-10 10:26:53
 */
public class UserDaoImpl implements UserDao{

	/**=
	 *@MethodName: selectAllUser
	 *@Description: 获取数据库中所有的用户信息
	 *@author carry
	 *@date 2024-10-10 10:27:14
	 */
	@Override
	public List<MyUser> selectAllUser() {
		
		List<MyUser> userList = new ArrayList<MyUser>();
		ResultSet rst = null;
		String SQL = "SELECT * FROM MyUser";
		
		try {
			rst = JDBCUTILE.JDBCSELECT(SQL);
			while(rst.next()) {
				
				MyUser user = new MyUser();
				user.setUserId(rst.getInt("userId"));
				user.setUserName(rst.getString("userName"));
				user.setUserPass(rst.getString("userPass"));
				
				userList.add(user);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.CLOSEDATA(null, null, rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}

}

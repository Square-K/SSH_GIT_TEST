package com.seiryo.entity;

/**
 *@ClassName: MyUser
 *@Description: �û�ʵ����
 *@author carry
 *@date 2024-10-10 10:00:30
 */
public class MyUser {
	
	//�û����
	private Integer userId;
	
	//�û�����
	private String userName;
	
	//�û�����
	private String userPass;

	//���������Ե� GET/SET ����
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	/**
	 *@Constructor: MyUser
	 *@Description: MyUser�вι��캯��
	 *@author carry
	 *@date 2024-10-10 10:02:16
	 */
	public MyUser(Integer userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}

	/**
	 *@Constructor: MyUser
	 *@Description: MyUser�޲ι��캯��
	 *@author carry
	 *@date 2024-10-10 10:02:29
	 */
	public MyUser() {
		super();
	}

	/**
	 *@MethodName: toString
	 *@Description: toString����
	 *@author carry
	 *@date 2024-10-10 10:02:54
	 */
	@Override
	public String toString() {
		return "MyUser [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + "]";
	}
}

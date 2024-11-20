package com.seiryo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seiryo.entity.MyUser;
import com.seiryo.service.UserService;
import com.seiryo.service.impl.UserServiceImpl;

/**
 *@ClassName: UserServlet
 *@Description: �û����Ʋ�
 *@author carry
 *@date 2024-10-10 10:07:36
 */
public class UserServlet extends HttpServlet{
	
	//�ӿ�ָ��ʵ����
	private UserService userService = new UserServiceImpl();

	/**
	 *@MethodName: service
	 *@Description: �û����Ʋ���񷽷�
	 *@author carry
	 *@date 2024-10-10 10:09:27
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//�������ķ���
		//���ȶ�������б���滮���������:�ý����ϵı����ʽ���˵ı����ʽһ�� ���ǽ�����룩
		req.setCharacterEncoding("UTF-8");
		
		//����ٶ���Ӧ���б���滮
		resp.setContentType("text/html;charset=UTF-8");
		
		//���ܵ�¼/ע�ᶼ��Ҫ��ת�� UserServlet
		//����Ӧ����һ�������жϵ����ԣ����ж������ע�ỹ�ǵ�¼
		String pd = req.getParameter("pd");
		
		if("userLogin".equals(pd)) {
			
			//����һ����¼����
			userLogin(req, resp);
			
		}else if("userRegist".equals(pd)) {
			
			//����һ��ע�᷽��
			
		}else if("userUpdate".equals(pd)) {
			
			//����һ���޸��û���Ϣ�ķ���
			userUpDate(req,resp);
			
		}else if("userViewTzUpdate".equals(pd)) {
			
			//����һ����ת���棨�޸ģ��ķ���
			tzUserUpDate(req, resp);

		}
		
	}
	
	/**
	 *@MethodName: userUpDate
	 *@Description: �޸��û���Ϣ�ķ���
	 *@return void
	 *@author carry
	 *@date 2024-10-11 09:20:43
	 */
	private void userUpDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//��ȡ�û���¼���������(�û�������Ҫ�޸ĵ���Ϣ)
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		//����һ���޸��û���Ϣ�ķ���
		
		//��ת���棨success.jsp��
		//��ת��¼�ɹ�֮��Ľ���
		//��ȡ���ݿ��е������û���Ϣ
		List<MyUser> userList = userService.getAllUserInfo();
		req.setAttribute("userList", userList);
		
		//��ת��¼�ɹ��Ľ���
		req.getRequestDispatcher("success.jsp").forward(req, resp);
		
	}
	
	/**
	 *@MethodName: tzUserUpDate
	 *@Description: ��ת�޸Ľ���
	 *@return void
	 *@author carry
	 *@date 2024-10-11 09:07:23
	 */
	private void tzUserUpDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//��ȡ�û���¼���������
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		//����һ���û�������д�������
		MyUser user = new MyUser(Integer.parseInt(userId),userName,userPass);
		
		//���û�������뵽req��
		req.setAttribute("user", user);
		
		//��ת����
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
	}
	
	/**
	 *@MethodName: userLogin
	 *@Description: �û���¼����
	 *@return void
	 *@author carry
	 *@date 2024-10-10 10:18:01
	 */
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//��ȡ�û���¼���������
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		//����¼��Ϣ�ύ�� service ������֤
		boolean bo = userService.userLogin(userName, userPass);
		
		if(bo) {
			
			//��ת��¼�ɹ�֮��Ľ���
			//��ȡ���ݿ��е������û���Ϣ
			List<MyUser> userList = userService.getAllUserInfo();
			req.setAttribute("userList", userList);
			
			//��ת��¼�ɹ��Ľ���
			req.getRequestDispatcher("success.jsp").forward(req, resp);
			
		}else {
			
			//��תһ����¼ʧ�ܵĽ���
			req.setAttribute("massages", "�˺Ż�������󣬵�¼ʧ�ܣ�");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		}
		
	}
	
}

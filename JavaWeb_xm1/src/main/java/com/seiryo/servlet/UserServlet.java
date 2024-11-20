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
 *@Description: 用户控制层
 *@author carry
 *@date 2024-10-10 10:07:36
 */
public class UserServlet extends HttpServlet{
	
	//接口指向实现类
	private UserService userService = new UserServiceImpl();

	/**
	 *@MethodName: service
	 *@Description: 用户控制层服务方法
	 *@author carry
	 *@date 2024-10-10 10:09:27
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//解决乱码的方法
		//优先对请求进行编码规划（解决乱码:让界面上的编码格式与后端的编码格式一致 就是解决乱码）
		req.setCharacterEncoding("UTF-8");
		
		//其次再对相应进行编码规划
		resp.setContentType("text/html;charset=UTF-8");
		
		//不管登录/注册都需要跳转到 UserServlet
		//所以应该有一个可以判断的属性，来判断请求的注册还是登录
		String pd = req.getParameter("pd");
		
		if("userLogin".equals(pd)) {
			
			//调用一个登录方法
			userLogin(req, resp);
			
		}else if("userRegist".equals(pd)) {
			
			//调用一个注册方法
			
		}else if("userUpdate".equals(pd)) {
			
			//调用一个修改用户信息的方法
			userUpDate(req,resp);
			
		}else if("userViewTzUpdate".equals(pd)) {
			
			//调用一个跳转界面（修改）的方法
			tzUserUpDate(req, resp);

		}
		
	}
	
	/**
	 *@MethodName: userUpDate
	 *@Description: 修改用户信息的方法
	 *@return void
	 *@author carry
	 *@date 2024-10-11 09:20:43
	 */
	private void userUpDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//获取用户登录输入的数据(用户真正需要修改的信息)
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		//调用一个修改用户信息的方法
		
		//跳转界面（success.jsp）
		//跳转登录成功之后的界面
		//获取数据库中的所有用户信息
		List<MyUser> userList = userService.getAllUserInfo();
		req.setAttribute("userList", userList);
		
		//跳转登录成功的界面
		req.getRequestDispatcher("success.jsp").forward(req, resp);
		
	}
	
	/**
	 *@MethodName: tzUserUpDate
	 *@Description: 跳转修改界面
	 *@return void
	 *@author carry
	 *@date 2024-10-11 09:07:23
	 */
	private void tzUserUpDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//获取用户登录输入的数据
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		//创建一个用户对象进行储存数据
		MyUser user = new MyUser(Integer.parseInt(userId),userName,userPass);
		
		//将用户对象放入到req中
		req.setAttribute("user", user);
		
		//跳转界面
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
	}
	
	/**
	 *@MethodName: userLogin
	 *@Description: 用户登录方法
	 *@return void
	 *@author carry
	 *@date 2024-10-10 10:18:01
	 */
	private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//获取用户登录输入的数据
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		//将登录信息提交到 service 进行验证
		boolean bo = userService.userLogin(userName, userPass);
		
		if(bo) {
			
			//跳转登录成功之后的界面
			//获取数据库中的所有用户信息
			List<MyUser> userList = userService.getAllUserInfo();
			req.setAttribute("userList", userList);
			
			//跳转登录成功的界面
			req.getRequestDispatcher("success.jsp").forward(req, resp);
			
		}else {
			
			//跳转一个登录失败的界面
			req.setAttribute("massages", "账号或密码错误，登录失败！");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		}
		
	}
	
}

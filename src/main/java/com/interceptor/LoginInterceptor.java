package com.interceptor;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bean.Users;
import com.service.UsersService;

public class LoginInterceptor implements HandlerInterceptor{

	@Autowired
	private UsersService usersService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		if (request.getSession().getAttribute("users")!=null) {
			return true;
		}else {
			Users users=new Users();
			boolean autoLogin=false;
			if(request.getCookies().length>0) {
				for (Cookie cookie : request.getCookies()) {
					if (cookie.getName().equals("usernameCookie")) {
						users.setUsername(cookie.getValue());
						System.out.println("��ȡ���û���"+cookie.getValue());
					}
					if (cookie.getName().equals("passwordCookie")) {
						users.setPassword(cookie.getValue());
						System.out.println("��ȡ������"+cookie.getValue());
					}
					if (cookie.getName().equals("autoLoginCookie")) {
						autoLogin=Boolean.valueOf(cookie.getValue());
						System.out.println("��ȡ���Զ���¼"+cookie.getValue());
					}
				}
			}
			if (users.getUsername()!=null&&users.getPassword()!=null&&autoLogin==true) {
				System.out.println("�����Զ���¼");
				List<Users> list=usersService.login(users);
				if (list.size()>0) {
					System.out.println("������ȷ���Զ���¼");
					request.getSession().setAttribute("users", list.get(0));
					return true;
				}
			}
			System.out.println("��������������"+request.getRequestURL());
			response.sendRedirect(request.getContextPath()+"/login.jsp");
//			request.
			return false;
		}
		
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
}

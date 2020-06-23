package com.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Users;
import com.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping("login")
	@ResponseBody
	public String login(Users users,String[] isSavePassword,String[] autoLogin,HttpServletRequest request,HttpServletResponse response) {
		List<Users> list=usersService.login(users);
		if (list.size()>0) {
			System.out.println("密码正确");
			request.getSession().setAttribute("users", list.get(0));
			request.getParameter("");
			
//			String[] isSavePassword=request.getParameterValues("isSavePassword");
			if (isSavePassword!=null) {
				System.out.println("记住密码");
				Cookie usernameCookie=new Cookie("usernameCookie", users.getUsername());
				Cookie passwordCookie=new Cookie("passwordCookie", users.getPassword());
				usernameCookie.setMaxAge(864000);
				passwordCookie.setMaxAge(864000);
				response.addCookie(usernameCookie);
				response.addCookie(passwordCookie);
			}else {
				System.out.println("没有记住密码");
				Cookie[] cookies=request.getCookies();
				if (cookies!=null&&cookies.length>0) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("usernameCookie")||cookie.getName().equals("passwordCookie")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
//							System.out.println("已取消记住密码");
						}
					}
				}
			
			}
			
			if (autoLogin!=null) {
				System.out.println("自动登录");
				Cookie autoLoginCookie=new Cookie("autoLoginCookie", String.valueOf(true));
				autoLoginCookie.setMaxAge(864000);
				response.addCookie(autoLoginCookie);
			}else {
				System.out.println("没有自动登录");
				Cookie[] cookies=request.getCookies();
				if (cookies!=null&&cookies.length>0) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("autoLoginCookie")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
//							System.out.println("已取消记住密码");
						}
					}
				}
			
			}
			
			
			
			
			return "Success";
		}else {
			System.out.println("密码错误");
			return "Failure";
		}
		
	}
	
//	判断用户名是否已存在，存在返回false
	@RequestMapping("usernameDetection")
	@ResponseBody
	public boolean UsernameDetection(Users users) {
		if (usersService.UsernameDetection(users)) {
			return true;
		}
		return false;
	}
	
	
	
	@RequestMapping("register")
	@ResponseBody
	public String register(Users users) {
		
		if (usersService.register(users)) {
			System.out.println(users+"注册成功");
			return "success";
		}else {
			System.out.println(users+"注册失败");
			return "failure";
		}
		
	}
	
	@RequestMapping("isLogin")
	@ResponseBody
	public Users isLogin(HttpServletRequest request) {
		Users users=(Users) request.getSession().getAttribute("users");
		if (users!=null) {
			return users;
		}else {
			return null;
		}
	}
	
	
}

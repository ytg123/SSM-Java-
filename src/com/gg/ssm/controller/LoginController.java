package com.gg.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.ssm.entity.User;
import com.gg.ssm.service.UserService;

/**
 * 
 *   登录控制层
 * LoginController
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月1日-上午12:53:18 
 * @version 1.0.0
 *
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/gotoLogin")
	public String gotoLogin(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username,String password,Model model,HttpSession session,HttpServletRequest request){
		System.out.println("locale is"+request.getLocale());
		if(username != null && password != null){
			//将用户登录名放入到session中
			session.setAttribute("loginName", username);
			//调用服务层的登录方法
			boolean flag = this.userService.login(username, password);
			if(flag){
				return "redirect:pages/main.jsp";
			}else{
				model.addAttribute("logErr", "sysmanager.loginController.loginErr");
				return "forward:/pages/login.jsp";
			}
		}else{
			model.addAttribute("logErr", "sysmanager.loginController.loginErr");
			return "forward:/pages/login.jsp";
		}
	}
}

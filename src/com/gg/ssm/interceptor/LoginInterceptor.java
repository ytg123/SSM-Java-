package com.gg.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.ResultSetInternalMethods;
/**
 * 用于登录验证的拦截器
 * 
 * LoginInterceptor
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月2日-下午4:40:41 
 * @version 1.0.0
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		//先过滤匿名访问地址
		String url = request.getRequestURI();
		if(url.indexOf("login.do") >= 0){
			return true;
		}
		if(url.indexOf("gotoLogin") >= 0){
			return true;
		}
		//判断session中是否有用户信息,如果有继续往下执行,否则返回到登录页面
		HttpSession  session = request.getSession();
		String loginName = (String)session.getAttribute("loginName");
		if(loginName != null){
			return true;
		}else{
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		}
		
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	

}

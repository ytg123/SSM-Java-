package com.gg.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * springmvc 拦截器 Interceptor
 * Sinterceptor
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月2日-下午4:00:57 
 * @version 1.0.0
 *
 */
public class Sinterceptor implements HandlerInterceptor{
	static Logger log = Logger.getLogger(Sinterceptor.class);
	//在handler方法之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		log.info("preHandle,之前");
		return true;
	}
	//在执行handler方法中,返回ModelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception {
		log.info("postHandle之中");
		
	}
	//执行handler后执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception)
			throws Exception {
		log.info("afterCompletion之后");
		
	}

	

	

}

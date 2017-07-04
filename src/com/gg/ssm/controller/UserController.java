package com.gg.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gg.ssm.entity.User;
import com.gg.ssm.service.UserService;

/**
 * 
 * 用户列表
 * UserController
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月1日-下午4:17:02 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/sysmanager/user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 
	 * 进入到用户功能管理页面
	 * com.gg.ssm.controller 
	 * 方法名：gotoUser
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月1日-下午4:22:01 
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/gotoUser")
	public ModelAndView gotoUser(){
		int a = 1/0;
		ModelAndView modelAndView = new ModelAndView();
		List<User> list = this.userService.getUserList();
		modelAndView.addObject("userList", list);
		modelAndView.setViewName("sysmanger/user/userMain");
		return modelAndView; 
	}
	/**
	 * 
	 * 新增用户
	 * com.gg.ssm.controller 
	 * 方法名：addUser
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月1日-下午10:38:50 
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/addUser")
	public String addUser(@Validated User user,BindingResult bindingResult,Model model){
		//如果数据有异常,就将信息存放在bindingResult中的error对象中
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			model.addAttribute("errors", errors);
			return "sysmanger/user/userMain";
		}else{
			if(this.userService.addUser(user)){
				List<User> list = this.userService.getUserList();
				model.addAttribute("userList", list);
				return "sysmanger/user/userMain";
			}else{
				model.addAttribute("addErr", "添加失败!");	
				return "sysmanger/user/userMain";
			}
		}
		
	}
	/**
	 * 
	 * 通过用户id查询用户信息
	 * com.gg.ssm.controller 
	 * 方法名：getUserId
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月1日-下午11:45:09 
	 * @param id
	 * @param model
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	/*@RequestMapping("getUserId")
	public String getUserId(Integer id,Model model){
		User user = this.userService.getUserId(id);
		if(user != null){
			List<User> list = this.userService.getUserList();
			model.addAttribute("userList", list);
			model.addAttribute("user", user);
			return "sysmanger/user/userMain";
		}else{
			List<User> list = this.userService.getUserList();
			model.addAttribute("userList", list);
			model.addAttribute("addErr", "查询失败");
			return "sysmanger/user/userMain";
		}
		
	}*/
	/**
	 * 
	 * 通过id修改用户信息
	 * com.gg.ssm.controller 
	 * 方法名：upUserId
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月2日-上午12:11:59 
	 * @param user
	 * @param model
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/upUserId")
	public String upUserId(@Validated User user,BindingResult bindingResult,Model model){
		//如果数据有异常,就将信息存放在bindingResult中的error对象中
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			model.addAttribute("errors", errors);
			return "sysmanger/user/userMain"; 
		}else{
			if(this.userService.upUserId(user)){
				List<User> list = this.userService.getUserList();
				model.addAttribute("userList", list);
				return "sysmanger/user/userMain";
			}else{
				model.addAttribute("addErr", "修改失败!");	
				return "sysmanger/user/userMain";
			}
		}
	}
	/**
	 * 
	 * 通过id删除用户信息
	 * com.gg.ssm.controller 
	 * 方法名：delUserId
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月2日-上午12:44:10 
	 * @param id
	 * @param model
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("delUserId")
	public String delUserId(Integer id,Model model){
		if(this.userService.delUserId(id)){
			List<User> list = this.userService.getUserList();
			model.addAttribute("userList", list);
			return "sysmanger/user/userMain";
		}else{
			model.addAttribute("addErr", "修改失败!");	
			return "sysmanger/user/userMain";
		}
	}
	/**
	 * 
	 * 通过ajax请求删除数据
	 * com.gg.ssm.controller 
	 * 方法名：delUserJson
	 * 创建人:Tengguang Yang
	 * 手机：18734153794
	 * 时间：2017年7月2日-上午3:29:35 
	 * @param id
	 * @return Map<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("delUserJson")
	public @ResponseBody Map<String, Object> delUserJson(Integer id){
		Map<String, Object> resultMap = new HashMap<String,Object>();
		if(this.userService.delUserId(id)){
			resultMap.put("result", 1);
		}else{
			resultMap.put("result", 0);
		}
		return resultMap;
	}
	
	/**
	 * 
	 * 异常处理  @ExceptionHandler
	 */
	@ExceptionHandler(Exception.class)
	public String exHandle(HttpServletRequest request,Exception ex){
		request.setAttribute("exceptions", ex);
		return "/sysmanger/error/exHandle";
	}
}

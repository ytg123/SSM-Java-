package com.gg.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class UserControllerRestful {
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
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ModelAndView gotoUser(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> list = this.userService.getUserList();
		modelAndView.addObject("userList", list);
		modelAndView.setViewName("sysmanger/user/userMain-Restful");
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
	@RequestMapping(value="user",method=RequestMethod.POST)
	public String addUser(User user,Model model){
		if(this.userService.addUser(user)){
			List<User> list = this.userService.getUserList();
			model.addAttribute("userList", list);
			return "sysmanger/user/userMain-Restful";
		}else{
			model.addAttribute("addErr", "添加失败!");	
			return "sysmanger/user/userMain-Restful";
		}
	}
	
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
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public String upUserId(@PathVariable User user,Model model){
		if(this.userService.upUserId(user)){
			List<User> list = this.userService.getUserList();
			model.addAttribute("userList", list);
			return "sysmanger/user/userMain-Restful";
		}else{
			model.addAttribute("addErr", "修改失败!");	
			return "sysmanger/user/userMain-Restful";
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
	@RequestMapping(value="user/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> delUserJson(@PathVariable Integer id){
		System.out.println(id);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		if(this.userService.delUserId(id)){
			resultMap.put("result", 1);
		}else{
			resultMap.put("result", 0);
		}
		return resultMap;
	}
	
}

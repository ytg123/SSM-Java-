package com.gg.ssm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.ssm.entity.User;
import com.gg.ssm.mapper.UserMapper;
import com.gg.ssm.service.UserService;
/**
 * 
 * 服务层登录接口的实现类
 * UserServiceImpl
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月1日-上午1:37:30 
 * @version 1.0.0
 *
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	/**
	 * 登录功能
	 */
	@Override
	public boolean login(String username, String password) {
		boolean flag = false;
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setLoginName(username);
		user.setPassword(password);;
		userList = this.userMapper.login(user);
		if(userList.size()>0){
			flag = true;
		}
		return flag;
	}
	@Override
	/**
	 * 查询所有用户
	 */
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		userList = this.userMapper.getUserList();
		return userList;
	}
	/**
	 * 新增用户
	 */
	@Override
	public boolean addUser(User user) {
		boolean flag = false;
		int rows = this.userMapper.addUser(user);
		if(rows > 0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 通过用户id查询用户信息
	 */
	@Override
	public User getUserId(Integer id) {
		User user = this.userMapper.getUserId(id);
		return user;
	}
	/**
	 * 通过用户id修改用户信息
	 */
	@Override
	public boolean upUserId(User user) {
		boolean flag = false;
		int rows = this.userMapper.upUserId(user);
		if(rows > 0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 通过用户id删除用户信息
	 */
	@Override
	public boolean delUserId(Integer id) {
		boolean flag = false;
		int rows = this.userMapper.delUserId(id);
		if(rows > 0){
			flag = true;
		}
		return flag;
	}

}

package com.gg.ssm.service;

import java.util.List;

import com.gg.ssm.entity.User;

/**
 * 服务层登录接口
 * UserService
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月1日-上午1:03:09 
 * @version 1.0.0
 *
 */
public interface UserService {
	//登录
	public boolean login(String username,String password);
	//查询所有
	public List<User> getUserList();
	//新增用户
	public boolean addUser(User user);
	//通过用户ID查询用户信息
	public User getUserId(Integer id);
	//通过用户ID修改用户信息
	public boolean upUserId(User user);
	//通过用户ID删除用户信息
	public boolean delUserId(Integer id);
}

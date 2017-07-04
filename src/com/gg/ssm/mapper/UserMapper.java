package com.gg.ssm.mapper;
/**
 * 
 * Dao登录接口
 * UserMapper
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月1日-上午12:56:56 
 * @version 1.0.0
 *
 */

import java.util.List;

import com.gg.ssm.entity.User;

public interface UserMapper {
	//登录
	public List<User> login(User user);
	//查询所有
	public List<User> getUserList();
	//新增用户
	public int addUser(User user);
	//通过用户ID查询用户信息
	public User getUserId(Integer id);
	//通过用户ID修改用户信息
	public int upUserId(User user);
	//通过用户ID删除用户信息
	public int delUserId(Integer id);
}

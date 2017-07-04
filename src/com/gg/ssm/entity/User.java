package com.gg.ssm.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * 用户实体类  JavaBean
 * User
 * 创建人:Tengguang Yang
 * 手机：18734153794
 * 时间：2017年7月1日-上午12:55:20 
 * @version 1.0.0
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//构造函数
	public User(){}
	
	//私有属性
	private Integer id;
	@NotNull(message="用户名不能为空")
	private String userName;
	@NotEmpty(message="登录名不能为empty")
	private String loginName;
	private String password;
	private Integer age;
	private String sex;
	private Integer deptId;
	@JsonFormat(pattern="yy-mm-dd")
	@Past(message="此日期不可信")
	private Date birthday;
	private Date tvUpdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getTvUpdate() {
		return tvUpdate;
	}
	public void setTvUpdate(Date tvUpdate) {
		this.tvUpdate = tvUpdate;
	}

	
	
}

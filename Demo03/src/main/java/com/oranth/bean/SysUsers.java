package com.oranth.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 系统用户表
 * @author WU
 * 修改注释内容，测试提交
 */
@Component
public class SysUsers implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 866035761470722601L;
	private Integer usr_id;
	private String usr_name;
	private String usr_password;
	private Integer usr_role_id;
	private String user_name;//用户的名字
	private Integer usr_flag;
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_password() {
		return usr_password;
	}
	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}
	public Integer getUsr_role_id() {
		return usr_role_id;
	}
	public void setUsr_role_id(Integer usr_role_id) {
		this.usr_role_id = usr_role_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUsr_flag() {
		return usr_flag;
	}
	public void setUsr_flag(Integer usr_flag) {
		this.usr_flag = usr_flag;
	}
	public SysUsers(Integer usr_id, String usr_name, String usr_password, Integer usr_role_id, String user_name,
			Integer usr_flag) {
		super();
		this.usr_id = usr_id;
		this.usr_name = usr_name;
		this.usr_password = usr_password;
		this.usr_role_id = usr_role_id;
		this.user_name = user_name;
		this.usr_flag = usr_flag;
	}
	public SysUsers(String usr_name, String usr_password, Integer usr_role_id, String user_name, Integer usr_flag) {
		super();
		this.usr_name = usr_name;
		this.usr_password = usr_password;
		this.usr_role_id = usr_role_id;
		this.user_name = user_name;
		this.usr_flag = usr_flag;
	}
	public SysUsers() {
		super();
	}
	@Override
	public String toString() {
		return "SysUsers [usr_id=" + usr_id + ", usr_name=" + usr_name + ", usr_password=" + usr_password
				+ ", usr_role_id=" + usr_role_id + ", user_name=" + user_name + ", usr_flag=" + usr_flag + "]";
	}
}

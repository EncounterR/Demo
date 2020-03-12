package com.oranth.bean;


import org.springframework.stereotype.Component;

/**
 * 用户身份信息，存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * 
 * 
 */
@Component
public class ActiveUser {

	private int userid;// 用户id
	private String usercode;// 用户账号
	private String username;// 用户名称
	private Integer userRoleId;//用户所属角色id
	private SysRole sysRole;//用户所属角色id
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public SysRole getSysRole() {
		return sysRole;
	}
	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
	public ActiveUser(int userid, String usercode, String username, Integer userRoleId, SysRole sysRole) {
		super();
		this.userid = userid;
		this.usercode = usercode;
		this.username = username;
		this.userRoleId = userRoleId;
		this.sysRole = sysRole;
	}
	public ActiveUser() {
		super();
	}
	
	
	
}

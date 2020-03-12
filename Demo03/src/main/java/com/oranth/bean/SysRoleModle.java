package com.oranth.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 角色权限类
 * @author oracleOAEC
 *
 */
@Component
public class SysRoleModle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7862584560853655684L;
	private Integer role_id;
	private String right_code;
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRight_code() {
		return right_code;
	}
	public void setRight_code(String right_code) {
		this.right_code = right_code;
	}
	public SysRoleModle(Integer role_id, String right_code) {
		super();
		this.role_id = role_id;
		this.right_code = right_code;
	}
	public SysRoleModle() {
		super();
	}
	@Override
	public String toString() {
		return "SysRoleModle [role_id=" + role_id + ", right_code=" + right_code + "]";
	}
	
}

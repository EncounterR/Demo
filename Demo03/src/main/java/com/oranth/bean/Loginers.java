package com.oranth.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户活动表
 * @author WU
 *
 */
@Component
public class Loginers {
	private Integer id;//编号
	private String username;//用户名
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date datetime;//登陆时间
	private Integer user_role_id;//用户所属角色id
	public Integer getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public Loginers(String username, Date datetime, Integer user_role_id) {
		super();
		this.username = username;
		this.datetime = datetime;
		this.user_role_id = user_role_id;
	}
	public Loginers(Integer id, String username, Date datetime, Integer user_role_id) {
		super();
		this.id = id;
		this.username = username;
		this.datetime = datetime;
		this.user_role_id = user_role_id;
	}
	public Loginers() {
		super();
	}
	@Override
	public String toString() {
		return "Loginers [id=" + id + ", username=" + username + ", datetime=" + datetime + "]";
	}
	
}

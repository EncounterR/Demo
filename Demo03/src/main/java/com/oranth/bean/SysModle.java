package com.oranth.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 权限表 在权限表中修改，测试eclipse可以同步到此代码
 * @author WU
 *
 */
@Component
public class SysModle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5758195018819461760L;
	private String right_code;//权限编号
	private String right_parent_code;//模块父编号
	private String right_type;//权限类型
	private String right_url;//url
	private Integer right_order;//
	private String right_tip;//显示
	private String right_text;//权限名称
	private List<SysModle> sysModles;//二级菜单集合
	public String getRight_code() {
		return right_code;
	}
	public void setRight_code(String right_code) {
		this.right_code = right_code;
	}
	public String getRight_parent_code() {
		return right_parent_code;
	}
	public void setRight_parent_code(String right_parent_code) {
		this.right_parent_code = right_parent_code;
	}
	public String getRight_type() {
		return right_type;
	}
	public void setRight_type(String right_type) {
		this.right_type = right_type;
	}
	public String getRight_url() {
		return right_url;
	}
	public void setRight_url(String right_url) {
		this.right_url = right_url;
	}
	public Integer getRight_order() {
		return right_order;
	}
	public void setRight_order(Integer right_order) {
		this.right_order = right_order;
	}
	public String getRight_tip() {
		return right_tip;
	}
	public void setRight_tip(String right_tip) {
		this.right_tip = right_tip;
	}
	public String getRight_text() {
		return right_text;
	}
	public void setRight_text(String right_text) {
		this.right_text = right_text;
	}
	
	
	
	public List<SysModle> getSysModles() {
		return sysModles;
	}
	public void setSysModles(List<SysModle> sysModles) {
		this.sysModles = sysModles;
	}
	public SysModle(String right_code, String right_parent_code, String right_type, String right_url,
			Integer right_order, String right_tip, String right_text) {
		super();
		this.right_code = right_code;
		this.right_parent_code = right_parent_code;
		this.right_type = right_type;
		this.right_url = right_url;
		this.right_order = right_order;
		this.right_tip = right_tip;
		this.right_text = right_text;
	}
	
	public SysModle(String right_code, String right_parent_code, String right_type, String right_url, String right_tip,
			String right_text) {
		super();
		this.right_code = right_code;
		this.right_parent_code = right_parent_code;
		this.right_type = right_type;
		this.right_url = right_url;
		this.right_tip = right_tip;
		this.right_text = right_text;
	}
	public SysModle() {
		super();
	}
	@Override
	public String toString() {
		return "SysModle [right_code=" + right_code + ", right_parent_code=" + right_parent_code + ", right_type="
				+ right_type + ", right_url=" + right_url + ", right_order=" + right_order + ", right_tip=" + right_tip
				+ ", right_text=" + right_text + "]";
	}
	
}

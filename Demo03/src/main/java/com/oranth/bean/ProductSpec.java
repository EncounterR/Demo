package com.oranth.bean;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 商品规格表
 * @author WU
 *
 */
@Component
public class ProductSpec {
	private Integer spec_id;//规格编号
	private Integer spec_parent_id;//父编号
	private String spec_name;//规格名称
	private String spec_type;//规格类型
	private List<ProductSpec> plist;//二级规格的集合
	public Integer getSpec_id() {
		return spec_id;
	}
	public void setSpec_id(Integer spec_id) {
		this.spec_id = spec_id;
	}
	public Integer getSpec_parent_id() {
		return spec_parent_id;
	}
	public void setSpec_parent_id(Integer spec_parent_id) {
		this.spec_parent_id = spec_parent_id;
	}
	public String getSpec_name() {
		return spec_name;
	}
	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}
	public String getSpec_type() {
		return spec_type;
	}
	public void setSpec_type(String spec_type) {
		this.spec_type = spec_type;
	}
	
	public List<ProductSpec> getPlist() {
		return plist;
	}
	public void setPlist(List<ProductSpec> plist) {
		this.plist = plist;
	}
	public ProductSpec(Integer spec_parent_id, String spec_name, String spec_type) {
		super();
		this.spec_parent_id = spec_parent_id;
		this.spec_name = spec_name;
		this.spec_type = spec_type;
	}
	public ProductSpec(Integer spec_id, Integer spec_parent_id, String spec_name, String spec_type) {
		super();
		this.spec_id = spec_id;
		this.spec_parent_id = spec_parent_id;
		this.spec_name = spec_name;
		this.spec_type = spec_type;
	}
	public ProductSpec(Integer spec_id, Integer spec_parent_id, String spec_name, String spec_type,
			List<ProductSpec> plist) {
		super();
		this.spec_id = spec_id;
		this.spec_parent_id = spec_parent_id;
		this.spec_name = spec_name;
		this.spec_type = spec_type;
		this.plist = plist;
	}
	public ProductSpec() {
		super();
	}
	@Override
	public String toString() {
		return "ProductSpec [spec_id=" + spec_id + ", spec_parent_id=" + spec_parent_id + ", spec_name=" + spec_name
				+ ", spec_type=" + spec_type + "]";
	}
	
}

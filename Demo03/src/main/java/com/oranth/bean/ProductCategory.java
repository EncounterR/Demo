package com.oranth.bean;

import org.springframework.stereotype.Component;
/**
 * 商品分类表
 * @author WU
 *
 */
@Component
public class ProductCategory {
	private Integer id;//分类编号
	private String cate_name;//分类名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public ProductCategory(Integer id, String cate_name) {
		super();
		this.id = id;
		this.cate_name = cate_name;
	}
	public ProductCategory(String cate_name) {
		super();
		this.cate_name = cate_name;
	}
	public ProductCategory() {
		super();
	}
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", cate_name=" + cate_name + "]";
	}
	
}

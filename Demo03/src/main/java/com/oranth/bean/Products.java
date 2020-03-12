package com.oranth.bean;

import org.springframework.stereotype.Component;

/**
 * 商品表
 * @author WU
 *
 */
@Component
public class Products {
	private Integer prod_id;//商品编号
	private String prod_name;//商品名称
	private String prod_type;//商品分类编号
	private Double prod_price;//商品价格
	private Integer prod_number;//商品数量
	private Integer prod_flat;//商品状态
	private String prod_pic;//商品图片
	public Integer getProd_id() {
		return prod_id;
	}
	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_type() {
		return prod_type;
	}
	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}
	public Double getProd_price() {
		return prod_price;
	}
	public void setProd_price(Double prod_price) {
		this.prod_price = prod_price;
	}
	public Integer getProd_number() {
		return prod_number;
	}
	public void setProd_number(Integer prod_number) {
		this.prod_number = prod_number;
	}
	public Integer getProd_flat() {
		return prod_flat;
	}
	public void setProd_flat(Integer prod_flat) {
		this.prod_flat = prod_flat;
	}
	
	public String getProd_pic() {
		return prod_pic;
	}
	public void setProd_pic(String prod_pic) {
		this.prod_pic = prod_pic;
	}
	
	public Products(String prod_name, String prod_type, Double prod_price, Integer prod_number, Integer prod_flat,
			String prod_pic) {
		super();
		this.prod_name = prod_name;
		this.prod_type = prod_type;
		this.prod_price = prod_price;
		this.prod_number = prod_number;
		this.prod_flat = prod_flat;
		this.prod_pic = prod_pic;
	}
	public Products(Integer prod_id, String prod_name, String prod_type, Double prod_price, Integer prod_number,
			Integer prod_flat, String prod_pic) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_type = prod_type;
		this.prod_price = prod_price;
		this.prod_number = prod_number;
		this.prod_flat = prod_flat;
		this.prod_pic = prod_pic;
	}
	public Products() {
		super();
	}
	@Override
	public String toString() {
		return "Products [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_type=" + prod_type
				+ ", prod_price=" + prod_price + ", prod_number=" + prod_number + ", prod_flat=" + prod_flat
				+ ", prod_pic=" + prod_pic + "]";
	}
	
}

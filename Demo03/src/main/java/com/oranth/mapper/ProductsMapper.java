package com.oranth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oranth.bean.Products;

/**
 * 商品mapper接口
 * @author WU
 *
 */
@Mapper
public interface ProductsMapper {
	/**
	 * 获取全部商品信息
	 * @return 返回一个集合
	 */
	public List<Products> getAll();
	/**
	 * 根据商品id查询商品西悉尼
	 * @param prod_id
	 * @return
	 */
	public Products getProductsByProdId(Integer prod_id);
	/**
	 * 根据商品名查询商品信息
	 * @param prod_name
	 * @return
	 */
	public List<Products> getProductsByProdName(String prod_name);
	/**
	 * 增加商品信息
	 * @param product
	 * @return
	 */
	public Integer addProduct(Products product);
	/**
	 * 删除商品信息
	 * @param prod_id
	 * @return
	 */
	public Integer delProduct(Integer prod_id);
	/**
	 * 修改商品信息
	 * @param product
	 * @return
	 */
	public Integer editProducts(Products product);
}

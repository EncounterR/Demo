package com.oranth.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.oranth.bean.Products;

/**
 * 商品service接口
 * @author WU
 *
 */
public interface ProductsService {
	/**
	 * 获取全部商品信息
	 * @return 返回一个集合
	 */
	public List<Products> getAll();
	/**
	 * 分页查询商品信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Products> getProductsByPage(int pageNum, int pageSize);
	/**
	 * 根据商品id查询商品
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
	public boolean addProduct(Products product);
	/**
	 * 删除商品信息
	 * @param prod_id
	 * @return
	 */
	public boolean delProduct(Integer prod_id);
	/**
	 * 修改商品信息
	 * @param product
	 * @return
	 */
	public boolean editProducts(Products product);
}

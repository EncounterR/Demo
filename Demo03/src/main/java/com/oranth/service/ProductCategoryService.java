package com.oranth.service;

import java.util.List;

import com.oranth.bean.ProductCategory;

/**
 * 商品分类server层
 * @author WU
 *
 */
public interface ProductCategoryService {
	/**
	 * 获取全部商品分类信息
	 * @return
	 */
	public List<ProductCategory> getAll();
	/**
	 * 根据id查询商品分类信息
	 * @param id
	 * @return
	 */
	public ProductCategory getProductCategoryById(Integer id);
	/**
	 * 增加一个商品分类信息
	 * @param productCategory
	 * @return
	 */
	public boolean addProductCategory(ProductCategory productCategory);
	/**
	 * 删除一个商品分类
	 * @param id
	 * @return
	 */
	public boolean delProductCategory(Integer id);
	/**
	 * 修改商品分类
	 * @param productCategory
	 * @return
	 */
	public boolean editProductCategory(ProductCategory productCategory);
}

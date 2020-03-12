package com.oranth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oranth.bean.ProductCategory;

/**
 * 商品分类mapper层接口
 * @author WU
 *
 */
@Mapper
public interface ProductCategoryMapper {
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
	public Integer addProductCategory(ProductCategory productCategory);
	/**
	 * 删除一个商品分类
	 * @param id
	 * @return
	 */
	public Integer delProductCategory(Integer id);
	/**
	 * 修改商品分类
	 * @param productCategory
	 * @return
	 */
	public Integer editProductCategory(ProductCategory productCategory);
}

package com.oranth.service;

import java.util.List;

import com.oranth.bean.ProductSpec;

/**
 * 商品规格server接口
 * @author WU
 *
 */
public interface ProductSpecService {
	/**
	 * 获取全部商品规格信息
	 * @return
	 */
	public List<ProductSpec> getAll();
	/**
	 * 根据id查询商品规格信息
	 * @param spec_id
	 * @return
	 */
	public ProductSpec getProductSpecBySpecId(Integer spec_id);
	/**
	 * 根据父编号查询商品规格信息
	 * @param spec_parent_id
	 * @return
	 */
	public List<ProductSpec> getProductSpecBySpecParentId(Integer spec_parent_id);
	/**
	 * 添加商品规格信息
	 * @param productSpec
	 * @return
	 */
	public boolean addProductSpec(ProductSpec productSpec);
	/**
	 * 删除商品规格信息
	 * @param spec_id
	 * @return
	 */
	public boolean delProductSpec(Integer spec_id);
	/**
	 * 修改商品规格信息
	 * @param productSpec
	 * @return
	 */
	public boolean editProductSpec(ProductSpec productSpec);
	/**
	 * 获取全部父规格和其相应的子规格
	 * @return
	 */
	public List<ProductSpec> getProductSpec();
	/**
	 * 删除父规格后同时删除相应的子规格
	 * @param spec_id
	 * @return
	 */
	public boolean delProductSpecAndSonProductSpec(Integer spec_id);
	/**
	 * 删除子规格
	 * @param spec_id
	 * @return
	 */
	public boolean delSonProductSpec(Integer spec_id);
}

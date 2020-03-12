package com.oranth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oranth.bean.ProductSpec;

/**
 * 商品规格mapper接口
 * @author WU
 *
 */
@Mapper
public interface ProductSpecMapper {
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
	public Integer addProductSpec(ProductSpec productSpec);
	/**
	 * 删除商品规格信息
	 * @param spec_id
	 * @return
	 */
	public Integer delProductSpec(Integer spec_id);
	/**
	 * 根据spec_parent_id删除商品规格信息
	 * @param spec_parent_id父编号
	 * @return
	 */
	public Integer delSonProductSpec(Integer spec_parent_id);
	/**
	 * 修改商品规格信息
	 * @param productSpec
	 * @return
	 */
	public Integer editProductSpec(ProductSpec productSpec);
}

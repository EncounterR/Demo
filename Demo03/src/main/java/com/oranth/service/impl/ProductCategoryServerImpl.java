package com.oranth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oranth.bean.ProductCategory;
import com.oranth.mapper.ProductCategoryMapper;
import com.oranth.service.ProductCategoryService;

@Transactional
@Service
public class ProductCategoryServerImpl implements ProductCategoryService{
	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	@Override
	public List<ProductCategory> getAll() {
		return productCategoryMapper.getAll();
	}

	@Override
	public ProductCategory getProductCategoryById(Integer id) {
		return productCategoryMapper.getProductCategoryById(id);
	}

	@Override
	public boolean addProductCategory(ProductCategory productCategory) {
		int row=productCategoryMapper.addProductCategory(productCategory);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean delProductCategory(Integer id) {
		int row=productCategoryMapper.delProductCategory(id);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean editProductCategory(ProductCategory productCategory) {
		int row=productCategoryMapper.editProductCategory(productCategory);
		return (row == 1) ? true : false;
	}
}

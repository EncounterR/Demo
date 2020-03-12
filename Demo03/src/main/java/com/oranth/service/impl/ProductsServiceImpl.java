package com.oranth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oranth.bean.Products;
import com.oranth.mapper.ProductsMapper;
import com.oranth.service.ProductsService;
@Transactional
@Service
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	private ProductsMapper productsMapper;
	
	@Override
	public List<Products> getAll() {
		return productsMapper.getAll();
	}

	@Override
	public Products getProductsByProdId(Integer prod_id) {
		return productsMapper.getProductsByProdId(prod_id);
	}

	@Override
	public List<Products> getProductsByProdName(String prod_name) {
		return productsMapper.getProductsByProdName(prod_name);
	}

	@Override
	public boolean addProduct(Products product) {
		int row=productsMapper.addProduct(product);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean delProduct(Integer prod_id) {
		int row=productsMapper.delProduct(prod_id);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean editProducts(Products product) {
		int row=productsMapper.editProducts(product);
		return (row == 1) ? true : false;
	}

	@Override
	public PageInfo<Products> getProductsByPage(int pageNum, int pageSize) {
		// 第三方插件提供的方法
		PageHelper.startPage(pageNum, pageSize);
		// 调用Dao层方法 查询所有用户信息
		List<Products> ulist = productsMapper.getAll();
		// 将查询到的结构放入PageInfo里
		PageInfo<Products> pageInfo = new PageInfo<Products>(ulist);
		return pageInfo;
	}

}

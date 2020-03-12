package com.oranth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oranth.bean.ProductSpec;
import com.oranth.mapper.ProductSpecMapper;
import com.oranth.service.ProductSpecService;

@Transactional
@Service
public class ProductSpecServerImpl implements ProductSpecService {
	@Autowired
	private ProductSpecMapper productSpecMapper;

	@Override
	public List<ProductSpec> getAll() {
		return productSpecMapper.getAll();
	}

	@Override
	public ProductSpec getProductSpecBySpecId(Integer spec_id) {
		return productSpecMapper.getProductSpecBySpecId(spec_id);
	}

	@Override
	public List<ProductSpec> getProductSpecBySpecParentId(Integer spec_parent_id) {
		return productSpecMapper.getProductSpecBySpecParentId(spec_parent_id);
	}

	@Override
	public boolean addProductSpec(ProductSpec productSpec) {
		int row = productSpecMapper.addProductSpec(productSpec);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean delProductSpec(Integer spec_id) {
		int row = productSpecMapper.delProductSpec(spec_id);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean editProductSpec(ProductSpec productSpec) {
		int row = productSpecMapper.editProductSpec(productSpec);
		return (row == 1) ? true : false;
	}

	@Override
	public List<ProductSpec> getProductSpec() {
		List<ProductSpec> parplist = new ArrayList<ProductSpec>();
		List<ProductSpec> plist = productSpecMapper.getAll();
		// 获取到全部的父规格
		for (ProductSpec ps : plist) {
			if (ps.getSpec_parent_id() == -1) {
				parplist.add(ps);
			}
		}
		// 将父规格对应的子规格加入到父规格中
		for (ProductSpec ps : parplist) {
			List<ProductSpec> sonplist = new ArrayList<ProductSpec>();
			for (ProductSpec p : plist) {
				if (ps.getSpec_id() == p.getSpec_parent_id()) {
					sonplist.add(p);
				}
			}
			ps.setPlist(sonplist);
		}
		return parplist;
	}

	@Override
	public boolean delProductSpecAndSonProductSpec(Integer spec_id) {
		int row1 = productSpecMapper.delProductSpec(spec_id);
		int row2 = productSpecMapper.delSonProductSpec(spec_id);
		if (row1 > 0 && row2 > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delSonProductSpec(Integer spec_id) {
		int row = productSpecMapper.delSonProductSpec(spec_id);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

}

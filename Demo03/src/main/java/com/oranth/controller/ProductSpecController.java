package com.oranth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oranth.bean.ProductSpec;
import com.oranth.service.ProductSpecService;

/**
 * 商品规格控制器层
 * 
 * @author WU
 *
 */
@Controller
public class ProductSpecController {
	@Autowired
	private ProductSpecService productSpecService;

	/**
	 * 跳转到商品规格页面
	 * 
	 * @return
	 */
	@RequestMapping("productspec")
	public ModelAndView getAll() {
		List<ProductSpec> plist = productSpecService.getProductSpec();
		ModelAndView mv = new ModelAndView("productSpec");
		mv.addObject("productSpecs", plist);
		return mv;
	}

	/**
	 * 删除商品规格信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "doDelProSpec", method = RequestMethod.GET)
	public @ResponseBody boolean doDelProSpec(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		boolean flat = productSpecService.delProductSpecAndSonProductSpec(id);
		return flat;
	}

	/**
	 * 跳转到商品规格修改页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("ProSpecEdit")
	public ModelAndView proSpecEdit(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ProductSpec productSpec = productSpecService.getProductSpecBySpecId(id);
		List<ProductSpec> plist = productSpecService.getProductSpecBySpecParentId(id);
		productSpec.setPlist(plist);
		ModelAndView mv = new ModelAndView("productSpecEdit");
		mv.addObject("productSpec", productSpec);
		return mv;
	}

	/**
	 * 执行修改商品规格修改的操作
	 * 
	 * @param request
	 * @param spec_names 规格属性
	 * @return
	 */
	@RequestMapping(value = "doEditProductSpec", method = RequestMethod.POST)
	public ModelAndView doEditProductSpec(HttpServletRequest request, String[] spec_names) {
		Integer spec_id = Integer.parseInt(request.getParameter("spec_id"));
		String spec_name = request.getParameter("spec_name");
		boolean flat1 = productSpecService.delSonProductSpec(spec_id);
		if (flat1) {
			ProductSpec productSpec = new ProductSpec(spec_id, -1, spec_name, "父节点");
			boolean flat2 = productSpecService.editProductSpec(productSpec);
			int count = 0;
			if (flat2) {
				for (String str : spec_names) {
					ProductSpec productSpecson = new ProductSpec(spec_id, str, "子节点");
					boolean flat3 = productSpecService.addProductSpec(productSpecson);
					if (flat3) {
						count++;
					}
				}
			}
			if (count == spec_names.length) {
				List<ProductSpec> plist = productSpecService.getProductSpec();
				ModelAndView mv = new ModelAndView("productSpec");
				mv.addObject("productSpecs", plist);
				return mv;
			}
		}
		ModelAndView mv = new ModelAndView("productSpecEdit");
		return mv;
	}

	/**
	 * 跳转到商品规格添加页面
	 * 
	 * @return
	 */
	@RequestMapping("productSpecAdd")
	public String productSpecAdd() {
		return "productSpecAdd";
	}

	/**
	 * 执行添加商品规格添加的操作
	 * 
	 * @param request
	 * @param spec_names
	 * @return
	 */
	@RequestMapping(value = "doAddProductSpec", method = RequestMethod.POST)
	public ModelAndView doAddProductSpec(HttpServletRequest request, String[] spec_names) {
		String spec_name = request.getParameter("spec_name");
		ProductSpec productSpec = new ProductSpec(-1, spec_name, "父节点");
		boolean flat1 = productSpecService.addProductSpec(productSpec);
		int count = 0;
		if (flat1) {
			for (String str : spec_names) {
				ProductSpec productSpecSon = new ProductSpec(productSpec.getSpec_id(), str, "子节点");
				boolean flat2 = productSpecService.addProductSpec(productSpecSon);
				if (flat2) {
					count++;
				}
			}
		}
		if (count == spec_names.length) {
			List<ProductSpec> plist = productSpecService.getProductSpec();
			ModelAndView mv = new ModelAndView("productSpec");
			mv.addObject("productSpecs", plist);
			return mv;
		}
		ModelAndView mv = new ModelAndView("productSpecAdd");
		return mv;
	}
}

package com.oranth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oranth.bean.ProductCategory;
import com.oranth.service.ProductCategoryService;

/**
 * 商品分类控制层
 * @author WU
 *
 */
@Controller
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryServer;
	
	/**
	 * 跳转到商品分类页面
	 * @return
	 */
	@RequestMapping("productcate")
	public ModelAndView productCate() {
		List<ProductCategory> plist=productCategoryServer.getAll();
		ModelAndView mv=new ModelAndView("productCategory");
		mv.addObject("productCate",plist);
		return mv;
	}
	
	/**
	 * 删除商品分类
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doDelProductCategory",method = RequestMethod.POST)
	public @ResponseBody boolean doDelProductCategory(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		boolean flat=productCategoryServer.delProductCategory(id);
		return flat;
	}
	
	/**
	 * 跳转到商品分类添加页面
	 * @return
	 */
	@RequestMapping("productCategoryAdd")
	public String productCategoryAdd() {
		return "productCategoryAdd";
	}
	
	/**
	 * 执行添加商品分类的操作
	 * @param productCategory
	 * @return
	 */
	@RequestMapping(value="doProductCategoryAdd",method = RequestMethod.POST)
	public ModelAndView doProductCategoryAdd(ProductCategory productCategory) {
		boolean flat=productCategoryServer.addProductCategory(productCategory);
		if(flat) {
			List<ProductCategory> plist=productCategoryServer.getAll();
			ModelAndView mv=new ModelAndView("productCategory");
			mv.addObject("productCate",plist);
			return mv;
		}else {
			ModelAndView mv=new ModelAndView("productCategoryAdd");
			return mv;
		}
	}
	
	/**
	 * 跳转到修改商品分类页面
	 * @param request
	 * @return
	 */
	@RequestMapping("productCategoryEdit")
	public ModelAndView productCategoryEdit(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		ProductCategory productCategory=productCategoryServer.getProductCategoryById(id);
		ModelAndView mv=new ModelAndView("productCategoryEdit");
		mv.addObject("productCategory", productCategory);
		return mv;
	}
	
	/**
	 * 执行修改商品分类操作
	 * @param productCategory
	 * @return
	 */
	@RequestMapping(value="doProductCategoryEdit",method = RequestMethod.POST)
	public ModelAndView doProductCategoryEdit(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("cate_id"));
		String cate_name=request.getParameter("cate_name");
		ProductCategory productCategory=new ProductCategory(id,cate_name);
		boolean flat=productCategoryServer.editProductCategory(productCategory);
		if(flat) {
			List<ProductCategory> plist=productCategoryServer.getAll();
			ModelAndView mv=new ModelAndView("productCategory");
			mv.addObject("productCate",plist);
			return mv;
		}else {
			ModelAndView mv=new ModelAndView("productCategoryEdit");
			return mv;
		}
	}
}

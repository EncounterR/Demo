package com.oranth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 商品控制层
 * @author WU
 *
 */
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.oranth.bean.ProductCategory;
import com.oranth.bean.ProductSpec;
import com.oranth.bean.Products;
import com.oranth.service.ProductCategoryService;
import com.oranth.service.ProductSpecService;
import com.oranth.service.ProductsService;
import com.oranth.util.Upload;

@Controller
public class ProducusController {
	@Autowired
	private ProductsService productsService;
	@Autowired
	private ProductCategoryService productCategoryServer;
	@Autowired
	private ProductSpecService productSpecService;

	/**
	 * 跳转到商品管理页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("productlist")
	public ModelAndView getProductsByPage(HttpServletRequest request, HttpServletResponse response) {
		String page1 = request.getParameter("page");
		int page = 0;
		int maxSize = 0;
		if (page1 == null) {
			page = 1;
		} else {
			page = Integer.valueOf(page1).intValue();
		}
		List<Products> plist = productsService.getAll();
		if (plist.size() % 10 == 0) {
			maxSize = plist.size() / 10;
		} else {
			maxSize = plist.size() / 10 + 1;
		}
		ModelAndView mv = new ModelAndView("products");
		PageInfo<Products> pageInfo = productsService.getProductsByPage(page, 10);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("page", page);
		mv.addObject("maxSize", maxSize);
		return mv;
	}

	/**
	 * 跳转到商品添加页面
	 * 
	 * @return
	 */
	@RequestMapping("productsAdd")
	public ModelAndView productsAdd() {
		List<ProductCategory> plist=productCategoryServer.getAll();
		List<ProductSpec> pslist=productSpecService.getProductSpec();
		ModelAndView mv=new ModelAndView("productsAdd");
		mv.addObject("productCate",plist);
		mv.addObject("productSpec",pslist);
		return mv;
	}
	
	
	
	// 上传图片 img
	@RequestMapping("/fileUpload")
	@ResponseBody
	public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		//批量上传
        String  str = Upload.batchFileUpload(file);
        //输出新文件名
        System.out.println("新文件名:"+str);
        try {
			response.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 执行商品添加的操作
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "doProductsAdd",method = RequestMethod.POST)
	public ModelAndView doProductsAdd(Products product) {
		ModelAndView mv = new ModelAndView("products");
		productsService.addProduct(product);
		int page = 1;
		int maxSize = 0;
		List<Products> plist = productsService.getAll();
		if (plist.size() % 10 == 0) {
			maxSize = plist.size() / 10;
		} else {
			maxSize = plist.size() / 10 + 1;
		}
		PageInfo<Products> pageInfo = productsService.getProductsByPage(page, 10);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("page", page);
		mv.addObject("maxSize", maxSize);
		return mv;
	}
	
	/**
	 *删除商品信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doDelProduct",method = RequestMethod.POST)
	public @ResponseBody boolean doDelProduct(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		boolean flat=productsService.delProduct(id);
		return flat;
	}
}

package com.oranth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oranth.bean.SysModle;
import com.oranth.service.SysModleService;

/**
 * 权限控制层
 * @author WU
 *
 */
@Controller
public class SysModleController {
	@Autowired
	private SysModleService sysModleService;
	
	/**
	 * 获取全部权限信息
	 * @return
	 */
	@RequestMapping("modelList")
	public ModelAndView getAllSysModle() {
		List<SysModle> mlist=sysModleService.getAll();
		ModelAndView mv=new ModelAndView("sysModle");
		mv.addObject("sysModles", mlist);
		return mv;
	}
	
	/**
	 * 跳转到权限修改页面
	 * @param request
	 * @return
	 */
	@RequestMapping("sysModleEdit")
	public ModelAndView sysModleEdit(HttpServletRequest request) {
		String id=request.getParameter("id");
		SysModle sysModle=sysModleService.getSysModleByRightCode(id);
		ModelAndView mv=new ModelAndView("sysModleEdit");
		mv.addObject("sysModle", sysModle);
		return mv;
	}
	
	/**
	 * 执行权限修改的操作
	 * @param sysModle
	 * @return
	 */
	@RequestMapping(value="doSysModleEdit",method = RequestMethod.POST)
	public ModelAndView doSysModleEdit(SysModle sysModle) {
		sysModleService.editSysModle(sysModle);
		List<SysModle> mlist=sysModleService.getAll();
		ModelAndView mv=new ModelAndView("sysModle");
		mv.addObject("sysModles", mlist);
		return mv;
	}
	
	/**
	 * 删除权限
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doDelSysModle",method = RequestMethod.GET)
	public @ResponseBody boolean doDelSysModle(HttpServletRequest request) {
		String id=request.getParameter("id");
		boolean flat=sysModleService.delSysModle(id);
		return flat;
	}
	
}

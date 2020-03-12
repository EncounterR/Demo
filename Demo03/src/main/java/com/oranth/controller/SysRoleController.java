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
import com.oranth.bean.SysRole;
import com.oranth.bean.SysRoleModle;
import com.oranth.service.SysModleService;
import com.oranth.service.SysRoleService;

/**
 * 系统角色控制层
 * 
 * @author WU
 *
 */
@Controller
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysModleService sysModleService;

	/**
	 * 获取全部角色信息
	 * 
	 * @return
	 */
	@RequestMapping("rolelist")
	public ModelAndView getAllSysRole() {
		List<SysRole> rlist = sysRoleService.getAll();
		ModelAndView mv = new ModelAndView("sysRole");
		mv.addObject("SysRole", rlist);
		return mv;
	}

	/**
	 * 查看角色详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("detSysRole")
	public ModelAndView detSysRole(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		SysRole sysRole = sysRoleService.getSysRoleAndSysModleById(id);
		ModelAndView mv = new ModelAndView("sysRoleDet");
		mv.addObject("sysRole", sysRole);
		return mv;
	}

	/**
	 * 跳转到角色修改的页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("editSysRole")
	public ModelAndView editSysRole(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		SysRole sysRole = sysRoleService.getSysRoleAndSysModleById(id);
		List<SysModle> mlist = sysModleService.getMenus();
		ModelAndView mv = new ModelAndView("sysRoleEdit");
		mv.addObject("sysRole", sysRole);
		mv.addObject("sysModle", mlist);
		return mv;
	}

	/**
	 * 提交修改角色信息的请求
	 * @param role
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="doEditSysRole",method = RequestMethod.POST)
	public ModelAndView doEditSysRole(SysRole role, String[] ids) {
		int count = 0;
		boolean flat1 = sysRoleService.editSysRole(role);
		if (flat1) {
			if(ids!=null) {
				boolean flat2 = sysRoleService.delAllRoleModle(role.getRole_id());
				if (flat2) {
					for (String s : ids) {
						SysRoleModle sysRoleModle = new SysRoleModle(role.getRole_id(), s);
						boolean flat3 = sysRoleService.addSysRoleModle(sysRoleModle);
						if (flat3) {
							count++;
						}
					}
					if (count == ids.length) {
						ModelAndView mv = new ModelAndView("sysRoleDet");
						SysRole sysRole = sysRoleService.getSysRoleAndSysModleById(role.getRole_id());
						mv.addObject("sysRole", sysRole);
						return mv;
					}
				}
			}else {
				ModelAndView mv = new ModelAndView("sysRoleDet");
				SysRole sysRole = sysRoleService.getSysRoleAndSysModleById(role.getRole_id());
				mv.addObject("sysRole", sysRole);
				return mv;
			}		
		}
		return null;
	}

	/**
	 * 删除角色信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "doDelSysRole", method = RequestMethod.POST)
	public @ResponseBody boolean doDelSysRole(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		boolean flat = sysRoleService.delSysRole(id);
		return flat;
	}
	
	/**
	 * 跳转到角色添加页面
	 * @return
	 */
	@RequestMapping("sysRoleAdd")
	public ModelAndView sysRoleAdd() {
		List<SysModle> mlist = sysModleService.getMenus();
		ModelAndView mv=new ModelAndView("sysRoleAdd");
		mv.addObject("sysModle", mlist);
		return mv;
	}
	
	/**
	 * 执行角色添加的操作
	 * @param role
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="doSysRoleAdd",method = RequestMethod.POST)
	public ModelAndView doSysRoleAdd(SysRole role, String[] ids) {
		int count=0;
		boolean flat=sysRoleService.addSysRole(role);
		if(flat) {
			for (String s : ids) {
				System.out.println("-------"+role.getRole_id());
				SysRoleModle sysRoleModle = new SysRoleModle(role.getRole_id(), s);
				boolean flat3 = sysRoleService.addSysRoleModle(sysRoleModle);
				if (flat3) {
					count++;
				}
			}
			if (count == ids.length) {
				ModelAndView mv = new ModelAndView("sysRoleDet");
				SysRole sysRole = sysRoleService.getSysRoleAndSysModleById(role.getRole_id());
				mv.addObject("sysRole", sysRole);
				return mv;
			}
		}
		return null;
	}
}

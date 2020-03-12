package com.oranth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 系统用户controller
 * @author WU
 *
 */
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.oranth.bean.SysRole;
import com.oranth.bean.SysUsers;
import com.oranth.service.SysRoleService;
import com.oranth.service.SysUsersService;
import com.oranth.util.ExcelUtil;

@Controller
public class SysUsersController {
	@Autowired
	private SysUsersService sysUsersSer;
	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 显示自己的账户
	 * @param request
	 * @return
	 */
	@RequestMapping("myAccount")
	public ModelAndView showMyAccount(HttpServletRequest request) {
		String username =request.getParameter("username");
		SysUsers sysUser=sysUsersSer.getSysUsersByName(username);
		SysRole sysRole=sysRoleService.getSysRoleAndSysModleById(sysUser.getUsr_role_id());
		ModelAndView mv=new ModelAndView("sysUsersMyAccount");
		mv.addObject("sysUser",sysUser);
		mv.addObject("sysRole",sysRole);
		return mv;
	}
	/**
	 * 显示全部用户信息
	 * 
	 * @return 用户集合
	 */
	@RequestMapping("/allUsers")
	public ModelAndView getAllSysUsers() {
		ModelAndView mv = new ModelAndView("sysUsers");
		List<SysUsers> sulist = sysUsersSer.getAll();
		mv.addObject("sysUsers", sulist);
		System.out.println("显示系统用户信息");
		return mv;
	}

	/**
	 * 分页查询用户信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/userslist")
	public ModelAndView getUsersByPage(HttpServletRequest request, HttpServletResponse response) {
		String page1 = request.getParameter("page");
		int page = 0;
		int maxSize = 0;
		if (page1 == null) {
			page = 1;
		} else {
			page = Integer.valueOf(page1).intValue();
		}
		List<SysUsers> slist = sysUsersSer.getAll();
		if (slist.size() % 10 == 0) {
			maxSize = slist.size() / 10;
		} else {
			maxSize = slist.size() / 10 + 1;
		}
		ModelAndView mv = new ModelAndView("sysUsers");
		PageInfo<SysUsers> pageInfo = sysUsersSer.getUsersByPage(page, 10);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("page", page);
		mv.addObject("maxSize", maxSize);
		return mv;
	}
	
	/**
	 * 查看系统用户详情
	 * @param request
	 * @return 返回查询到的系统用户信息
	 */
	@RequestMapping(value = "/doSysuserDetail",method = RequestMethod.GET)
	public @ResponseBody SysUsers doSysuserDetail(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		SysUsers sysUser=sysUsersSer.getSysUsersById(id);
		return sysUser;
	}
	
	/**
	 * 跳转到系统用户修改的页面
	 * @param request
	 * @return
	 */
	@RequestMapping("sysUserEdit")
	public ModelAndView sysUserEdit(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		SysUsers sysUser=sysUsersSer.getSysUsersById(id);
		List<SysRole> rlist=sysRoleService.getAll();
		ModelAndView mv=new ModelAndView("sysUsersEdit");
		mv.addObject("sysUser", sysUser);
		mv.addObject("sysRoles", rlist);
		return mv;
	}
	
	/**
	 * 执行系统用户修改的操作
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value="doSysUserEdit",method = RequestMethod.POST)
	public ModelAndView doSysUserEdit(SysUsers sysUser) {
		if(sysUser.getUsr_role_id()==null) {
			sysUser.setUsr_role_id(sysUsersSer.getSysUsersById(sysUser.getUsr_id()).getUsr_role_id());
		}
		sysUsersSer.editSysUsers(sysUser);
		ModelAndView mv=new ModelAndView("sysUsersDet");
		SysUsers sysuser=sysUsersSer.getSysUsersById(sysUser.getUsr_id());
		mv.addObject("sysUser", sysuser);
		return mv;
	}
	
	/**
	 * 删除用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/doDelSysuser",method = RequestMethod.POST)
	public @ResponseBody boolean doDelSysuser(HttpServletRequest request) {
		Integer id=Integer.parseInt(request.getParameter("id"));
		boolean flat=sysUsersSer.delSysUsers(id);
		return flat;
	}
	
	/**
	 * 跳转到用户添加页面
	 * @return
	 */
	@RequestMapping("sysUserAdd")
	public ModelAndView sysUserAdd() {
		List<SysRole> rlist=sysRoleService.getAll();
		ModelAndView mv=new ModelAndView("sysUsersAdd");
		mv.addObject("sysRoles",rlist);
		return mv;
	}
	
	/**
	 * 执行添加系统用户的操作
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value="doAddSysUsers",method = RequestMethod.POST)
	public ModelAndView doAddSysUsers(SysUsers sysUser) {
		boolean flat=sysUsersSer.addSysUsers(sysUser);
		if(flat) {
			SysUsers sysuser=sysUsersSer.getSysUsersByName(sysUser.getUsr_name());
			ModelAndView mv=new ModelAndView("sysUsersDet");
			mv.addObject("sysUsers", sysuser);
			return mv;
		}
		ModelAndView mv=new ModelAndView("sysUsersAdd");
		return mv;
	}
	
	/**
	 * 根据用户名查询用户信息,添加用户时,防止出现用户名重复的情况
	 * @param request
	 * @return
	 */
	@RequestMapping(value="checkUsrname",method = RequestMethod.POST)
	public @ResponseBody boolean getSysUserByUsrName(HttpServletRequest request) {
		String usrName=request.getParameter("name");
		SysUsers sysUser=sysUsersSer.getSysUsersByName(usrName);
		if(sysUser==null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 将所有系统用户导出到excel表格中
	 * @param ids
	 * @param response
	 */
	@RequestMapping("toExcelAllSysUsers")
	public void doUploadSysUserToExcel(String[] ids,HttpServletResponse response) {
		String excelName = "系统用户表.xls";
        List<String> head=new ArrayList<String>();
        head.add("编号");
        head.add("用户名");
        head.add("密码");
        head.add("所属角色编号");
        head.add("姓名");
        head.add("账号状态");
        List<SysUsers> ulist=sysUsersSer.getAll();
        List<List<String>> body=new ArrayList<List<String>>();
        for(int i=0;i<ulist.size();i++) {
        	List<String> bodyValue=new ArrayList<String>();
        	bodyValue.add(ulist.get(i).getUsr_id().toString());
        	bodyValue.add(ulist.get(i).getUsr_name());
        	bodyValue.add(ulist.get(i).getUsr_password());
        	bodyValue.add(ulist.get(i).getUsr_role_id().toString());
        	bodyValue.add(ulist.get(i).getUser_name());
        	bodyValue.add(ulist.get(i).getUsr_flag().toString());
        	body.add(bodyValue);
        }
        
        HSSFWorkbook excel = ExcelUtil.expExcel(head,body);
        ExcelUtil.outFile(excel,"./"+excelName,response);
	}
}

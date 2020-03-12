package com.oranth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oranth.bean.SysUsers;
import com.oranth.mapper.SysUsersMapper;
import com.oranth.service.SysUsersService;

@Transactional
@Service
public class SysUsersServiceImpl implements SysUsersService {

	@Autowired
	private SysUsersMapper sysUsersMapper;

	@Override
	public List<SysUsers> getAll() {
		return sysUsersMapper.getAll();
	}

	@Override
	public SysUsers getSysUsersByName(String usr_name) {
		return sysUsersMapper.getSysUserByName(usr_name);
	}

	@Override
	public SysUsers getSysUsersById(Integer usr_id) {
		return sysUsersMapper.getSysUserById(usr_id);
	}

	@Override
	public boolean addSysUsers(SysUsers sysUsers) {
		int row = sysUsersMapper.addSysUser(sysUsers);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean delSysUsers(Integer usr_id) {
		int row = sysUsersMapper.delSysUser(usr_id);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean editSysUsers(SysUsers sysUsers) {
		int row = sysUsersMapper.editSysUser(sysUsers);
		return (row == 1) ? true : false;
	}

	@Override
	public List<SysUsers> getSysUsersByUsrRoleId(Integer usr_role_id) {
		return sysUsersMapper.getSysUserByUsrRoleId(usr_role_id);
	}

	@Override
	public SysUsers getSysUserBuUsernameAndPwd(String sysUsername, String pwd) {
		return sysUsersMapper.getSysUserBuUsernameAndPwd(sysUsername, pwd);
	}

	@Override
	public PageInfo<SysUsers> getUsersByPage(int pageNum, int pageSize) {
		// 第三方插件提供的方法
		PageHelper.startPage(pageNum, pageSize);
		// 调用Dao层方法 查询所有用户信息
		List<SysUsers> ulist = sysUsersMapper.getAll();
		// 将查询到的结构放入PageInfo里
		PageInfo<SysUsers> pageInfo = new PageInfo<SysUsers>(ulist);
		return pageInfo;
	}
}

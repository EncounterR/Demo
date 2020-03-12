package com.oranth.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oranth.bean.SysModle;
import com.oranth.bean.SysRole;
import com.oranth.bean.SysRoleModle;
import com.oranth.mapper.SysModleMapper;
import com.oranth.mapper.SysRoleMapper;
import com.oranth.mapper.SysRoleModleMapper;
import com.oranth.service.SysRoleService;

/**
 * 角色业务逻辑层实现类
 * @author oracleOAEC
 *
 */

@Transactional
@Service
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleMapper isroleDao;
	@Autowired
	private SysModleMapper sysModleMapper;
	@Autowired
	private SysRoleModleMapper sysRoleModleMapper;
	
	public List<SysRole> getAll() {
		return isroleDao.getAll();
	}

	public SysRole getSysRoleById(Integer role_id) {
		return isroleDao.getSysRoleByRoleId(role_id);
	}

	public boolean addSysRole(SysRole sysRole) {
		int row=isroleDao.addSysRole(sysRole);
		return (row==1)?true:false;
	}

	public boolean delSysRole(Integer role_id) {
		int row=isroleDao.delSysRole(role_id);
		return (row==1)?true:false;
	}

	public boolean editSysRole(SysRole sysRole) {
		int row=isroleDao.editSysRole(sysRole);
		return (row==1)?true:false;
	}

	@Override
	public boolean delAllRoleModle(Integer role_id) {
		int row=sysRoleModleMapper.delSysRoleModle(role_id);
		return (row>=1)?true:false;
	}

	@Override
	public SysRole getSysRoleAndSysModleById(Integer role_id) {
		SysRole sysRole=isroleDao.getSysRoleByRoleId(role_id);
		List<SysModle> mlist=sysModleMapper.getAllSysRoleModle(role_id);
		List<String> list1=new ArrayList<String>();
		for(SysModle sysModle:mlist) {
			String num=String.valueOf(sysModle.getRight_code().charAt(0));
			list1.add(num);
		}
		//使用hashset去掉重复
	    Set<String> set = new HashSet<String>(list1);
	    // 得到去重后的新集合
	    List<String> newList = new ArrayList<String>(set);
	    List<SysModle> sonSysModle=null;
	    List<SysModle> parentSysModle=new ArrayList<SysModle>();
	    for(String s:newList) {
	    	SysModle sysModle1=sysModleMapper.getSysModleByRightCode(s);
	    	sonSysModle=new ArrayList<SysModle>();
	    	for(SysModle sysModle:mlist) {
	    		if(sysModle1.getRight_code().equals(sysModle.getRight_parent_code())) {
	    			sonSysModle.add(sysModle);
	    		}
	    		sysModle1.setSysModles(sonSysModle);
	    	}
	    	parentSysModle.add(sysModle1);
	    }
	    sysRole.setMlist(parentSysModle);
		return sysRole;
	}

	@Override
	public boolean addSysRoleModle(SysRoleModle sysRoleModle) {
		int row=sysRoleModleMapper.addSysRoleModle(sysRoleModle);
		return (row==1)?true:false;
	}
}

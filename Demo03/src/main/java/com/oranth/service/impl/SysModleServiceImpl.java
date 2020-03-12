package com.oranth.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oranth.bean.SysModle;
import com.oranth.mapper.SysModleMapper;
import com.oranth.service.SysModleService;

@Transactional
@Service
public class SysModleServiceImpl implements SysModleService {
	
	@Autowired
	private SysModleMapper imodleDao;

	public List<SysModle> getSysModleByUserId(Integer user_id) {
		List<SysModle> sysModles = imodleDao.getSysModleByUserId(user_id);
		// 创一个list集合来存储该用户的二级菜单的编号
		List<String> rightParentCodes = new ArrayList<String>();
		for (SysModle s : sysModles) {
			rightParentCodes.add(s.getRight_parent_code());
		}
		// 去除集合中重复的数据，来得到父节点的编号
		for (int i = 0; i < rightParentCodes.size() - 1; i++) {
			for (int j = rightParentCodes.size() - 1; j > i; j--) {
				if (rightParentCodes.get(j).equals(rightParentCodes.get(i))) {
					rightParentCodes.remove(j);
				}
			}
		}
		List<SysModle> slist = new ArrayList<SysModle>();
		for (String i : rightParentCodes) {
			SysModle menuBig = imodleDao.getSysModleByRightCode(i);
			List<SysModle> menuSmall=imodleDao.getSysModleByRightParentCode(menuBig.getRight_code());
			menuBig.setSysModles(menuSmall);
			slist.add(menuBig);
		}
		return slist;
	}

	public List<SysModle> getSysModleByRightParentCode(String right_parent_code) {
		return imodleDao.getSysModleByRightParentCode(right_parent_code);
	}

	public List<SysModle> getPermissionsByUserId(Integer user_id) {
		return imodleDao.getSysModleByUserId(user_id);
	}

	public boolean addSysModle(SysModle sysModle) {
		int row=imodleDao.addSysModle(sysModle);
		return (row==1)?true:false;
	}

	public boolean delSysModle(String right_code) {
		int row=imodleDao.delSysModle(right_code);
		return (row==1)?true:false;
	}

	public boolean editSysModle(SysModle sysModle) {
		int row=imodleDao.editSysModle(sysModle);
		return (row==1)?true:false;
	}

	public List<SysModle> getAll() {
		return imodleDao.getAll();
	}

	public SysModle getSysModleByRightCode(String right_code) {
		return imodleDao.getSysModleByRightCode(right_code);
	}
	
	public List<SysModle> getMenus() {
		List<SysModle> bigMenus=imodleDao.getMenus();
		for(SysModle s:bigMenus) {
			List<SysModle> smallMenus=imodleDao.getSysModleByRightParentCode(s.getRight_code());
			s.setSysModles(smallMenus);
		}
		return bigMenus;
	}

	public List<SysModle> getAllSysRoleModle(Integer role_id) {
		return imodleDao.getAllSysRoleModle(role_id);
	}
}

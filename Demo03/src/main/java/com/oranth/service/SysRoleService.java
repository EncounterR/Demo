package com.oranth.service;

import java.util.List;

import com.oranth.bean.SysRole;
import com.oranth.bean.SysRoleModle;


/**
 * 角色业务逻辑层
 * @author oracleOAEC
 *
 */
public interface SysRoleService {
	/**
	 * 获取所有角色信息
	 * @return 返回一个集合
	 */
	public List<SysRole> getAll();
	/**
	 * 通过角色id查询角色信息
	 * @param role_id 角色id
	 * @return 返回一个角色对象
	 */
	public SysRole getSysRoleById(Integer role_id);
	/**
	 * 通过角色id查询角色信息及该角色所拥有的权限
	 * @param role_id 角色id
	 * @return 返回一个角色对象
	 */
	public SysRole getSysRoleAndSysModleById(Integer role_id);
	/**
	 * 增加角色信息
	 * @param sysRole 角色对象
	 * @return true表示操作成功 ，false表示操作失败
	 */
	public boolean addSysRole(SysRole sysRole);
	/**
	 * 删除角色信息
	 * @param role_id 角色id
	 * @return true表示操作成功 ，false表示操作失败
	 */
	public boolean delSysRole(Integer role_id);
	/**
	 * 修改角色信息
	 * @param sysRole 角色对象
	 * @return true表示操作成功 ，false表示操作失败
	 */
	public boolean editSysRole(SysRole sysRole);
	/**
	 * 根据角色id删除该角色的全部权限信息
	 * @param role_id 角色编号
	 * @return true表示操作成功 ，false表示操作失败
	 */
	public boolean delAllRoleModle(Integer role_id);
	/**
	 * 添加角色权限信息 
	 * @param sysRoleModle 角色权限对象
	 * @return 返回受影响的行数 0表示添加成功 ，1表示添加失败
	 */
	public boolean addSysRoleModle(SysRoleModle sysRoleModle);
}

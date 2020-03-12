package com.oranth.service;

import java.util.List;

import com.oranth.bean.SysModle;


public interface SysModleService {
	/**
	 * 根据用户id查询获取该用户的菜单
	 * 
	 * @param user_id
	 *            用户权限
	 * @return 返回权限集合
	 */
	public List<SysModle> getSysModleByUserId(Integer user_id);
	/**
	 * 根据子节点查询权限信息
	 * @param right_parent_code 子节点
	 * @return 返回一个权限集合
	 */
	public List<SysModle> getSysModleByRightParentCode(String right_parent_code);
	/**
	 * 根据用户id查询获取该用户的权限
	 * 
	 * @param user_id
	 *            用户id
	 * @return 返回权限集合
	 */
	public List<SysModle> getPermissionsByUserId(Integer user_id);
	/**
	 * 增加权限信息
	 * @param sysModle 权限对象
	 * @return true操作成功，false操作失败
	 */
	public boolean addSysModle(SysModle sysModle);
	/**
	 * 删除权限信息
	 * @param right_code 权限编号
	 * @return true操作成功，false操作失败
	 */
	public boolean delSysModle(String right_code);
	/**
	 * 修改权限信息
	 * @param sysModle 权限对象
	 * @return true操作成功，false操作失败
	 */
	public boolean editSysModle(SysModle sysModle);
	/**
	 * 获得所有权限信息
	 * @return 返回一个集合
	 */
	public List<SysModle> getAll();
	/**
	 * 通过父节点查询权限信息
	 * @param right_code 父节点
	 * @return 返回一个权限对象
	 */
	public SysModle getSysModleByRightCode(String right_code);
	/**
	 * 获取所有菜单信息，包括一级菜单和二级菜单
	 * @return 返回一个集合
	 */
	public List<SysModle> getMenus();
	/**
	 * 根据角色id获取该角色所有权限信息
	 * @param role_id 角色id
	 * @return 返回一个权限集合
	 */
	public List<SysModle> getAllSysRoleModle(Integer role_id);
}

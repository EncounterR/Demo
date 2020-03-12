package com.oranth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oranth.bean.SysModle;


/**
 * 权限接口
 * @author oracleOAEC
 *
 */
@Mapper
public interface SysModleMapper {
	/**
	 * 获得所有权限信息
	 * @return 返回一个权限集合
	 */
	public List<SysModle> getAll();
	/**
	 * 通过父节点查询权限信息
	 * @param right_code 父节点
	 * @return 返回权限对象
	 */
	public SysModle getSysModleByRightCode(String right_code);
	/**
	 * 根据子节点查询权限信息
	 * @param right_parent_code 子节点
	 * @return 返回一个权限集合
	 */
	public List<SysModle> getSysModleByRightParentCode(String right_parent_code);
	/**
	 * 增加权限信息
	 * @param sysModle 权限对象
	 * @return 返回受影响的行数 0表示添加成功 ，1表示添加失败
	 */
	public int addSysModle(SysModle sysModle);
	/**
	 * 根据right_code删除权限信息
	 * @param right_code 父节点
	 * @return 返回受影响的行数 0表示删除成功 ，1表示删除失败
	 */
	public int delSysModle(String right_code);
	/**
	 * 修改权限信息
	 * @param sysModle 权限对象
	 * @return 返回受影响的行数 0表示修改成功 ，1表示修改失败
	 */
	public int editSysModle(SysModle sysModle);
	/**
	 * 根据用户id查询权限
	 * @param user_id 用户权限
	 * @return 返回权限集合
	 */
	public List<SysModle> getSysModleByUserId(Integer user_id);
	/**
	 * 获取所有一级菜单
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

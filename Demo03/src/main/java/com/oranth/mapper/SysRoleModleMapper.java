package com.oranth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oranth.bean.SysRoleModle;


/**
 * 角色权限接口
 * @author oracleOAEC
 *
 */
@Mapper
public interface SysRoleModleMapper {
	/**
	 * 获取所有角色权限
	 * @return 返回一个角色权限的集合
	 */
	public List<SysRoleModle> getAll();
	/**
	 * 通过角色id查询角色权限信息
	 * @param role_id 角色id
	 * @return 返回一个角色权限的集合
	 */
	public List<SysRoleModle> getSysRoleModleByRoleId(Integer role_id);
	/**
	 * 添加角色权限信息 
	 * @param sysRoleModle 角色权限对象
	 * @return 返回受影响的行数 0表示添加成功 ，1表示添加失败
	 */
	public int addSysRoleModle(SysRoleModle sysRoleModle);
	/**
	 * 删除角色权限信息
	 * @param role_id 角色id
	 * @return 返回受影响的行数 0表示删除成功 ，1表示删除失败
	 */
	public int delSysRoleModle(Integer role_id);
	/**
	 * 修改角色权限信息
	 * @param sysRoleModle 角色权限对象
	 * @return 返回受影响的行数 0表示修改成功 ，1表示修改失败
	 */
	public int editSysRoleModle(SysRoleModle sysRoleModle);
}

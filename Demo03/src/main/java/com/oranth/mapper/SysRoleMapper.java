package com.oranth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oranth.bean.SysRole;


/**
 * 角色接口
 * @author oracleOAEC
 *
 */
@Mapper
public interface SysRoleMapper {
	/**
	 * 获得所有角色信息
	 * @return 返回一个角色集合
	 */
	public List<SysRole> getAll();
	/**
	 * 通过角色id查询角色信息
	 * @param role_id 角色id
	 * @return 返回一个角色对象
	 */
	public SysRole getSysRoleByRoleId(Integer role_id);
	/**
	 * 增加角色信息
	 * @param sysRole 角色对象
	 * @return 返回受影响的行数 0表示添加成功 ，1表示添加失败
	 */
	public int addSysRole(SysRole sysRole);
	/**
	 * 根据角色id删除角色
	 * @param role_id 角色id
	 * @return 返回受影响的行数 0表示删除成功 ，1表示删除失败
	 */
	public int delSysRole(Integer role_id);
	/**
	 * 修改角色信息
	 * @param sysRole 角色对象
	 * @return 返回受影响的行数 0表示修改成功 ，1表示修改失败
	 */
	public int editSysRole(SysRole sysRole);
}

package com.oranth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oranth.bean.SysUsers;
/**
 * 系统用户接口
 * @author WU
 *
 */

@Mapper
public interface SysUsersMapper {
	/**
	 * 获得所有用户信息
	 * @return 返回一个用户集合
	 */
	public List<SysUsers> getAll();
	/**
	 * 通过用户名查找用户信息
	 * @param usr_name 用户名
	 * @return 返回一个用户对象
	 */
	public SysUsers getSysUserByName(String usr_name);
	/**
	 * 通过用户id查询用户信息
	 * @param usr_id 用户id
	 * @return 返回一个用户对象
	 */
	public SysUsers getSysUserById(Integer usr_id);
	/**
	 * 增加用户信息
	 * @param sysUser 用户对象
	 * @return 返回受影响的行数 0表示添加成功 ，1表示添加失败
	 */
	public int addSysUser(SysUsers sysUser);
	/**
	 * 根据用户ID删除用户信息
	 * @param usr_id 用户id
	 * @return 返回受影响的行数 0表示删除成功 ，1表示删除失败
	 */
	public int delSysUser(Integer usr_id);
	/**
	 * 修改用户信息
	 * @param sysUser 用户对象
	 * @return 返回受影响的行数 0表示修改成功 ，1表示修改失败
	 */
	public int editSysUser(SysUsers sysUser);
	/**
	 * 根据角色id查询用户信息
	 * @param usr_role_id 角色id
	 * @return 返回一个集合
	 */
	public List<SysUsers> getSysUserByUsrRoleId(Integer usr_role_id);
	/**
	 * 通过账号获取密码
	 * @param sysUsername
	 * @return
	 */
	public String getPwdBySysUsername(String usr_name);
	/**
	 * 通过账号获取角色
	 * @param sysUsername
	 * @return
	 */
	public String getRoleBySysUserName(String usr_name);
	/**
	 * 通过用户名和密码查询用户
	 * @param sysUsername
	 * @param pwd
	 * @return
	 */
	public SysUsers getSysUserBuUsernameAndPwd(String usr_name,String usr_password);
}

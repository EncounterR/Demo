package com.oranth.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.oranth.bean.SysUsers;
/**
 * 系统用户service接口
 * @author WU
 *
 */
public interface SysUsersService {
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
	public SysUsers getSysUsersByName(String usr_name);
	/**
	 * 通过用户id查询用户信息
	 * @param usr_id 用户id
	 * @return 返回一个用户对象
	 */
	public SysUsers getSysUsersById(Integer usr_id);
	/**
	 * 增加用户信息
	 * @param SysUsers 用户信息
	 * @return true添加成功 false 添加失败
	 */
	public boolean addSysUsers(SysUsers SysUsers);
	/**
	 * 删除用户信息
	 * @param usr_id 用户id
	 * @return true删除成功  false删除失败
	 */
	public boolean delSysUsers(Integer usr_id);
	/**
	 * 修改用户信息
	 * @param SysUsers用户信息
	 * @return true修改成功 false 修改失败
	 */
	public boolean editSysUsers(SysUsers SysUsers);
	/**
	 * 分页查询所有用户信息
	 * @return 返回一个PageInfo集合
	 */
	public PageInfo<SysUsers> getUsersByPage(int pageNum, int pageSize);
	/**
	 * 根据角色id查询用户信息
	 * @param usr_role_id 角色id
	 * @return 返回一个集合
	 */
	public List<SysUsers> getSysUsersByUsrRoleId(Integer usr_role_id);
	/**
	 * 通过用户名和密码查询用户
	 * @param sysUsername
	 * @param pwd
	 * @return
	 */
	public SysUsers getSysUserBuUsernameAndPwd(String sysUsername,String pwd);
}

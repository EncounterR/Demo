package com.oranth.service;

import java.util.List;

import com.oranth.bean.Loginers;
/**
 * 用户活动service层
 * @author WU
 *
 */
public interface LoginersService {
	/**
	 * 获取全部用户活动信息
	 * @return 返回一个集合
	 */
	public List<Loginers> getAll();
	/**
	 * 根据编号查询用户活动信息
	 * @param id 编号
	 * @return 返回一个集合
	 */
	public List<Loginers> getLoginersById(Integer id);
	/**
	 * 根据用户所属角色id查询用户活动信息
	 * @param user_role_id 所属角色id
	 * @return 返回一个集合
	 */
	public List<Loginers> getLoginersByUserRoleId(Integer user_role_id);
	/**
	 * 新增用户活动信息
	 * @param loginer
	 * @return 
	 */
	public boolean addLoginer(Loginers loginer);
	/**
	 * 删除用户活动信息
	 * @param id 编号
	 * @return 
	 */
	public boolean delLoginer(Integer id);
	/**
	 * 修改用户活动信息
	 * @param loginer
	 * @return 
	 */
	public boolean editLoginer(Loginers loginer);
	/**
	 * 获取最新的五条用户活动信息
	 * @return
	 */
	public List<Loginers> getLoginersByNew();
	/**
	 * 获取某位用户最新的五条用户活动记录
	 * @param username
	 * @return
	 */
	public List<Loginers> getLoginersByNewAndUsername(String username);
}

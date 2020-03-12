package com.oranth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oranth.bean.Loginers;
import com.oranth.mapper.LoginersMapper;
import com.oranth.service.LoginersService;
@Transactional
@Service
public class LoginersServiceImpl implements LoginersService{
	@Autowired
	private LoginersMapper loginersMapper;
	@Override
	public List<Loginers> getAll() {
		return loginersMapper.getAll();
	}

	@Override
	public List<Loginers> getLoginersById(Integer id) {
		return loginersMapper.getLoginersById(id);
	}

	@Override
	public List<Loginers> getLoginersByUserRoleId(Integer user_role_id) {
		return loginersMapper.getLoginersByUserRoleId(user_role_id);
	}

	@Override
	public boolean addLoginer(Loginers loginer) {
		int row=loginersMapper.addLoginer(loginer);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean delLoginer(Integer id) {
		int row=loginersMapper.delLoginer(id);
		return (row == 1) ? true : false;
	}

	@Override
	public boolean editLoginer(Loginers loginer) {
		int row=loginersMapper.editLoginer(loginer);
		return (row == 1) ? true : false;
	}

	@Override
	public List<Loginers> getLoginersByNew() {
		return loginersMapper.getLoginersByNew();
	}

	@Override
	public List<Loginers> getLoginersByNewAndUsername(String username) {
		return loginersMapper.getLoginersByNewAndUsername(username);
	}

}

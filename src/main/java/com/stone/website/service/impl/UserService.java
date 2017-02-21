package com.kpap.website.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpap.basis.dao.SysUserLogMapper;
import com.kpap.basis.dao.SysUserMapper;
import com.kpap.basis.model.SysUser;
import com.kpap.basis.model.SysUserExample;
import com.kpap.basis.model.SysUserLog;
import com.kpap.website.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	public SysUserMapper userMapper;
	
	@Autowired
	public SysUserLogMapper userLogMapper;
	
	public SysUser getUserByCode(String userCode){
		return userMapper.selectByPrimaryKey(userCode);
	}
	
	public void updateUser(SysUser user){
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	public List<SysUser> getUsers(){
		return userMapper.selectByExample(new SysUserExample());
	}
	
	public void loginLog(String userCode,String result,String reason){
		SysUserLog userLog=new SysUserLog();
		userLog.setUserCode(userCode);
		userLog.setLoginDate(new Date());
		userLog.setLoginResult(result);
		userLog.setFailReason(reason);
		userLogMapper.insertSelective(userLog);
		
	}
	
	public List<SysUser> getAuditors(){
		SysUserExample example=new SysUserExample();
		example.createCriteria().andRoleEqualTo(SysUser.role_1);
		return userMapper.selectByExample(example);
	}
}

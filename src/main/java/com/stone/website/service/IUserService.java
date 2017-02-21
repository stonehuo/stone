package com.kpap.website.service;

import java.util.List;

import com.kpap.basis.model.SysUser;

public interface IUserService {
	public SysUser getUserByCode(String userCode);
	public void updateUser(SysUser user);
	public List<SysUser> getUsers();
	public void loginLog(String userCode,String result,String reason);
	public List<SysUser> getAuditors();
}

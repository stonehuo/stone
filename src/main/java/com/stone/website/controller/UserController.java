package com.kpap.website.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kpap.basis.model.SysUser;
import com.kpap.website.service.IUserService;

@Controller
public class UserController {
	@Autowired
	public IUserService userService;
	/**
	 * 登陆页
	 * @return
	 */
	@RequestMapping(value="/users")
	public String users(String role) {
		if(StringUtils.equalsIgnoreCase(role, SysUser.role_1)){
			return "user/usermanager_1";
		}
		
		return "user/usermanager_2";
	}
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping(value="/useradd")
	public String userAdd(){
		return "user/user_add";
	}
	@RequestMapping(value="/userList")
	public @ResponseBody Map<String, Object> getUsers(){
		Map<String, Object> returnMap=new HashMap<String, Object>();
		List<SysUser> users=userService.getUsers();
		returnMap.put("total", 50);
		returnMap.put("rows", users);
		return returnMap;
	}
}

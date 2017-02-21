package com.kpap.website.controller;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kpap.basis.model.Pro;
import com.kpap.basis.model.SysUser;
import com.kpap.basis.model.SysUserLog;
import com.kpap.basis.util.CacheUtil;
import com.kpap.common.dto.SearchKey;
import com.kpap.common.service.IBaseService;
import com.kpap.common.util.ResultMap;
import com.kpap.website.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	public IUserService userService;
	
	@Autowired
	public IBaseService baseService;
	/**
	 * 登陆页
	 * @return
	 */
	@RequestMapping(value="/login")
	public String loginView() {
		return "login";
	}
	/**
	 * 用户登录
	 * @param userCode
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/ajax/login")
	public @ResponseBody ResultMap login(String userCode,String password,HttpSession session) {
		SysUser sysUser=(SysUser)session.getAttribute("user");
		SysUser user=userService.getUserByCode(userCode);
		if (user==null) {
			userService.loginLog(userCode, SysUserLog.loginResult_fail, ResultMap.result_2.getMessage());
			return ResultMap.result_2;
		}
		if(!user.getPassword().equals(password)){
			userService.loginLog(userCode, SysUserLog.loginResult_fail, ResultMap.result_2.getMessage());
			return ResultMap.result_2;
		}
		//同一个管理员账号限制最多两次登录
		if(SysUser.role_0.equalsIgnoreCase(user.getRole()) && (sysUser==null || !StringUtils.equalsIgnoreCase(sysUser.getUserCode(), user.getUserCode()))){
			if(!CacheUtil.getInstance().addAdmin(userCode)){
				return ResultMap.result_5;
			}
		}
		session.setAttribute("user", user);
		/*session.setMaxInactiveInterval(720);*/
		
		userService.loginLog(userCode, SysUserLog.loginResult_success,null);
		return ResultMap.getDefaultResultMap();
	}
	/**
	 * 用户退出
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginout")
	public String loginout(HttpSession session) {
		SysUser user=(SysUser)session.getAttribute("user");
		CacheUtil.getInstance().removeAdmin(user.getUserCode());
		
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/login"; 
	}
	@RequestMapping(value="/homeadmin")
	public  String homeAdmin(HttpSession session,Model model)throws Exception{
		SysUser user=(SysUser)session.getAttribute("user");
		model.addAttribute("user", user);
		
		SearchKey searchKey=new SearchKey();
		searchKey.setRole(SysUser.role_1);
		int count_1=baseService.countBySearchKey(searchKey, SysUser.class.getName());
		searchKey.setRole(SysUser.role_2);
		int count_2=baseService.countBySearchKey(searchKey, SysUser.class.getName());
		model.addAttribute("count_1", count_1);
		model.addAttribute("count_2", count_2);
		
		SearchKey searchKey_pro=new SearchKey();
		searchKey_pro.setStatus(Arrays.asList("0","1","2","3","4","5"));
		searchKey_pro.setType("0");
		int count_pro_0=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		searchKey_pro.setType("1");
		int count_pro_1=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		model.addAttribute("count_pro_0", count_pro_0);
		model.addAttribute("count_pro_1", count_pro_1);
		
		return "admin_home";
	}
	
	@RequestMapping(value="/homeother")
	public  String homeOther(HttpSession session,Model model)throws Exception{
		SysUser user=(SysUser)session.getAttribute("user");
		model.addAttribute("user", user);
		
		SearchKey searchKey_pro=new SearchKey();
		if(SysUser.role_1.equals(user.getRole())){
			searchKey_pro.setAuditor(user.getUserCode());
		}else{
			searchKey_pro.setCreator(user.getUserCode());
		}
		
		searchKey_pro.setStatus(Arrays.asList("3"));
		searchKey_pro.setType("0");
		int count_pro_0_3=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		searchKey_pro.setType("1");
		int count_pro_1_3=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		
		searchKey_pro.setStatus(Arrays.asList("4"));
		searchKey_pro.setType("0");
		int count_pro_0_4=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		searchKey_pro.setType("1");
		int count_pro_1_4=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		
		searchKey_pro.setStatus(Arrays.asList("5"));
		searchKey_pro.setType("0");
		int count_pro_0_5=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		searchKey_pro.setType("1");
		int count_pro_1_5=baseService.countBySearchKey(searchKey_pro, Pro.class.getName());
		
		model.addAttribute("count_pro_0_3", count_pro_0_3);
		model.addAttribute("count_pro_1_3", count_pro_1_3);
		model.addAttribute("count_pro_0_4", count_pro_0_4);
		model.addAttribute("count_pro_1_4", count_pro_1_4);
		model.addAttribute("count_pro_0_5", count_pro_0_5);
		model.addAttribute("count_pro_1_5", count_pro_1_5);
		
		return "other_home";
	}
	
	/**
	 * 跳转到到系统首页
	 * @return
	 */
	@RequestMapping(value="/main")
	public String index(HttpSession session,Model model){
		SysUser user=(SysUser)session.getAttribute("user");
		model.addAttribute("user", user);
		return "index";
	}
	
	/**
	 * 修改密码界面
	 * @return
	 */
	@RequestMapping(value="/changepass")
	public String changepassView(){
		return "change_password";
	}
	/**
	 * 修改密码
	 * @param oldPass
	 * @param newPass
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/ajax/changepass")
	public @ResponseBody ResultMap changepass(String oldPass,String newPass,HttpSession session){
		SysUser sessionUser=(SysUser)session.getAttribute("user");
		SysUser user=userService.getUserByCode(sessionUser.getUserCode());
		if (!StringUtils.equalsIgnoreCase(user.getPassword(), oldPass)) {
			return ResultMap.result_3;
		}
		user.setPassword(newPass);
		user.setModifyDate(new Date());
		userService.updateUser(user);
		session.setAttribute("user", user);
		return ResultMap.getDefaultResultMap();
	}
}

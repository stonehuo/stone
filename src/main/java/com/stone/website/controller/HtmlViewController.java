package com.kpap.website.controller;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kpap.basis.model.SysUser;


/**
 * html页面显示
 * 
 * @author shenhaiwen
 *
 */
@Controller
public class HtmlViewController {
	
	/**
	 * 评估界面
	 * @return
	 */
	@RequestMapping(value="html/{fileName}")
	public String htmlView(HttpSession session,Model model,@PathVariable(value="fileName") String fileName){
		SysUser user=(SysUser)session.getAttribute("user");
		model.addAttribute("user", user);
		return "html/"+fileName;
	}

}

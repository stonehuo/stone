package com.kpap.basis.util;

import javax.servlet.http.HttpSessionListener;

import com.kpap.basis.model.SysUser;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;  
      
public class SessionListener implements HttpSessionListener {
	
    /* Session创建事件 */  
    public void sessionCreated(HttpSessionEvent se) {
    }  
    /* Session失效事件 */  
    public void sessionDestroyed(HttpSessionEvent se) {  
    	 HttpSession httpSession=se.getSession();  
    	 SysUser user=(SysUser)httpSession.getAttribute("user");
    	 if(user!=null){
    		 CacheUtil.getInstance().removeAdmin(user.getUserCode());
    	 }
      }  
}  
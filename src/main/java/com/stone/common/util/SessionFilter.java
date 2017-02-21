package com.kpap.common.util;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionFilter implements HandlerInterceptor {
	
	private List<String> noFilters;

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        // 后台session控制    
		String url = request.getServletPath();
        boolean beFilter=true;
        if (!"/".equals(url)) {
            for (String s : noFilters) {  
                if (url.startsWith(s)) {  
                    beFilter = false;  
                    break;  
                }  
            }  
		}else{
			beFilter=false;
		}
        if(beFilter){
        	Object obj = request.getSession().getAttribute("user");  
        	 if (null == obj) {  
                 // 未登录   
                 PrintWriter out = response.getWriter();  
                 response.setHeader("Content-type", "text/html;charset=UTF-8");
                 response.setCharacterEncoding("UTF-8");  
                 StringBuilder builder = new StringBuilder();  
                 builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");  
                 builder.append("alert(\"页面过期，请重新登录\");");  
                 builder.append("window.top.location.href=\"");  
                 builder.append(request.getContextPath()+"/login\";</script>");   
                 out.print(builder.toString());  
                 out.close();  
                 return false;  
             } 
        }
	   return true;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
/*		String uri = request.getRequestURI();
		String url=uri.substring(uri.indexOf("/", 1));
		AuthorityCriteria authorityCriteria=new AuthorityCriteria();
		authorityCriteria.createCriteria().andUrlEqualTo(url);
		List<Authority> authorities=authorityDAO.selectByExample(authorityCriteria);
		if (authorities.size()>0) {
			Authority authority=authorities.get(0);
			Log log=new Log();
			log.setId(UUIDGenerator.create32Key());
			log.setCodeEmp(request.getSession().getAttribute("userId").toString());
			log.setType("2");
			log.setMessage(authority.getName());
			log.setIpTables(IpMessage.getIpAddr(request));
			log.setCreateTime(new Date());
			logDAO.insert(log);
		}*/
	}

	public List<String> getNoFilters() {
		return noFilters;
	}

	public void setNoFilters(List<String> noFilters) {
		this.noFilters = noFilters;
	}

}

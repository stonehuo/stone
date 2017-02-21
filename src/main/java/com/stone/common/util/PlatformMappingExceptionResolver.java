package com.kpap.common.util;

import java.io.PrintWriter;  
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;  
  

public class PlatformMappingExceptionResolver extends  SimpleMappingExceptionResolver {  
	private List<String> viewFilters;
	
	private static final Logger logger = LoggerFactory.getLogger(PlatformMappingExceptionResolver.class);
	
    @Override  
    protected ModelAndView doResolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {  
    	ex.printStackTrace();
    	logger.error(ex.getMessage());
    
        String uri = request.getRequestURI(); 
        String url=uri.substring(uri.indexOf("/", 1));
        boolean jsonFilter=true;
        for (String s : viewFilters) {  
            if (url.indexOf(s)>=0) {  
            	jsonFilter = true;  
                break;  
            }  
        }  
        if (jsonFilter) {
            try {  
                PrintWriter writer = response.getWriter();  
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");  
                writer.write(JSON.toJSONString(ResultMap.getResultMap(-1, "未知错误："+ex.getMessage())));  
                writer.flush();  
            } catch ( Exception e ) {   
                e.printStackTrace();  
            }  
            return null; 
		}else{
			String viewName = determineViewName(ex, request); 
            // 非异步方式返回  
            Integer statusCode = determineStatusCode(request, viewName);  
            if (statusCode != null) {  
                applyStatusCodeIfPossible(request, response, statusCode);  
            }  
            // 跳转到提示页面  
            return getModelAndView(viewName, ex, request);  
		}
    }  
    public static String getTrace(Throwable t) {  
        StringWriter stringWriter= new StringWriter();  
        PrintWriter writer= new PrintWriter(stringWriter);  
        t.printStackTrace(writer);  
        StringBuffer buffer= stringWriter.getBuffer();  
        return buffer.toString();  
    }
	public List<String> getViewFilters() {
		return viewFilters;
	}
	public void setViewFilters(List<String> viewFilters) {
		this.viewFilters = viewFilters;
	}  
    
}  
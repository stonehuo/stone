package com.kpap.common.util;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CusCommonsMultipartResolver extends CommonsMultipartResolver {
    @Override  
    public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {  
          
        String uri = request.getRequestURI();  
        //过滤使用百度EmEditor的URI  
        if (uri.indexOf("umeditorUpload") > 0) {   
            return false;  
        }  
        return super.isMultipart(request);  
    }  
}

package com.kpap.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DownloadControler {
	@Value("${assets.path}")
	private String assetsPath;
	
	
    @RequestMapping("assets/{fileType}/{dateFolder}/{fileName}")  
    public void lookPic(HttpServletRequest request,@PathVariable(value="fileType") String fileType,@PathVariable(value="dateFolder") String dateFolder,@PathVariable(value="fileName") String fileName,HttpServletResponse response){
    	try {
    		 String uri=request.getRequestURI();
    		 String fileSuffix=uri.substring(uri.indexOf("."));
			 File file = new File(assetsPath+fileType+File.separator +dateFolder+File.separator +fileName+fileSuffix); 
			 FileInputStream in = new FileInputStream(file);
			 OutputStream out = response.getOutputStream();  
			 // 创建缓冲区  
			 byte buffer[] = new byte[1024];  
			 int len = 0;  
			 // 循环将输入流中的内容读取到缓冲区当中  
			 while ((len = in.read(buffer)) > 0) {  
			     // 输出缓冲区的内容到浏览器，实现文件下载  
			     out.write(buffer, 0, len);  
			 }  
			 // 关闭文件输入流  
			 in.close();  
			 // 关闭输出流  
			 out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
    }
}

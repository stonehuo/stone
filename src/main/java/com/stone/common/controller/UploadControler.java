package com.kpap.common.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.kpap.common.util.CommonUtil;
import com.kpap.common.util.ResultMap;
import com.kpap.common.util.ueditor.Uploader;

@Controller
public class UploadControler {
	
	@Value("${assets.path}")
	private String assetsPath;
	
	@Value("${image.path}")
	private String imagePath;
    
    @RequestMapping("/umeditorUpload")  
    public void umeditorUpload(HttpServletRequest request,HttpServletResponse response){
    	String result="";
		try {
			Uploader up = new Uploader(request);
			up.setSavePath("");
			String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
			up.setAllowFiles(fileType);
			up.setRootPath(assetsPath+imagePath);
			up.upload();

			result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize() +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";
			result = result.replaceAll( "\\\\", "\\\\" );
			response.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    @RequestMapping("/upload")  
    public @ResponseBody ResultMap upload(HttpServletRequest request,HttpServletResponse response){
    	String filePackage=request.getParameter("filePackage");
    	String returnPath="";
        try {
			//创建一个通用的多部分解析器  
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
			//判断 request 是否有文件上传,即多部分请求  
			if(multipartResolver.isMultipart(request)){  
			    //转换成多部分request    
			    MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
			    //取得request中的所有文件名  
			    Iterator<String> iter = multiRequest.getFileNames();  
			    while(iter.hasNext()){
			        //取得上传文件  
			        MultipartFile file = multiRequest.getFile(iter.next());  
			        if(file != null){  
			            //取得当前上传文件的文件名称  
			            String myFileName = file.getOriginalFilename();  
			            //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
			            if(myFileName.trim() !=""){  
			                System.out.println(myFileName);  
			                //重命名上传后的文件名  
			                String extName = myFileName.substring(myFileName.lastIndexOf(".")).toLowerCase();
			                Random random =new Random();
			                String fileName = System.currentTimeMillis()+String.valueOf(random.nextInt(10000))+extName;  
			                //定义上传路径  
			        		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
			        		String uploadPath=formater.format(new Date())+"/";
			                String directorypath = assetsPath+filePackage+"/"+ uploadPath;
			                File directoryFile=new File(directorypath);
			                if (!directoryFile.exists()) {
			                	directoryFile.mkdirs();
							}
			                returnPath=CommonUtil.assertPath+filePackage+"/"+uploadPath+fileName;
			                File localFile = new File(directorypath+fileName);
			                file.transferTo(localFile);  
			            }  
			        }  
			    }  
			      
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.result_3;
		}  
        return ResultMap.getDefaultResultMap("filePath", returnPath);
    }
}

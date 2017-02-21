package com.kpap.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.util.Assert;

import com.kpap.common.constant.ToolsConst;

/**
 * 提供磁盘文件的基本操作
 * 
 */
public class DiskFileUtil {
	
	/**
	 * 按指定全路径保存文件（路径开始于webContextPath）
	 * @param srcFile 源文件
	 * @param absFilePath 全路径
	 * @throws IOException 异常
	 */
	public static void copyTo(File srcFile, String absFilePath) throws IOException{
		//FileUtils.copyFile(srcFile, new File(absFilePath));
        File absFile = new File(absFilePath);
        if (!absFile.getParentFile().exists()) {
            boolean b = absFile.getParentFile().mkdirs();
            if (!b) {
                throw new IOException("创建目录：" + absFile.getParentFile() + " 失败");
            }
        }
		FileInputStream is = new FileInputStream(srcFile);
		FileOutputStream os = new FileOutputStream(absFilePath);
		
		int length = -1;
		byte[] buf = new byte[1024*8];
		while( (length=is.read(buf))>0 ){
			os.write(buf,0,length);
		}
		os.close();
		is.close();
	}
	/**
	 * 将数据流保存为文件
	 * @param is 数据流
	 * @param absFilePath 全路径
	 * @throws Exception 异常
	 */
	public static void saveFile(InputStream is, String absFilePath) throws Exception{
		File storefile = new File(absFilePath);
		File folder = new File(getFolderPath(absFilePath));
		if(!folder.exists()){
			boolean b=folder.mkdirs();
			if(!b) {
				try {
					throw new IOException("目录："+getFolderPath(absFilePath)+"创建失败！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(storefile));
			bis = new BufferedInputStream(is);
			int c;
			while ((c = bis.read()) != -1) {
				bos.write(c);
                bos.flush();
			}
		} catch (Exception e) {
			throw new Exception("文件保存失败!");
		} finally {
			bos.close();
			bis.close();
		}
	}
	/***
	 * 获取并生成指定的文件夹相对路径（如：/WEB-INF/uploadFiles/2010-10/29/）
	 * 如果基路径为空，则生成业务无关的相对路径（如：2010-10/29/）
	 * @return 生成指定的文件夹相对路径或业务无关的相对路径
	 */
	public static String getFolderPathOnDate(){
		String folderPath;
		/*
		 * 构造“年-月/日”的目录结构
		 */
		String today = new java.sql.Date(System.currentTimeMillis()).toString();
		String[] todaySplit = today.split("-");
		
		folderPath = "/"+todaySplit[0]+"-"+todaySplit[1]+"/"+todaySplit[2]+"/";
		
		return folderPath;
	}
	/**
	 * 获取存放文件的相对路径
	 * @param basePath 基础路径
	 * @return 存放文件的相对路径
	 */
	public static String getRelPathOnDate(String basePath){
		String folderPath = getFolderPathOnDate();
		return basePath+folderPath;
	}
	/**
	 * 获取存放文件的绝对路径
	 * @param basePath 基础路径
	 * @return 存放文件的绝对路径
	 */
	public static String createFolder(String basePath) {
		String absPath = basePath;
		File saveDir = new File(absPath);
		if(!saveDir.exists()){
			boolean b=saveDir.mkdirs();
			if(!b){
				try {
					throw new IOException("目录："+absPath+"创建失败！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return absPath;
	}
	/**
	 * 取得指定路径下的文件（不含子目录）
	 * @param basePath 基础路径
	 * @param path 扩展路径
	 * @return 指定路径下的文件
	 */
	public static File[] getDirectFiles(String basePath, String path){
		File[] files = null;
		if(null==path || File.separator.equals(path.trim())){
			File resourceRoot = new File(basePath);
			files = resourceRoot.listFiles();
		}else{
			File dir = new File(basePath+path);
			if(!dir.exists()){
				boolean b=dir.mkdirs();
				if(!b) {
					try {
						throw new IOException("目录："+basePath+path+"创建失败！");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			files = dir.listFiles();
		}
		List<File> fileList = new ArrayList<File>();
		if(null!=files){
			for(File fi : files){
				if(".svn".equals(fi.getName())) {
					continue;//不显示.svn文件夹
				}
				fileList.add(fi);
			}
			
			return fileList.toArray(new File[]{});
		}else{
			return null;
		}
		
		
	}
	/**
	 * 取得指定路径下的文件（含子目录）
	 * @param basePath 基础路径
	 * @param path 扩展路径
	 * @return 指定路径下的文件
	 */
	public static File[] getAllFiles(String basePath, String path){
		File dir = null;
		if(null==path || File.separator.equals(path.trim())){
			dir = new File(basePath);
		}else{
			dir = new File(basePath+path);
			if(!dir.exists()){
				boolean b=dir.mkdirs();
				if(!b) {
					try {
						throw new IOException("目录："+basePath+path+"创建失败！");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		Collection<File> files = FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, FileFilterUtils.makeSVNAware(null));
		return files.toArray(new File[]{});
	}
	/**
	 * 移动文件或文件夹
	 * @param oldPath 原始路径
	 * @param newPath 新路径
	 * @throws Exception 异常
	 */
	public static void move(String oldPath, String newPath) throws Exception{
		File oldFile = new File(oldPath);
		File newFile = new File(newPath);
		if(oldFile.equals(newFile)) {
			return;
		}
		
//		if(oldFile.isDirectory()){
//			try{
//				FileUtils.moveDirectory(oldFile, newFile);
//			} catch(FileExistsException fee){//如果目标文件夹已存在,则只移动其下的所有文件
//				File[] files = getAllFiles(oldPath, null);
//				for(File file : files){
//					String oldDirPath = cleanFilePath(oldFile.getAbsolutePath());
//					String oldFilePath = cleanFilePath(file.getAbsolutePath());
//					String newFilePath = cleanFilePath(newFile.getAbsolutePath())
//						+ oldFilePath.substring(oldDirPath.length());
//					log.debug("oldDirPath="+oldDirPath);
//					log.debug("oldFilePath="+oldFilePath);
//					log.debug("newFilePath="+newFilePath);
//					
//					File newFile2 = renameOnExist(new File(newFilePath));
//					FileUtils.moveFile(file, newFile2);
//					
//				}
//				FileUtils.deleteDirectory(oldFile);
//			}
//		}else{
			File newFile3 = renameOnExist(newFile);
//			FileUtils.moveFile(oldFile, newFile3);
//		}
	}
	/**
	 * 返回文件的安全名称
	 * 当文件已存在,则返回重命名后的文件路径
	 * 否则返回原文件
	 * @param file 文件
	 * @return 重命名后的文件路径或原文件
	 */
	public static File renameOnExist(File file){
		if(!file.exists()) {
			return file;
		}
		
		String folderPath = getFolderPath(file.getAbsolutePath());
		String fileName = getFileNameByPath(file.getAbsolutePath());
		String fileBaseName = getFileBaseName(fileName);
		String fileExtName = getFileExtName(fileName);
		
		File rtn = null;
		for(int i=2; i<10000; i++){//与windows的重名处理一致,从(2)开始
			String thePath = folderPath+"/"+fileBaseName+"("+i+")."+fileExtName;
			File theFile = new File(thePath);
			if(!theFile.exists()){
				rtn = theFile;
				break;
			}
		}
		
		return rtn;
	}
	/**
	 * 删除文件或文件夹
	 * @param basePath 基础路径
	 * @param fileId 文件标识符
	 * @throws Exception 异常
	 */
	public static void delFile(String basePath, String fileId) throws Exception{
		String[] ids = fileId.split(",");
		for(String id : ids){
			id = id.trim();
			String path = basePath+id;
			File file = new File(path);
			if(file.isDirectory() && file.list().length>0){
				throw new Exception("不能删除非空目录");
			}
			boolean b=file.delete();
			if(!b){
				throw new IOException("文件："+file+"删除失败！");
			}
		}
	}
	/**
	 * 以应用相对路径删除文件或目录（及其子目录）
	 * @param basePath 基础路径
	 * @param path 扩展路径
	 * @throws Exception 异常
	 */
	public static void delFileTree(String basePath, String path) throws Exception{
		Assert.notNull(path);
		String[] ids = path.split(",");
		for(String id : ids){
			String absPath = basePath+id;
			delAbsFileTree(absPath);
		}
	}
	/**
	 * 以绝对路径删除文件或目录（及其子目录）
	 * @param absPath 绝对路径
	 * @throws Exception 异常
	 */
	public static void delAbsFileTree(String absPath) throws Exception{
		Assert.notNull(absPath,"文件路径无效");
		File file = new File(absPath);
		if(file.isDirectory()){
			FileUtils.deleteDirectory(file);
		}else{
			boolean b=file.delete();
			if(!b){
				throw new IOException("文件："+file+"删除失败！");
			}
		}
	}
	/**
	 * 从路径中剥离出文件名称
	 * @param path 路径
	 * @return 文件名称
	 */
	public static String getFileNameByPath(String path){
		String filePath = path.replaceAll("\\\\", "/");
		if(filePath.indexOf("/")<0){
			return filePath;
		}
		
		return new String(filePath.substring(filePath.lastIndexOf("/")+1));
	}
	/**
	 * 从路径中剥离出文件夹的路径
	 * @param path 路径
	 * @return 文件夹的路径
	 */
	public static String getFolderPath(String path){
		String filePath = path.replaceAll("\\\\", "/");
		if(filePath.indexOf("/")<0){
			return "";
		}
		
		return new String(filePath.substring(0,filePath.lastIndexOf("/")));
	}
	/**
	 * 由文件名获取扩展名
	 * @param fileName 文件名
	 * @return 扩展名
	 */
	public static String getFileExtName(String fileName) {
		if(fileName.indexOf(".")<0) {
			return "";
		}
		String extName = new String(fileName.substring(fileName.lastIndexOf(".")+1));//扩展名
		if(null!=extName) {
			extName = extName.toLowerCase();
		}
		return extName;
	}
	/**
	 * 由文件名获取基本名
	 * @param fileName 文件名
	 * @return 基本名
	 */
	public static String getFileBaseName(String fileName){
		if(fileName.indexOf(".")<0) {
			return fileName;
		}
		String baseName = new String(fileName.substring(0,fileName.lastIndexOf(".")));//基本名
		return baseName;
	}
	/**
	 * 按绝对路径及根相对路径取得相对路径
	 * @param basePath 根相对路径
	 * @param realPath 绝对路径
	 * @return 相对路径
	 */
	public static String getRelPath(String basePath, String realPath){
		String root = basePath;
		
		realPath = cleanFilePath(realPath);
		root = cleanFilePath(root);
		//log.debug("rootPath="+root);
		//log.debug("realPath="+realPath);
		String relPath = new String(realPath.substring(realPath.indexOf(root)+root.length()));
		//log.debug("relPath="+relPath);
		return relPath;
	}
	/**
	 * 清理文件路径
	 * @param src 源路径
	 * @return 清理后文件路径
	 */
	public static String cleanFilePath(String src){
		String dest = src;
		//当服务器为windows时，注意把路径分隔符改成linux的.
		if(File.separator.equals("\\") || src.indexOf("\\")>=0){
			dest = dest.replaceAll("\\\\", "/");
		}
		dest = dest.replaceAll("//", "/");
		
		return dest;
	}
	/**
	 * 判断文件是否是svn数据文件
	 * @param file 文件
	 * @return 判断结果
	 */
	public static boolean isSvnFile(File file){
		boolean flag = false;
		String absPath = cleanFilePath(file.getAbsolutePath());
		if(absPath.indexOf(ToolsConst.DIR_NAME_SVN)>=0){
			flag = true;
		}
		return flag;
	}
	/**
	 * 判断文件是否是CVS数据文件
	 * @param file 文件
	 * @return 判断结果
	 */
	public static boolean isCvsFile(File file){
		boolean flag = false;
		String absPath = cleanFilePath(file.getAbsolutePath());
		if(absPath.indexOf(ToolsConst.DIR_NAME_CVS)>=0){
			flag = true;
		}
		return flag;
	}
}

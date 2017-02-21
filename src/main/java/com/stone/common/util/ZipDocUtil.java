package com.kpap.common.util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 
 * zip格式实用类<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-11 下午10:20:51
 */
public class ZipDocUtil {
	/**
	 * @param src 要压缩的目录
	 * @param dest 压缩文件存档
	 * @param filter 过滤
	 * @throws Exception 异常
	 */
	public static void zip(String src, String dest, List filter)
			throws Exception {
        File dir = new File(dest);
        if (!dir.getParentFile().exists()) {
            boolean b = dir.getParentFile().mkdirs();
            if (!b) {
                try {
                    throw new IOException("目录：" + dest + "不存在，并且创建新目录失败！");
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
        }
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(dest));
		File srcFile = new File(src);
		zip(out, srcFile, "", filter);
		out.close();
	}

	/**
	 * @param out 输出流
	 * @param srcFile 源文件
	 * @param base 根路径
	 * @param filter 过滤
	 * @throws Exception 异常
	 */
	public static void zip(ZipOutputStream out, File srcFile, String base, List filter) throws Exception {
		if (srcFile.exists() == false) {
			throw new Exception("要压缩的目录不存在!");
		}
		if (srcFile.isDirectory()) {
			File[] files = srcFile.listFiles();
			base = base.length() == 0 ? "" : base + "/";
			
			if (base.length()>0 && isExist(base, filter)) {
				out.putNextEntry(new ZipEntry(base));
			}
			for (int i = 0; i < files.length; i++) {
				zip(out, files[i], base + files[i].getName(), filter);
			}
		} else {
			if (isExist(base, filter)) {
				base = base.length() == 0 ? srcFile.getName() : base;
				ZipEntry zipEntry = new ZipEntry(base);
				// zipEntry.setComment(comment);
				out.putNextEntry(zipEntry);
				FileInputStream in = new FileInputStream(srcFile);
				int length = 0;
				byte[] b = new byte[1024];
				while ((length = in.read(b, 0, 1024)) != -1) {
					out.write(b, 0, length);
				}
				in.close();
			}
		}
	}

	/**
	 * @param zipInfoMap 需要压缩信息
	 * @return 压缩后输出流
	 * @throws Exception 异常
	 */
	public static ByteArrayOutputStream zip(Map<String, InputStream> zipInfoMap) throws Exception{
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ZipOutputStream out = new ZipOutputStream(bos);
		for(Entry<String, InputStream> e : zipInfoMap.entrySet()){
			ZipEntry zipEntry = new ZipEntry(e.getKey());
			out.putNextEntry(zipEntry);
	        InputStream in = e.getValue();
			int length = 0;
			byte[] b = new byte[1024];
			while ((length = in.read(b, 0, 1024)) != -1) {
				out.write(b, 0, length);
			}
			in.close();
		}
		out.flush();
		out.close();
		return bos;
	}
	
	/**
	 * 过滤出要压缩的文件夹
	 * 
	 * @param base 基础路径
	 * @param list 列表
	 * @return 是否存在
	 */
	public static boolean isExist(String base, List list) {
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (base.indexOf((String) list.get(i)) >= 0) {
					return true;
				}
			}
		} else {
			return true;
		}
		return false;
	}

	/**
	 * 解压zip文件，并返回解压后的文件对象列表
	 * @param srcFile 压缩文件路径
	 * @param dest 解压到的目录
	 * @param deleteFile 解压完成后是否删除文件
	 * @return 解压后的文件对象列表
	 * @throws Exception 异常
	 */
	public static List<File> unZip(String srcFile, String dest, boolean deleteFile)
			throws Exception {
		File file = new File(srcFile);
		if (!file.exists()) {
			throw new Exception("解压文件："+srcFile+" 不存在!");
		}
		List<File> fileList = new ArrayList<File>();
        ZipFile zipFile=null;
        try {
            zipFile = new ZipFile(file);
            Enumeration e = zipFile.entries();
            while (e.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) e.nextElement();
                String name = zipEntry.getName();
                //log.debug("fileName="+name);
                if (zipEntry.isDirectory()) {
                    name = new String(name.substring(0, name.length() - 1));
                    File f = new File(dest + name);
                    //log.debug("f.getAbsolutePath()="+f.getAbsolutePath());
                    if (DiskFileUtil.isSvnFile(f) || DiskFileUtil.isCvsFile(f)) {
                        continue;//不处理svn和cvs的数据文件夹
                    }
                    if (!f.getParentFile().exists()) {
                        boolean bl3 = f.mkdirs();
                        if (!bl3) {
                            throw new IOException("目录：" + dest + name + "创建失败！");
                        }
                    }
                } else {
                    if ("".equals(name)) {
                        continue;// 会有一个空文件
                    }
                    File f = new File(dest + name);
                    //log.debug("f.getAbsolutePath()="+f.getAbsolutePath());
                    if (DiskFileUtil.isSvnFile(f) || DiskFileUtil.isCvsFile(f)) {
                        continue;//不处理svn和cvs的数据文件夹
                    }
                    f = DiskFileUtil.renameOnExist(f);
                    fileList.add(f);
                    if (!f.getParentFile().exists()) {
                        boolean bl1 = f.getParentFile().mkdirs();
                        if (!bl1) {
                            throw new IOException("目录：" + f.getParentFile() + "创建失败！");
                        }
                    }
                    boolean bl2 = f.createNewFile();
                    if (!bl2) {
                        throw new IOException("目录：" + dest + name + "创建失败！");
                    }
                    InputStream is = zipFile.getInputStream(zipEntry);
                    FileOutputStream fos = new FileOutputStream(f);
                    int length = 0;
                    byte[] b = new byte[1024];
                    while ((length = is.read(b, 0, 1024)) != -1) {
                        fos.write(b, 0, length);
                    }
                    is.close();
                    fos.close();
                }
            }
		 }finally {
            if (zipFile != null) {
                zipFile.close();
            }
            if (deleteFile) {
                file.deleteOnExit();
            }
        }
		
		return fileList;
	}

	/**
	 * 获取Zip文件的注释信息
	 * 
	 * @param srcFile
	 * @return
	 * 
	 * public static String getZipComment(String srcFile) { String comment = "";
	 * try { ZipFile zipFile = new ZipFile(srcFile); Enumeration e =
	 * zipFile.getEntries();
	 * 
	 * while (e.hasMoreElements()) { ZipEntry ze = (ZipEntry) e.nextElement();
	 * 
	 * comment = ze.getComment(); if (comment != null && !comment.equals("") &&
	 * !comment.equals("null")) { break; } }
	 * 
	 * zipFile.close(); } catch (Exception e) {
	 * System.out.println("获取zip文件注释信息失败:" + e.getMessage()); }
	 * 
	 * return comment; }
	 */
}

package com.kpap.common.controller;

import java.lang.reflect.Constructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kpap.basis.model.SysUser;
import com.kpap.common.dto.SearchKey;
import com.kpap.common.service.IBaseService;
import com.kpap.common.util.CommonUtil;
import com.kpap.common.util.ResultMap;

@Controller
@RequestMapping(value="/common")
public class CommonControler {
	
	@Autowired
	IBaseService baseService;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonControler.class);
	
	@RequestMapping(value="view/{folder}/{name}")
	public String index(@PathVariable String folder,@PathVariable String name,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		return folder+"/"+name;
	} 
	
	@RequestMapping(value="/list")
    public @ResponseBody Map<String, Object> getListForPage(HttpServletRequest request,String modelFullName,@RequestBody SearchKey searchKey) throws Exception{
		Map<String, Object> returnMap=new HashMap<String, Object>();
		List<?> lists=baseService.getRowsBySearchKey(searchKey, modelFullName);
		float count=(float)baseService.countBySearchKey(searchKey,modelFullName);
		returnMap.put("total", count);
		returnMap.put("rows", lists);
		return returnMap;
	}
	
	@RequestMapping(value="/selectById")
	public @ResponseBody Object selectById(Long id,String modelFullName) throws Exception{
		return baseService.selectByPrimaryKey(id, modelFullName);
	}
	@RequestMapping(value="/selectByCode")
	public @ResponseBody Object selectByCode(String modelFullName,String code) throws Exception{
		return baseService.selectByPrimaryKey(code, modelFullName);
	}
	@RequestMapping(value="/edit")
    public @ResponseBody ResultMap edit(HttpServletRequest request,String modelFullName,HttpSession httpSession) throws Exception{
		SysUser user=(SysUser)httpSession.getAttribute("user");
		Object object=getObjectFromRequest(request,modelFullName,"edit",user.getUserCode());
		baseService.editSelective(object, modelFullName);
		return ResultMap.getDefaultResultMap();
	}
	
	@RequestMapping(value="/delById")
	public @ResponseBody ResultMap delById(String modelFullName,Long id) throws Exception{
		baseService.delByPrimaryKey(id, modelFullName);
		return ResultMap.getDefaultResultMap();
	}
	
	@RequestMapping(value="/delByCode")
	public @ResponseBody ResultMap delByCode(String modelFullName,String code,HttpSession httpSession) throws Exception{
		baseService.delByPrimaryKey(code, modelFullName);
		return ResultMap.getDefaultResultMap();
	}
	
	@RequestMapping(value="/add")
	public @ResponseBody ResultMap add(String modelFullName,HttpServletRequest request,HttpSession httpSession) throws Exception {
		SysUser user=(SysUser)httpSession.getAttribute("user");
		int result=baseService.add(getObjectFromRequest(request,modelFullName,"add",user.getUserCode()),modelFullName);
		if (result==-2) {
			return ResultMap.result_4;
		}else if(result==-1){
			return ResultMap.getResultMap(-1, "未知错误");
		}
		return ResultMap.getDefaultResultMap();
	}
	@RequestMapping(value="/all")
	public @ResponseBody List<?> all(String modelFullName) throws Exception {
		List<?> lists=baseService.getRowsBySearchKey(new SearchKey(), modelFullName);
		return lists;
	}
	public Object getObjectFromRequest(HttpServletRequest request,String modelFullName,String type,String userCode){
		try {
			Class<?> model=Class.forName(modelFullName);
			Object object=model.newInstance();
			
			Map<String, String[]> parms=request.getParameterMap();
			for (String key : parms.keySet()) {
				String value=parms.get(key)[0];
				if(value!=null && !"".equals(value)){
					try {
						Field field=model.getField(key);
						Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne(key), field.getType());
						if (field.getType()==Date.class) {
							SimpleDateFormat sdf  = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
							Date date = sdf.parse(value); 
							method.invoke(object, date);
						}else{
							Constructor<?> constructor = field.getType().getConstructor(String.class);
							method.invoke(object, constructor.newInstance(value));
						}
					} catch (Exception e) {
						logger.error("获取字段"+key+"错误："+e.getMessage());
					}
				}
			}
			if ("add".equals(type)) {
				try {
					Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne("creator"), String.class);
					method.invoke(object, userCode);
				} catch (Exception e) {
					logger.info(modelFullName+"设置setCreator失败:"+e.getMessage());
				}
				try {
					Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne("createDate"), Date.class);
					method.invoke(object, new Date());
				} catch (Exception e) {
					logger.info(modelFullName+"设置setCreateDate失败:"+e.getMessage());
				}
				try {
					Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne("modifier"), String.class);
					method.invoke(object, userCode);
				} catch (Exception e) {
					logger.info(modelFullName+"设置setModifier失败:"+e.getMessage());
				}
				try {
					Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne("modifyDate"), Date.class);
					method.invoke(object, new Date());
				} catch (Exception e) {
					logger.info(modelFullName+"设置setModifyDate失败:"+e.getMessage());
				}
			}else{
				try {
					Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne("modifier"), String.class);
					method.invoke(object, userCode);
				} catch (Exception e) {
					logger.info(modelFullName+"设置setModifier失败:"+e.getMessage());
				}
				try {
					Method method=model.getMethod("set"+CommonUtil.toUpperCaseFirstOne("modifyDate"), Date.class);
					method.invoke(object, new Date());
				} catch (Exception e) {
					logger.info(modelFullName+"设置setModifyDate失败:"+e.getMessage());
				}
			}
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}
}

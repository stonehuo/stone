package com.kpap.common.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;

import com.kpap.common.annotation.TableColumn;
import com.kpap.common.dto.SearchKey;
import com.kpap.common.service.IBaseService;
import com.kpap.common.util.CommonUtil;

@Service
public class BaseService extends ApplicationObjectSupport implements IBaseService {
	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);
	
	public String getExampleFullName(String modelFullName){
		String modelName=modelFullName.substring(modelFullName.lastIndexOf(".")+1);
		String modelPackage=modelFullName.substring(0, modelFullName.lastIndexOf("."));
		String exampleName="";
		if (modelName.indexOf("WithBLOBs")>-1) {
			exampleName=modelName.substring(0, modelName.indexOf("WithBLOBs"))+"Example";
		}else{
			exampleName=modelName+"Example";
		}
		return modelPackage+"."+exampleName;
	}
	public String getMapperName(String modelFullName){
		String modelName=modelFullName.substring(modelFullName.lastIndexOf(".")+1);
		String mapperName="";
		if (modelName.indexOf("WithBLOBs")>-1) {
			mapperName=modelName.substring(0, modelName.indexOf("WithBLOBs"));
		}else{
			mapperName=modelName;
		}
		return CommonUtil.toLowCaseFirstOne(mapperName)+"Mapper";
	}
	public String getCriteriaName(String modelFullName){
		return modelFullName+"Example$Criteria";
	}
	/**
	 * 通用方法：根据SearchKey查询分页数据
	 * @param searchKey
	 * @param modelPackage
	 * @param modelType
	 * @return
	 */
	public List<?> getRowsBySearchKey(SearchKey searchKey,String modelFullName) throws Exception{
		List<?> rowList=null;
		try {
			Integer page=searchKey.getPage();
			Integer rows=searchKey.getRows();
			String sort=searchKey.getSort();
			String order=searchKey.getOrder();
			
			Class<?> exampleClass=Class.forName(getExampleFullName(modelFullName));
			Object exampleObject=exampleClass.newInstance();
			if(page!=null && rows!=null){
				Method setLimitStart=exampleClass.getMethod("setLimitStart", int.class);
				Method setLimitEnd=exampleClass.getMethod("setLimitEnd", int.class);
				setLimitStart.invoke(exampleObject, CommonUtil.calPage(page, rows));
				setLimitEnd.invoke(exampleObject, rows);
			}
			
			Method createCriteria=exampleClass.getMethod("createCriteria");
			Object criteriaObject=createCriteria.invoke(exampleObject);
			Class<?> criteriaClass=criteriaObject.getClass();
			
			Class<?> searchKeyClass=searchKey.getClass();
			Field[] fields=searchKeyClass.getFields();
			for (Field field : fields) {
				String fieldName=field.getName();
				if ("page".equals(fieldName) || "rows".equals(fieldName) || "sort".equals(fieldName) || "order".equals(fieldName) || "order_asc".equals(fieldName) || "order_desc".equals(fieldName)) {
					continue;
				}
				if(field.get(searchKey)!=null && !"".equals(field.get(searchKey))){
					if (field.getType()==String.class && fieldName.indexOf("start_")>-1) {
						String last=CommonUtil.toUpperCaseFirstOne(fieldName.substring((fieldName.indexOf("_")+1)));
						Method method=criteriaClass.getMethod("and"+last+"GreaterThanOrEqualTo", Date.class);
						method.invoke(criteriaObject,DateUtils.parseDate((String)field.get(searchKey), CommonUtil.date_formatSecode,CommonUtil.date_formatDay));
						
					}else if(field.getType()==String.class && fieldName.indexOf("end_")>-1){
						String last=CommonUtil.toUpperCaseFirstOne(fieldName.substring((fieldName.indexOf("_")+1)));
						Method method=criteriaClass.getMethod("and"+last+"LessThanOrEqualTo", Date.class);
						method.invoke(criteriaObject,DateUtils.parseDate((String)field.get(searchKey), CommonUtil.date_formatSecode,CommonUtil.date_formatDay));
					}else if(field.getType()==Long.class){
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"EqualTo", Long.class);
						method.invoke(criteriaObject,(Long)field.get(searchKey));
					}else if(field.getType()==Byte.class){
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"EqualTo", Byte.class);
						method.invoke(criteriaObject,((Byte)field.get(searchKey)));
					}else if(field.getType()==List.class){
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"In", List.class);
						method.invoke(criteriaObject,((List<?>)field.get(searchKey)));
					}else{
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"Like", String.class);
						method.invoke(criteriaObject, "%"+((String)field.get(searchKey)).trim()+"%");
					}
				}
			}
			if(StringUtils.isNotBlank(sort)){
				String sortString="";
				if(sort.indexOf(".")>0){
					String subSortString=sort.substring(sort.indexOf(".")+1);
					if(StringUtils.isNotBlank(subSortString)){
						sortString=sort+" "+order;
						Method setOrderByClause=exampleClass.getMethod("setOrderByClause",String.class);
						setOrderByClause.invoke(exampleObject,sortString);
					}
				}else{
					try {
						Class<?> modelClass=Class.forName(modelFullName);
						Field field=modelClass.getDeclaredField(sort);
						TableColumn tableColumn=field.getDeclaredAnnotation(TableColumn.class);
						if (tableColumn!=null) {
							sortString=tableColumn.name()+" "+order;
						}else{
							sortString=sort+" "+order;
						}
					} catch (NoSuchFieldException e) {
						sortString=sort+" "+order;
					}
					Method setOrderByClause=exampleClass.getMethod("setOrderByClause",String.class);
					setOrderByClause.invoke(exampleObject,sortString);
				}
			}
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapper=mapperObject.getClass();
	
			Method selectByExample;
			try {
				selectByExample = mapper.getMethod("selectByExampleWithBLOBs", exampleClass);
			} catch (NoSuchMethodException e) {
				selectByExample = mapper.getMethod("selectByExample", exampleClass);
			}
			rowList=(List<?>)selectByExample.invoke(mapperObject, exampleObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return rowList;
	}
	/**
	 * 通用方法：获取符合查询条件的总记录数
	 * @param modelName
	 * @param modelPackage
	 * @param searchKey
	 * @return
	 */
	public int countBySearchKey(SearchKey searchKey,String modelFullName) throws Exception{
		int count=0;
		try {
			Class<?> exampleClass=Class.forName(getExampleFullName(modelFullName));
			Object exampleObject=exampleClass.newInstance();
			
			Method createCriteria=exampleClass.getMethod("createCriteria");
			Object criteriaObject=createCriteria.invoke(exampleObject);
			Class<?> criteriaClass=criteriaObject.getClass();
			
			Class<?> searchKeyClass=searchKey.getClass();
			Field[] fields=searchKeyClass.getFields();
			for (Field field : fields) {
				String fieldName=field.getName();
				if ("page".equals(fieldName) || "rows".equals(fieldName) || "sort".equals(fieldName) || "order".equals(fieldName) || "order_asc".equals(fieldName) || "order_desc".equals(fieldName)) {
					continue;
				}
				if(field.get(searchKey)!=null && !"".equals(field.get(searchKey))){
					if (field.getType()==String.class && fieldName.indexOf("start_")>-1) {
						String last=CommonUtil.toUpperCaseFirstOne(fieldName.substring((fieldName.indexOf("_")+1)));
						Method method=criteriaClass.getMethod("and"+last+"GreaterThanOrEqualTo", Date.class);
						method.invoke(criteriaObject,DateUtils.parseDate((String)field.get(searchKey), CommonUtil.date_formatSecode,CommonUtil.date_formatDay));
					}else if(field.getType()==String.class && fieldName.indexOf("end_")>-1){
						String last=CommonUtil.toUpperCaseFirstOne(fieldName.substring((fieldName.indexOf("_")+1)));
						Method method=criteriaClass.getMethod("and"+last+"LessThanOrEqualTo", Date.class);
						method.invoke(criteriaObject,DateUtils.parseDate((String)field.get(searchKey), CommonUtil.date_formatSecode,CommonUtil.date_formatDay));
					}else if(field.getType()==Long.class){
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"EqualTo", Long.class);
						method.invoke(criteriaObject,(Long)field.get(searchKey));
					}else if(field.getType()==Byte.class){
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"EqualTo", Byte.class);
						method.invoke(criteriaObject,((Byte)field.get(searchKey)));
					}else if(field.getType()==List.class){
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"In", List.class);
						method.invoke(criteriaObject,((List<?>)field.get(searchKey)));
					}else{
						Method method=criteriaClass.getMethod("and"+CommonUtil.toUpperCaseFirstOne(fieldName)+"Like", String.class);
						method.invoke(criteriaObject, "%"+((String)field.get(searchKey)).trim()+"%");
					}
				}
			}
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapper=mapperObject.getClass();
			Method countByExample=mapper.getMethod("countByExample",exampleClass);
			count=(int)countByExample.invoke(mapperObject, exampleObject);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}
	/**
	 * 通用方法：根据主键id删除数据
	 */
	public int delByPrimaryKey(Object primaryKey,String modelFullName) throws Exception{
		int result=-1;
		try {
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapper=mapperObject.getClass();
			
			Method deleteByPrimaryKey=mapper.getMethod("deleteByPrimaryKey",primaryKey.getClass());
			result = (int)deleteByPrimaryKey.invoke(mapperObject, primaryKey);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	/**
	 * 通用方法：根据主键id查询数据
	 */
	public Object selectByPrimaryKey(Object primaryKey,String modelFullName) throws Exception{
		try {
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapper=mapperObject.getClass();
			
			Method selectByPrimaryKey=mapper.getMethod("selectByPrimaryKey",primaryKey.getClass());
			Object object = selectByPrimaryKey.invoke(mapperObject, primaryKey);
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
	}
	/**
	 * 通用方法：编辑记录
	 */
	public int edit(Object model,String modelFullName) throws Exception{
		int result=-1;
		try {
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapper=mapperObject.getClass();
			
			Class<?> modelClass=model.getClass();
			Method updateByPrimaryKey;
			try {
				updateByPrimaryKey = mapper.getMethod("updateByPrimaryKeyWithBLOBs", modelClass);
			} catch (NoSuchMethodException e) {
				updateByPrimaryKey = mapper.getMethod("updateByPrimaryKey", modelClass);
			}
			result = (int)updateByPrimaryKey.invoke(mapperObject, model);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	/**
	 * 通用方法：编辑记录
	 */
	public int editSelective(Object model,String modelFullName) throws Exception{
		int result=-1;
		try {
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapper=mapperObject.getClass();
			
			Class<?> modelClass=model.getClass();
			Method updateByPrimaryKeySelective = mapper.getMethod("updateByPrimaryKeySelective", modelClass);
			result = (int)updateByPrimaryKeySelective.invoke(mapperObject, model);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	/**
	 * 通用方法：增加数据
	 */
	public int add(Object model,String modelFullName)throws Exception{
		int result=-1;
		try {
			if(!checkUniqueness(model,modelFullName)){
				return -2;
			}
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapperClass=mapperObject.getClass();
			
			Class<?> modelClass=model.getClass();
			Method insertSelective=mapperClass.getMethod("insertSelective",modelClass);
			result = (int)insertSelective.invoke(mapperObject, model);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	public boolean checkUniqueness(Object model,String modelFullName){
		boolean checkResult=true;
		try {
			Class<?> exampleClass=Class.forName(getExampleFullName(modelFullName));
			Object exampleObject=exampleClass.newInstance();
			Class<?> criteria=Class.forName(getCriteriaName(modelFullName));
			Method createCriteria=exampleClass.getMethod("createCriteria");
			
			Object mapperObject=getApplicationContext().getBean(getMapperName(modelFullName));
			Class<?> mapper=mapperObject.getClass();
			Method selectByExample=mapper.getMethod("selectByExample", exampleClass);
			
			Class<?> modelClass=model.getClass();
			Field[] fields=modelClass.getDeclaredFields();
			for (Field field : fields) {
				TableColumn tableColumn=field.getDeclaredAnnotation(TableColumn.class);
				if(tableColumn!=null && tableColumn.uniqueness()){
					Method getBean=modelClass.getMethod("get"+CommonUtil.toUpperCaseFirstOne(field.getName()));
					Object value=getBean.invoke(model);
					
					Object criteriaObject=createCriteria.invoke(exampleObject);
					Method equalToMethod=criteria.getMethod("and"+CommonUtil.toUpperCaseFirstOne(field.getName())+"EqualTo", field.getType());
					equalToMethod.invoke(criteriaObject, value);
					
					List<?> rowList=(List<?>)selectByExample.invoke(mapperObject, exampleObject);
					if (!rowList.isEmpty()) {
						checkResult=false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("检查唯一性约束报错："+e.getMessage());
			checkResult=false;
		}
		return checkResult;
	}
}

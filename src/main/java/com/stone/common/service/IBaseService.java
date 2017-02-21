package com.kpap.common.service;

import java.util.List;

import com.kpap.common.dto.SearchKey;

public interface IBaseService {	
	public List<?> getRowsBySearchKey(SearchKey searchKey,String modelFullName) throws Exception;
	public int countBySearchKey(SearchKey searchKey,String modelFullName) throws Exception;
	public int delByPrimaryKey(Object primaryKey,String modelFullName) throws Exception;
	public int edit(Object bean,String modelFullName) throws Exception;
	public int add(Object bean,String modelFullName) throws Exception;
	public Object selectByPrimaryKey(Object primaryKey,String modelFullName) throws Exception;
	public int editSelective(Object bean,String modelFullName) throws Exception;
}

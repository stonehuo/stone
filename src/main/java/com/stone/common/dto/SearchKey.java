package com.kpap.common.dto;

import java.util.List;

public class SearchKey {
	public Integer page;
	public Integer rows;
	public String sort;
	public String order="asc";
	

	public String role;
	public String type;
	public List<String> status;
	public String proCode;
	public String name;
	
	public String proGroup;
	public List<String> category;
	
	public String creator;
	public String auditor;
	
	public String start_createDate;
	public String end_createDate;
	
	
	public String getStart_createDate() {
		return start_createDate;
	}
	public void setStart_createDate(String start_createDate) {
		this.start_createDate = start_createDate;
	}
	public String getEnd_createDate() {
		return end_createDate;
	}
	public void setEnd_createDate(String end_createDate) {
		this.end_createDate = end_createDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public List<String> getCategory() {
		return category;
	}
	public void setCategory(List<String> category) {
		this.category = category;
	}
	public String getProGroup() {
		return proGroup;
	}
	public void setProGroup(String proGroup) {
		this.proGroup = proGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public List<String> getStatus() {
		return status;
	}
	public void setStatus(List<String> status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPage() {
		return page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}

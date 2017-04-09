package com.main.identification.model;

import java.util.Date;

public class BaseModel {
	// page
	private int page;
	private int pageSize;
	private int startNo;
	
	// DB
	private int createId;
	private Date createTime;
	private int updateId;
	private Date lastModifyTime;
	private String createBy;
	private String lastModifyBy;
	private String deleteFlag;
	private String createor;
	private String updateor;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getCreateId() {
		return createId;
	}

	public void setCreateId(int createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setDefaultValue(){
		
	}
	
	public String getCreateor() {
		return createor;
	}

	public void setCreateor(String createor) {
		this.createor = createor;
	}

	public String getUpdateor() {
		return updateor;
	}

	public void setUpdateor(String updateor) {
		this.updateor = updateor;
	}
}

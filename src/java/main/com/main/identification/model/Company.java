package com.main.identification.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Company extends BaseModel implements Serializable{

	private static final long serialVersionUID = -3513357204981202994L;
	private String companyNo; // 单位编号
	private String companyName; // 单位名称
	private String companyType; // 单位类型
	private String companyCode; // 单位代号
	private String remark; // 备注
	
	private String deleteFlag = "0";     //删除Flag
	private String createBy;       //创建人
	private String  lastModifyBy;  //最后修改人
	private Timestamp createTime;  //创建时间
	private Timestamp lastModifyTime; //最后修改时间
	
	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getCompanyNo() {
		return companyNo;
	}
	
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

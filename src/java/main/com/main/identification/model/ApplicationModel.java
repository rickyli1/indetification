package com.main.identification.model;

public class ApplicationModel  extends BaseModel {
	  private String applicationNo; //申请编号
	  private String applicationDate; //申请日期YYYYMMDD
	  private String companyNo; //单位编号
	  private String resultFilePath; //结论文本文件路径
	  private String uploadAppFilePath;//申请文本文件路径
	  private String remark;//备注
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getResultFilePath() {
		return resultFilePath;
	}
	public void setResultFilePath(String resultFilePath) {
		this.resultFilePath = resultFilePath;
	}
	public String getUploadAppFilePath() {
		return uploadAppFilePath;
	}
	public void setUploadAppFilePath(String uploadAppFilePath) {
		this.uploadAppFilePath = uploadAppFilePath;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}

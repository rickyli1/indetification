package com.main.identification.model;

import java.io.Serializable;

/**
 * 专家Bean
 * 
 * @author YangQi
 */
public class Expert extends BaseModel implements Serializable {

	private static final long serialVersionUID = 3036203108688801142L;
	private String expertNo; // 专家编号
	private String expertName; // 专家姓名
	private String profession; // 专业
	private String companyNo; // 单位编号
	private String companyName; // 单位名
	private String professionalTitle; // 职称或职务
	private String remark; // 备注
	
	public String getExpertNo() {
		return expertNo;
	}
	public void setExpertNo(String expertNo) {
		this.expertNo = expertNo;
	}
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getProfessionalTitle() {
		return professionalTitle;
	}
	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}

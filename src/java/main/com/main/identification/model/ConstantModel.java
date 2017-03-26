package com.main.identification.model;

import java.sql.Timestamp;

import com.main.identification.utils.Constant;

/**
 * 
 * @author DUQIAO
 * @createtime 2017-03-12
 * @updatetime 2017-03-13
 * 常量实体类
 */
public class ConstantModel extends BaseModel {
	
	private String constantNo;     //常量NO
	private String constantType;   //设备类型
	private String constantName;   //常量名称
	private String parentNo;       //父常量NO
	private int    sort;           //排序
	private String attribute1;     //附加属性1
	private String attribute2;     //附加属性2
	private String attribute3;     //附加属性3
	
	private String deleteFlag = "0";     //删除Flag
	private String createBy;       //创建人
	private String  lastModifyBy;  //最后修改人
	private Timestamp createTime;  //创建时间
	private Timestamp lastModifyTime; //最后修改时间
	
//	private HashMap<String,ConstantModel> sonConstant = new HashMap<String,ConstantModel>();
//	
//	
//	public HashMap<String, ConstantModel> getSonConstant() {
//		return sonConstant;
//	}
//	public void setSonConstant(HashMap<String, ConstantModel> sonConstant) {
//		this.sonConstant = sonConstant;
//	}
	public String getConstantNo() {
		return constantNo;
	}
	public void setConstantNo(String constantNo) {
		this.constantNo = constantNo;
	}
	public String getConstantType() {
		return constantType;
	}
	public void setConstantType(String constantType) {
		this.constantType = constantType;
	}
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public String getParentNo() {
		return parentNo;
	}
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
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
	
	/**
	 * 
	 * @param constantModel
	 */
	public void setDefaultValue(ConstantModel constantModel){
		Timestamp time = new Timestamp(System.currentTimeMillis());
		constantModel.setDeleteFlag(Constant.DELETE_FLAG_FALSE);
		constantModel.setCreateBy("-1");
		constantModel.setLastModifyBy("-1");
		constantModel.setCreateTime(time);
		constantModel.setLastModifyTime(time);
	}
}

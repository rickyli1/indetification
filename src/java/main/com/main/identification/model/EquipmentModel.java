package com.main.identification.model;

import java.sql.Timestamp;

import com.main.identification.utils.Constant;

/**
 * 
 * @author DUQIAO
 * @createtime 2017-03-12
 * 设备实体类
 */
public class EquipmentModel extends BaseModel {
	private String    equipmentNo;    //设备NO
	private String equipmentName;  //设备NAME
	private String groupNo;        //专业编号
	private String subGroupNo;     //专业类别编号
	private int    sort;           //排序
	private String remark;         //备注
	private String deleteFlag = "0";     //删除Flag
	
	private String createBy;       //创建人
	private String  lastModifyBy;  //最后修改人
	private Timestamp createTime;  //创建时间
	private Timestamp lastModifyTime; //最后修改时间
	
	
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getSubGroupNo() {
		return subGroupNo;
	}
	public void setSubGroupNo(String subGroupNo) {
		this.subGroupNo = subGroupNo;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public void setDefaultValue(EquipmentModel equipmentModel){
		Timestamp time = new Timestamp(System.currentTimeMillis());
		equipmentModel.setDeleteFlag(Constant.DELETE_FLAG_FALSE);
		equipmentModel.setCreateBy("-1");
		equipmentModel.setLastModifyBy("-1");
		equipmentModel.setCreateTime(time);
		equipmentModel.setLastModifyTime(time);
	}
}

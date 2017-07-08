<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<div class="modal-body">   
<div class="container-fluid">
<div class="row">
	<div class="col-md-* col-xs-* col-sm-*">
	    <div class="row">
	      <div class="panel-body"> 
	           <fieldset>
	              <div class="form-group">
	                 <label class="col-md-1 control-label"  style="width:100px;" for="dequipmentName"><spring:message code="lable.equipment.equipmentName"/></label>
	                 <div class="col-md-2" style="width:180px;">
	                    <input type="text" class="form-control" id="dequipmentName">
	                    <input type="hidden" id="dequipmentNo" type="text" />
	                 </div>
	                 
	                 <label class="col-md-1 control-label" for="dgroupNo"  style="width:100px;"><spring:message code="lable.equipment.group"/></label>
	                 <div class="col-md-2" style="width:180px;">                
						<select  class="form-control" id="dgroupNo">
						  <c:forEach var="constant" items="${constants}" varStatus="status">
							  <option value="${constant.constantNo}">${constant.constantName}</option>
						  </c:forEach>					 
						</select>
	                 </div>
	                 
	                 <label class="col-md-1 control-label" for="dsubGroupNo" style="width:100px;"><spring:message code="lable.equipment.subGroup"/></label>
	                 <div class="col-md-2" style="width:180px;">                
						<select  class="form-control" id="dsubGroupNo">
					      <c:forEach var="constant" items="${constantsChild}" varStatus="status">
							  <option value="${constant.constantNo}">${constant.constantName}</option>
						  </c:forEach>				
						</select>
	                 </div>   
	              </div>
	           </fieldset>
	           <fieldset style="margin-top:10px">
	              <div class="form-group">  
	                 <label class="col-md-1 control-label" for="dsort" style="width:100px;"><spring:message code="lable.equipment.sort"/></label>
	                 <div class="col-md-2"  style="width:180px;">
	                    <input type="text" class="form-control" id="dsort">
	                 </div>
	                 
	                 <label class="col-md-1 control-label" for="dremark" style="width:100px;"><spring:message code="lable.equipment.remarks"/></label>
	                 <div class="col-md-2"  style="width:180px;">
	                    <input type="text" class="form-control" id="dremark">
	                 </div>
	                 
	                         
	              </div>
	           </fieldset>
	           <fieldset style="margin-top:10px">
	              <div class="form-group">
	                  <div class="col-md-1">
	                  <button type="button" class="btn btn-primary btn-sm" id="updateEquipmentBtn"><spring:message code="lable.equipment.equipmentSave"/></button>
	                  </div>                  
	               </div>  
	            </fieldset>       
		  </div>
		  
	    </div>
	</div>
</div>

<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  
<!-- <script type="text/javascript" src="/js/identification/equipment/equipmentAdd.js" charset="UTF-8"></script>
<script type="text/javascript">
   identification.equipmentAdd = new Identification.equipment.Add();
</script> -->

		
		

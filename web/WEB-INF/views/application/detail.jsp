<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  
<div class="modal-body">   
<div class="container-fluid">
<div class="row">
	<div class="col-md-* col-xs-* col-sm-*">
	    <div class="row">
	      <div class="col-xs-2 col-sm-2 col-md-3"> 
	      	<label class="control-label" for="detailCompanyName" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="lable.application.detail.company.name"/></label>
	      	<spam id="detailCompanyName" name="detailCompanyName"></spam>
	      </div>
	      <div class="col-xs-2 col-sm-2 col-md-3">
			<label class="control-label" for="detailCompanyCode" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="lable.application.detail.company.code"/></label>
	      	<spam id="detailCompanyCode" name="detailCompanyCode"></spam>
		  </div>
	      <div class="col-xs-2 col-sm-2 col-md-3">
			<label class="control-label" for="detailApplicationDate" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="lable.application.detail.application.date"/></label>
	      	<spam id="detailApplicationDate" name="detailApplicationDate"></spam>
		  </div>
		  <div class="col-xs-2 col-sm-2 col-md-3">
			<label class="control-label" for="detailDepartment" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="lable.application.detail.department"/></label>
	      	<spam id="detailDepartment" name="detailDepartment"></spam>
		  </div>
		  
	<!--   <a href="fileDownload/5909bfe20b62d03e7d94edc0">文档.txt</a> -->	
		  <div class="col-xs-2 col-sm-2 col-md-4">
			<label class="control-label" for="appFile" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="lable.application.detail.app.file"/></label>
	      	<a id="appFile"></a>
		  </div>
		  <div class="col-xs-2 col-sm-2 col-md-4">
			<label class="control-label" for="resultFile" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="lable.application.detail.result.file"/></label>
	      	<a id="resultFile"></a>
		  </div>
		  
	    </div>
	</div>
</div>

<div class="row">
  <div class="col-xs-12 col-sm-6 col-md-8">
      	 <div style="padding-top: 16px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>	               
	                <th><spring:message code="lable.application.detail.list.expert.name"/></th>
	                <th><spring:message code="lable.application.detail.list.expert.company"/></th>
	                <th><spring:message code="lable.application.detail.list.expert.role"/></th>
	              </tr>
	            </thead>
	            <tbody id="expertsBody">
	            </tbody>
	         </table>
         </div>
         <div class="text-center" hidden>
             <ul id="pagination-experts" class="pagination-sm pagination">
             </ul>
         </div>
  </div>
</div>

<div class="row">
  <div class="col-xs-4  col-sm-6 col-md-12">
       	 <div style="padding-top: 2px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th><spring:message code="lable.application.detail.list.equipment.type"/></th>
	                <th><spring:message code="lable.application.detail.list.equipment.sub.type"/></th>	  
	                <th><spring:message code="lable.application.detail.list.equipment.name"/></th>
	                <th><spring:message code="lable.application.detail.list.repair.level"/></th>
	                <th><spring:message code="lable.application.detail.list.application.result"/></th>	  
	                <th><spring:message code="lable.application.detail.list.rectify"/></th>
	                <th><spring:message code="lable.application.detail.list.limit.date"/></th>
	                <th><spring:message code="lable.application.detail.list.remark"/></th>
	              </tr>
	            </thead>
	            <tbody id="equipmentsBody">
	            </tbody>
	         </table>
         </div>
         <div class="text-center" hidden>
             <ul id="pagination-equipments" class="pagination-sm pagination">
             </ul>
         </div>
  </div>
</div>
</div> 
</div>
<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>   
<script type="text/javascript" src="/js/identification/application/detail.js" charset="UTF-8"></script>	    
<script type="text/javascript">
 identification.applicationDetail = new Identification.application.Detail();
</script>

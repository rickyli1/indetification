<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<div class="modal-body">   
<div class="container-fluid">
<div class="row">
	<div class="col-md-* col-xs-* col-sm-*">
	    <div class="row">
			<fieldset>
	           <div class="form-group">

	              <div class="form-group">
	                 <label class="col-md-2 control-label" for="detailCompanyName"><spring:message code="lable.company.companyName"/></label>
	                 <div class="col-md-2">
	                     <input class="form-control" id="detailCompanyName" type="text"/>
	                 </div>
	              </div>
	              <div class="form-group">
	                 <label class="col-md-2 control-label" for="detailCompanyCode"><spring:message code="lable.company.companyCode"/></label>
	                 <div class="col-md-2">                
	                    <input class="form-control" id="detailCompanyCode" type="text"/>
	                 </div>
	              </div>
	              <div class="form-group">   
	                 <label class="col-md-2 control-label" for="detailRemark"><spring:message code="lable.company.companyRemark"/></label>
	                 <div class="col-md-2">                
	                    <input class="form-control" id="detailRemark" type="text"/>
	                 </div>            
              	  </div>
				</div>
			</fieldset>
			<fieldset style="margin-top:30px">
	              <div class="modal-footer">
	                  <div class="col-md-1">
	                  <button type="button" class="btn btn-primary btn-sm" id="updateCompanyBtn"><spring:message code="lable.company.save"/></button>
	                  </div>                  
	              </div>  
	        </fieldset>
	    </div>
	</div>
</div>
<div id="updateCondition">
 	<input type="hidden" id="detailCompanyNoHide" value=""/>
 	<input type="hidden" id="detailCompanyNameHide" value=""/>
 	<input type="hidden" id="detailCompanyCodeHide" value=""/>
 	<input type="hidden" id="detailRemarkHide" value=""/>
 </div>
<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>   
<script type="text/javascript" src="/js/identification/company/update.js" charset="UTF-8"></script>	    
<script type="text/javascript">
 identification.companyUpdate = new Identification.company.Update();
</script>

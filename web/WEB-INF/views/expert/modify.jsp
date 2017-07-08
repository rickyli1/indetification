<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/jquery/autocomplete.min.css">
<style type="text/css">
    .ui-autocomplete{
        display:block;
        z-index:99999;
        width: 200px;
    }
    
 .ui-widget {
	font-family: Arial,Helvetica,sans-serif;
	font-size: 1em;
}
.ui-widget .ui-widget {
	font-size: 1em;
}
.ui-widget input,
.ui-widget select,
.ui-widget textarea,
.ui-widget button {
	font-family: Arial,Helvetica,sans-serif;
	font-size: 1em;
}
.ui-widget.ui-widget-content {
	border: 1px solid #c5c5c5;
}
.ui-widget-content {
	border: 1px solid #dddddd;
	background: #ffffff;
	color: #333333;
}
.ui-widget-content a {
	color: #333333;
}
.ui-widget-header {
	border: 1px solid #dddddd;
	background: #e9e9e9;
	color: #333333;
	font-weight: bold;
}
.ui-widget-header a {
	color: #333333;
}
    
.ui-menu {
	list-style: none;
	padding: 0;
	margin: 0;
	display: block;
	outline: 0;
}
.ui-menu .ui-menu {
	position: absolute;
}
.ui-menu .ui-menu-item {
	margin: 0;
	cursor: pointer;
	/* support: IE10, see #8844 */
	list-style-image: url("data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7");
}
.ui-menu .ui-menu-item-wrapper {
	position: relative;
	padding: 3px 1em 3px .4em;
}
.ui-menu .ui-menu-divider {
	margin: 5px 0;
	height: 0;
	font-size: 0;
	line-height: 0;
	border-width: 1px 0 0 0;
}
.ui-menu .ui-state-focus,
.ui-menu .ui-state-active {
	margin: -1px;
}    
</style>
<div class="modal-body">   
<div class="container-fluid">
<div class="row">
	    <div class="row">
	      <label class="col-md-2 control-label" for="modifyExpertName" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="label.expert.modify.modifyExpertName"/></label>
	      <div class="col-md-3"> 
	      	<input class="form-control" id="modifyExpertName" type="text"/>
	      </div>
	      
		  <label class="col-md-2 control-label" for="modifyProfession" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="label.expert.modify.modifyProfession"/></label>
	      <div class="col-md-3">
	      	<input class="form-control" id="modifyProfession" type="text"/>
		  </div>
		</div>
		<div class="row">
		  <label class="col-md-2 control-label" for="modifyProfessionalTitle" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="label.expert.modify.modifyProfessionalTitle"/></label>
		  <div class="col-md-3">
	      	<input class="form-control" id="modifyProfessionalTitle" type="text"/>
		  </div>
		  
		  <label class="col-md-2 control-label" for="modifyRemark" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="label.expert.modify.modifyRemark"/></label>
	      <div class="col-md-3">
	      	<input class="form-control" id="modifyRemark" type="text"/>
		  </div>
		</div>
		<div class="row">
		  <label class="col-md-2 control-label" for="modifyCompany" style="margin-top:8px;margin-left:13px;font:message-box"><spring:message code="label.expert.modify.modifyCompany"/></label>
	      <div class="col-md-3">
	        <select  class="form-control" id="modifyCompany">
				<option selected value=""></option>				
				<c:forEach var="modifyCompany" items="${modifyCompanys}" varStatus="status">
					<option value="${modifyCompany.companyNo}">${modifyCompany.companyName}</option>
				</c:forEach>					 
			</select>
	      </div>
	    </div>
	        
</div>
  <div class="modal-footer">
    <button type="button" id="modifyExpertBtn" class="btn btn-primary btn-sm"  style="margin-right:28px"><spring:message code="label.expert.modify.modifyBtn"/></button>
  </div>
 <div id="modifyCondition">
 	<input type="hidden" id="expertNoHide" value=""/>
 	<input type="hidden" id="companyNoHide" value=""/>
 </div>	
 <div id="alertDiv"></div>
</div> 
</div>
<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>

<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="/js/common/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/js/common/jquery/jquery.iframe-transport.js"></script>
<script src="/js/common/jquery/jquery.ui.js"></script> 
   
<script type="text/javascript" src="/js/identification/expert/modify.js" charset="UTF-8"></script>	    
<script type="text/javascript">
 identification.expertModify = new Identification.expert.Modify();
</script>

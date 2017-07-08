<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html> 
<head>
<title>request</title>
<link rel="stylesheet" href="/css/jquery/autocomplete.min.css">
<c:import url="/WEB-INF/views/common/commonCss.jsp"></c:import>
<link rel="stylesheet" href="/css/jquery/jquery.fileupload.css">
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
</head>
<body>
 <div class="container">
    <c:import url="/WEB-INF/views/common/navgate.jsp"></c:import>
	<div class="panel panel-primary">
	  <div class="panel-heading"><spring:message code="lable.application.update.title"/></div>
	  <div class="panel-body"> 
      <form class="form-horizontal" role="form">
             <fieldset>
                <div class="form-group">
                  <div class="col-md-10">
                  <button type="button" class="btn btn-primary btn-sm" id="addApplicationDetailBtn"><spring:message code="button.application.update.detail"/></button>
                  <span style="color:blue; font-size:5px"><spring:message code="lable.application.update.remark"/></span>
                  </div>
                  <div class="col-md-1">
                  <button type="button" class="btn btn-primary btn-sm" id="saveApplicationBtn"><spring:message code="button.application.update.save.application"/></button>
                  </div>                  
               </div>  
            </fieldset>   
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label"  for="company" id="companyLable"><spring:message code="lable.application.update.company.name"/></label>
                 <div class="col-md-3">   
                  <input type="text" class="form-control"  id="company" value="${app.companyName}" readonly="readonly"/>             
					  <select  class="form-control" id="companySelect" style="display:none">
					  <c:forEach var="company" items="${companys}" varStatus="status">
						  <option value="${company.companyNo}">${company.companyName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 
                 <label class="col-md-1 control-label" for="department"><spring:message code="lable.application.update.deparment"/></label>
                 <div class="col-md-3">                
                    <input class="form-control" id="department" type="text" value="${app.department}"/>
                 </div>    
                 
              
                 <label class="col-md-1 control-label" for="expert"><spring:message code="lable.application.update.expert"/></label>
                 <div class="col-md-3">    
					<div class="input-group">
					      <input type="text" class="form-control" id="expert" readonly="readonly" value="${app.expertsName}"/>
					      <span class="input-group-btn">
					        <button class="btn btn-default" type="button" data-toggle="modal" data-target="#expertModal">...</button>
					      </span>
					</div><!-- /input-group -->
                    
					<select  class="form-control" id="expertSelect" style="display:none">
					 <option selected value=""></option>				
					  <c:forEach var="expert" items="${experts}" varStatus="status">
						  <option value="${expert.expertNo}">${expert.expertName}</option>
					  </c:forEach>					 
					</select>
                </div>
              
             </div> 
              <div class="form-group">
                <label class="col-md-1 control-label" for="applicationDate"><spring:message code="lable.application.update.application.date"/></label>
                 <div class="col-md-3">
                    <span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="applicationDate" data-link-format="yyyy-mm-dd">
                    <input class="form-control" type="text" value="${app.applicationDate}" >
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </span>
				     <input type="hidden" id="applicationDate" value="${app.applicationDate}" />
                 </div>     
                 
                 <label class="col-md-1 control-label" for="department"><spring:message code="lable.application.update.application.file"/></label>
                 
				<div class="col-md-3">
		 			<span class="btn btn-default  btn-sm fileinput-button">
				        <i class="glyphicon glyphicon-plus"></i>
				        <span><spring:message code="lable.application.update.application.select.file"/></span>
				        <!-- The file input field used as target for the file upload widget -->
				         <input id="requestFileupload"  type="file" name="file" multiple>
				    </span>
				    <span>
				     <span id="requsetFileNameSpan">${app.appFileName}</span>
				     <input type="hidden" id="requsetFileIdHid" value="${app.appFileNo}"/>
				    </span>
				</div>     
				            
                <label class="col-md-1 control-label" for="department"><spring:message code="lable.application.update.result.file"/></label>
				<div class="col-md-3">
		 			<span class="btn btn-default btn-sm fileinput-button">
				        <i class="glyphicon glyphicon-plus"></i>
				        <span><spring:message code="lable.application.update.application.select.file"/></span>
				        <!-- The file input field used as target for the file upload widget -->
				         <input id="resultFileupload"  type="file" name="file" multiple>
				    </span>
				    <span>
				     <span id="resultFileNameSpan">${app.resultFileName}</span>
				     <input type="hidden" id="resultFileIdHid" value="${app.resultFileNo}"/>
				    </span>				    
				</div>                                           
              </div>
              
           </fieldset>     
           <fieldset>             
               <div class="form-group container" style="margin-left:-25px">
                 <div class="col-md-12">
					<table class="table table-hover table-bordered" id="applicationDetailTable">
                          <colgroup>
                            <col/>  
                            <col  style="width:80px"/>  
                            <col  style="width:80px"/>  
                            <col  style="width:80px"/>  
                            <col  style="width:160px"/>  
                            <col  style="width:120px"/>  
                            <col  style="width:50px"/>  
					       </colgroup>					
					      <thead>
					        <tr>
					          <th id="equipmentTh"><spring:message code="lable.application.update.list.equipment"/></th>
					          <th><spring:message code="lable.application.update.list.repair.level"/></th>
					          <th><spring:message code="lable.application.update.list.result"/></th>
					          <th><spring:message code="lable.application.update.list.rectify"/></th>
					          <th><spring:message code="lable.application.update.list.limit.date"/></th>
					          <th><spring:message code="lable.application.update.list.remark"/></th>
					          <th><spring:message code="lable.application.update.list.operation"/></th>
					        </tr>
					      </thead>
					      <tbody id="applicationDetailBody">
					           <c:forEach var="report" items="${reports}" varStatus="status">
								<tr id="tr${status.count}" data-no="${status.count}" class="addTr">
									<td>
								    <input type="text" class="form-control equipment"  id="equipment${status.count}" value="${report.equipmentName}"/>  
									<select  class="form-control" id="equipmentSelect${status.count}"style= "display:none">
								        <option selected value=""></option>
								        <c:forEach var="equipment" items="${equipments}">
								        <option value="${equipment.equipmentNo}">${equipment.equipmentName}</option>
								        </c:forEach>
									</select>    
									<td style="width:100px;">	
									<select  class="form-control" id="repairLevel${status.count}">
								         <option selected value=""></option>
								        <c:forEach var="repairLevel" items="${repairLevels}">
								        <option value="${repairLevel.constantNo}" <c:if test="${repairLevel.constantNo == report.repairLevel}">selected</c:if> >${repairLevel.constantName}</option>
								        </c:forEach>								         
									</select>  
									
									</td>
									<td>
									<input type="radio" name="result${status.count}" value="1" <c:if test="${report.result == 1}">checked</c:if>><spring:message code="lable.application.update.detail.result.ok"/><br>
									<input type="radio" name="result${status.count}" value="0" <c:if test="${report.result == 0}">checked</c:if>><spring:message code="lable.application.update.detail.result.unqualified"/>
									</td>								  
									<td>
									<input type="radio" name="isReform${status.count}" value="1" <c:if test="${report.isReform == 1}">checked</c:if>><spring:message code="lable.application.update.detail.rectify"/><br>
									<input type="radio" name="isReform${status.count}" value="0" <c:if test="${report.isReform == 0}">checked</c:if>><spring:message code="lable.application.update.detail.no.rectify"/>
									</td>	
									<td>
								
									<span class="input-group date form_year" data-date=""  data-date-format="yyyy" data-link-format="yyyy" data-link-field="timeLimit${status.count}">
									<input class="form-control"  type="text" value="${report.timeLimit}" >
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									</span>
										<input type="hidden" id="timeLimit${status.count}" value="${report.timeLimit}" />
									</td>
								    <td>
								         <input type="text" value ="${report.remark}" id="remark${status.count}"/>
								    </td>		
								    <td>
								         <button type="button" class="btn btn-primary btn-sm deleteClass"  id="delete${status.count}" data-no="${status.count}"><spring:message code="button.application.update.detail.delete"/></button>
								    </td>					  
								</tr>						           
					           </c:forEach>				      
					      </tbody>
					    </table>
					    <input type="hidden" value="${fn:length(reports)}" id="reportCountId">
					    <input type="hidden" value="${app.applicationNo}" id="applicationId">
		    
						<select  class="form-control" id="equipmentInfoSelect"style= "display:none">
					        <option selected value=""></option>
					        <c:forEach var="equipment" items="${equipments}">
					        <option value="${equipment.equipmentNo}">${equipment.equipmentName}</option>
					        </c:forEach>
						</select>  					    
                 </div>             
               </div>
           </fieldset>
       </form>
	  </div>
	</div>
</div>	
<div id="alertDiv"></div>

 <!-- import Modal -->
		<div class="modal fade" id="expertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" style="width:900px">
		    <form method="post">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel"><spring:message code="lable.application.update.list.expert.select.title"/></h4>
		      </div>
		      
		      	<c:import url="/WEB-INF/views/application/chooseExpert.jsp" charEncoding="UTF-8"></c:import>  	      
		    </div>
		    </form>
		  </div>


     </div> 	
 
    <div class="modal-backdrop fade in" style="display:none; z-index:10000" id="loading">
		  <div class="loading"></div>  
	 </div>
	 
	 <div>
	 	<input type="hidden" id="expertsNo" value="${app.expertsNo}"/>
	 	<input type="hidden" id="leaderNo" value="${app.leaderNo}"/>
	 </div>
</body>



<script id="detailTemplate" type="text/x-jquery-tmpl">
<tr id="tr{{= no}}" data-no="{{= no}}" class="addTr">
	<td>
    <input type="text" class="form-control equipment"  id="equipment{{= no}}"/>  
	<select  class="form-control" id="equipmentSelect{{= no}}"style= "display:none">
        <option selected value=""></option>
        {{each equipments}} <option value="{{= $value.equipmentNo}}">{{= $value.equipmentName}}</option>{{/each}}
	</select>    
	<td style="width:100px;">	
	<select  class="form-control" id="repairLevel{{= no}}">
         <option selected value=""></option>
        {{each repairLevels}} <option value="{{= $value.constantNo}}">{{= $value.constantName}}</option>{{/each}}
	</select>  
	
	</td>
	<td>
	<input type="radio" name="result{{= no}}" value="1"><spring:message code="lable.application.update.detail.result.ok"/><br>
	<input type="radio" name="result{{= no}}" value="0">不合格<spring:message code="lable.application.update.detail.result.unqualified"/>
	</td>								  
	<td>
	<input type="radio" name="isReform{{= no}}" value="1"><spring:message code="lable.application.update.detail.rectify"/><br>
	<input type="radio" name="isReform{{= no}}" value="0"><spring:message code="lable.application.update.detail.no.rectify"/>
	</td>	
	<td>

	<span class="input-group date form_year" data-date=""  data-date-format="yyyy" data-link-format="yyyy" data-link-field="timeLimit{{= no}}">
	<input class="form-control"  type="text" value="" readonly='true'>
	<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
	</span>
		<input type="hidden" id="timeLimit{{= no}}" value="" />
	</td>
    <td>
         <input type="text" value ="" id="remark{{= no}}"／>
    </td>		
    <td>
         <button type="button" class="btn btn-primary btn-sm deleteClass"  id="delete{{= no}}" data-no="{{= no}}"><spring:message code="button.application.update.detail.delete"/></button>
    </td>					  
</tr>
</script>

<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="/js/common/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/js/common/jquery/jquery.iframe-transport.js"></script>
<script src="/js/common/jquery/jquery.ui.js"></script>
<!-- The basic File Upload plugin -->
<script src="/js/common/jquery/jquery.fileupload.js"></script>
   <script type="text/javascript" src="/js/identification/application/applicationUpdate.js" charset="UTF-8"></script>	    
   <script type="text/javascript">
   identification.applicationUpdate = new Identification.application.Update();
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
	<head> 
	    <meta charset="utf-8">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <c:import url="/WEB-INF/views/common/commonCss.jsp"></c:import>
	</head>
	<body>
		<div class="container">
			<c:import url="/WEB-INF/views/common/navgate.jsp"></c:import>

	<div class="panel panel-primary">
	  <div class="panel-heading"><spring:message code="label.expert.search.infoSearch"/></div>
		  <div class="panel-body"> 
		  
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="expertName"><spring:message code="label.expert.search.expertName"/></label>
                 <div class="col-md-2">
                    <input type="text" id="expertName" class="form-control" name="expertName">
                 </div>
                 <label class="col-md-1 control-label" for="profession"><spring:message code="label.expert.search.profession"/></label>
                 <div class="col-md-2">                
					<input type="text" id="profession" class="form-control" name="profession">
                 </div>
                 
                 <label class="col-md-1 control-label" for="companyName"><spring:message code="label.expert.search.companyName"/></label>
                 <div class="col-md-2">                
                   <input type="text" id="companyName" class="form-control" name="companyName">
                 </div>
	            <div class="col-md-1" style="float:right;">
	            	<button id="searchBtn" class="btn btn-primary"><spring:message code="label.expert.search.btn"/></button>
	            </div>
              </div>

           </fieldset>
           
	       	<div id="expertResultList">
	       	<c:import url="/WEB-INF/views/expert/list.jsp" charEncoding="UTF-8"></c:import>  
	       	</div>
	       	
 <!-- import Modal -->
      <div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="modifyModalLabel" aria-hidden="true">
      	<div class="modal-dialog" style="width:900px">
      		<form method="post">
      			<div class="modal-content">
      				<div class="modal-header">
      					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        		<h4 class="modal-title" id="modifyModalLabel"><spring:message code="label.expert.modal.modify"/></h4>
      				</div>
				<c:import url="/WEB-INF/views/expert/modify.jsp" charEncoding="UTF-8"></c:import>
				</div>
			</form>
		</div>
	  </div>
      <div class="modal-backdrop fade in" style="display:none" id="loading">
		<div class="loading"></div>  
	  </div>
      	      
	      </div>
      </div>
      </div>
      
	<select  class="form-control" id="modifyCompanySelect" style="display:none">
		<c:forEach var="modifyCompany" items="${modifyCompanys}" varStatus="status">
			<option value="${modifyCompany.companyNo}">${modifyCompany.companyName}</option>
		</c:forEach>
	</select>

<!-- yangqi     -->
 <div id="searchCondition">
 	<input type="hidden" id="page" value="1"/>
 	<input type="hidden" id="expertNameHide" value=""/>
 	<input type="hidden" id="professionHide" value=""/>
 	<input type="hidden" id="companyNameHide" value=""/>
 </div>		

	    <script type="text/javascript" src="/js/identification/expert/expert.js" charset="UTF-8"></script>	    
	    <script type="text/javascript">
	    identification.expert = new Identification.expert.List();

	    function goPage() {
	    	identification.expert.searchList();
		}
      </script>

	  </body>
</html>


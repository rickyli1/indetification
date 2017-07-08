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
	  <div class="panel-heading"><spring:message code="lable.company.companySearch"/></div>
		  <div class="panel-body"> 
		  
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="companyName"><spring:message code="lable.company.companyName"/></label>
                 <div class="col-md-2" style="width:220px;">
                    <input type="text" class="form-control" id="companyName" name="companyName">
                 </div>
                 
                 <label class="col-md-1 control-label" for="companyCode"><spring:message code="lable.company.companyCode"/></label>
                 <div class="col-md-2" style="width:220px;">
                    <input type="text" class="form-control" id="companyCode" name="companyCode">
                 </div>
                 <!-- 
                 <label class="col-md-1 control-label" for="companyType">单位类型</label>
                 <div class="col-md-2">                
					<select  class="form-control" id="companyType">
					 <option selected value=""></option>				
					  <c:forEach var="companyType" items="" varStatus="status">
						  <option value="0">维修单位</option>
						  <option value="1">专家单位</option>
					  </c:forEach>					 
					</select>
                 </div>
                 -->

              </div>
           </fieldset> 
           <fieldset style="margin-top:10px">
              <div class="col-md-1" style="float:right">
	            	<button id="searchBtn" class="btn btn-primary"><spring:message code="lable.company.search"/></button>
	          </div>
           </fieldset>  		  
 
	       	<div id="companyResultList">
	       	<c:import url="/WEB-INF/views/company/list.jsp" charEncoding="UTF-8"></c:import>  
	       	</div>
      	
      	 <!-- import Modal   -->	
      <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true">
      	<div class="modal-dialog" style="width:900px">
      		<form method="post">
      			<div class="modal-content">
      				<div class="modal-header">
      					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        		<h4 class="modal-title" id="detailModalLabel"><spring:message code="lable.company.company"/></h4>
      				</div>
				<c:import url="/WEB-INF/views/company/update.jsp" charEncoding="UTF-8"></c:import>
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

 <div id="searchCondition">
 	<input type="hidden" id="page" value="1"/>
 	<input type="hidden" id="companyNameHide" value=""/>
 	<input type="hidden" id="companyCodeHide" value=""/>
 	<input type="hidden" id="companyTypeHide" value=""/>
 </div>		

	    <script type="text/javascript" src="/js/identification/company/company.js" charset="UTF-8"></script> 	    
	    <script type="text/javascript">
	    identification.company = new Identification.company.List();

	    function goPage() {
	    	identification.company.searchList();
		}
      </script>

	  </body>
</html>


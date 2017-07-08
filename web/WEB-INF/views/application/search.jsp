<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
	  <div class="panel-heading"><spring:message code="lable.application.search.title"/></div>
		  <div class="panel-body"> 
		  
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="companyName"><spring:message code="lable.application.search.company.name"/></label>
                 <div class="col-md-2">
                    <input type="text" id="companyName" class="form-control" name="companyName">
                 </div>
                 <label class="col-md-1 control-label" for="equipmentName"><spring:message code="lable.application.search.equipment.name"/></label>
                 <div class="col-md-2">                
					<input type="text" id="equipmentName" class="form-control" name="equipmentName">
                 </div>
                 
                 <label class="col-md-1 control-label" for="expertNameCon"><spring:message code="lable.application.search.expert.name"/></label>
                 <div class="col-md-2">                
                   <input type="text" id="expertNameCon" class="form-control" name="expertName">
                 </div>                 
              </div>
           </fieldset>
           
           <fieldset style="margin-top:10px">
              <div class="form-group">
				 
                <!-- 结果 -->
                 <label class="col-md-1 control-label" for="resultCon"><spring:message code="lable.application.search.application.result"/></label>
                 <div class="col-md-2">                
					<select  class="form-control" id="resultCon">
						<option selected value=""></option>
						<option value="1"><spring:message code="lable.application.search.application.result.ok"/></option>
						<option value="0"><spring:message code="lable.application.search.application.result.unqualified"/></option>
					</select>
                 </div>
                <!-- 修理级别 -->
                 <label class="col-md-1 control-label" for="repairLevel"><spring:message code="lable.application.search.repair.level"/></label>
                 <div class="col-md-2">                
					<select  class="form-control" id="repairLevelCon">
					 <option selected value=""></option>				
					  <c:forEach var="repairLevel" items="${repairLevels}" varStatus="status">
						  <option value="${repairLevel.constantNo}">${repairLevel.constantName}</option>
					  </c:forEach>
					</select>
                 </div>
                 
				<!-- 有效期 -->
                <label for="limitDate" class="col-md-1 control-label"><spring:message code="lable.application.search.limit.date"/></label>
                <div class="col-md-2">
                	<span class="input-group date form_year" data-date="" data-date-format="yyyy" data-link-field="limitDate" data-link-format="yyyy">
                    	<input class="form-control" size="4" type="text" value="" readonly='true'>
                    	<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </span>
                </div>
                <div class="col-md-1" style="float:right">
	            	<button id="searchBtn" class="btn btn-primary"><spring:message code="button.application.search.search"/></button>
	            </div>
                <input type="hidden" id="limitDate" value="" />
                
             <fieldset style="margin-top:10px;display:none" hidden>
             	<!-- 申请日期条件，客户说去掉，暂时隐藏 -->
                <div class="form-group" hidden>
                 <label class="col-md-1 control-label" for="applicationDate">申请日期</label>
                 <div class="col-md-2">
                    <span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="applicationDateFrom" data-link-format="yyyy-mm-dd">
                    <input class="form-control"  type="text" value="" >
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </span>
				    <input type="hidden" id="applicationDateFrom" value="" />
				 </div>
				 <div class="col-md-1">   
				    <span>~</span>
				  </div>
				  <div class="col-md-2"  style="margin-left:-53px">
	       		    <span class="input-group date form_date"  data-date="" data-date-format="yyyy-mm-dd" data-link-field="applicationDateTo" data-link-format="yyyy-mm-dd">
	                   	<input class="form-control" type="text" value="" />
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
	               	</span>
					<input type="hidden" id="applicationDateTo" value="" />     				     
                  </div>  
                 </div>
              </div>

           </fieldset>
 		  
	       	<div id="applicationResultList">
	       	<c:import url="/WEB-INF/views/application/list.jsp" charEncoding="UTF-8"></c:import>  
	       	</div>
	       	
 <!-- import Modal -->
      <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true" style="display:none">
      	<div class="modal-dialog" style="width:900px">
      		<form method="post">
      			<div class="modal-content">
      				<div class="modal-header">
      					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        		<h4 class="modal-title" id="detailModalLabel"><spring:message code="lable.application.search.detail.page.title"/></h4>
      				</div>
				<c:import url="/WEB-INF/views/application/detail.jsp" charEncoding="UTF-8"></c:import>
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
 <div id="alertDiv"></div>
<!-- yangqi     -->
 <div id="searchCondition">
 	<input type="hidden" id="page" value="1"/>
 	<input type="hidden" id="companyNameHide" value=""/>
 	<input type="hidden" id="equipmentNameHide" value=""/>
 	<input type="hidden" id="expertNameConHide" value=""/>
 	<input type="hidden" id="repairLevelConHide" value=""/>
 	<input type="hidden" id="resultConHide" value=""/>
 </div>		

	    <script type="text/javascript" src="/js/identification/application/application.js" charset="UTF-8"></script>	    
	    <script type="text/javascript">
	    identification.application = new Identification.application.List();

	    function goPage() {
	    	identification.application.searchList();
		}
      </script>

	  </body>
</html>


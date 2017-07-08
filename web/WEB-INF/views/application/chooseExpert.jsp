<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<div class="modal-body">   
<div class="container-fluid">
<div class="row">

<div class="col-md-* col-xs-* col-sm-*">
    <div class="row">
       <div class="col-xs-2 col-sm-2 col-md-2"> <label class="control-label" for="chooseExpertName" style="margin-top:8px;margin-left:13px">专家名</label></div>
      <div class="col-xs-8 col-sm-6 col-md-8">  <input type="text" class="form-control" id="chooseExpertName"/>  </div>
      <div class="col-xs-2 col-sm-2 col-md-2"> <button type="button" class="btn btn-primary btn-sm" id="searchExpertBtn" style="margin-left:38px">查询</button> </div>
    </div>
</div>

	
   
</div>
<div class="row">
  <div class="col-xs-12 col-sm-6 col-md-8">
      	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>	               
	                <th><spring:message code="lable.application.chooseExpert.list.name"/></th>
	                <th><spring:message code="lable.application.chooseExpert.list.profession"/></th>
	                <th><spring:message code="lable.application.chooseExpert.list.profession.title"/></th>
	                <th><spring:message code="lable.application.chooseExpert.list.company"/></th>
	                <th><spring:message code="lable.application.chooseExpert.list.operation"/></th>
	              </tr>
	            </thead>
	            <tbody id="expertBody">
	            </tbody>
	         </table>
         </div> 
          <div class="text-center">
                <ul id="pagination-expert" class="pagination-sm pagination">
               </ul>
          </div>	          
  </div>
  <div class="col-xs-6  col-sm-6 col-md-4">
       	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th><spring:message code="lable.application.chooseExpert.list.expert"/></th>
	                <th><spring:message code="lable.application.chooseExpert.list.expert.leader"/></th>	  
	                <th><spring:message code="lable.application.chooseExpert.list.operation"/></th>             
	              </tr>
	            </thead>
	            <tbody id="setExpertBody">
	            </tbody>
	         </table>
         </div> 
  </div>
</div>
</div> 
 </div>
			   		      
  <div class="modal-footer">
    <button type="button" id="saveExpertBtn" class="btn btn-primary btn-sm"  style="margin-right:28px"><spring:message code="button.application.chooseExpert.ok"/></button>
  </div>	 
<div><input type="hidden" id="page"/></div>
<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>   
<script type="text/javascript" src="/js/common/jquery/jquery.twbsPagination.min.js" charset="UTF-8"></script>    
<script type="text/javascript" src="/js/identification/application/chooseExpert.js" charset="UTF-8"></script>	    
<script type="text/javascript">
 identification.applicationChooseExpert = new Identification.application.ChooseExpert();
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html> 
<head>
<title>request</title>

<c:import url="/WEB-INF/views/common/commonCss.jsp"></c:import>
</head>
<body>
 <div class="container	">
    <c:import url="/WEB-INF/views/common/navgate.jsp"></c:import>
	<div class="panel panel-primary">
	  <div class="panel-heading"><spring:message code="lable.constant.constantAdd"/></div>
	  <div class="panel-body"> 
      <form class="form-horizontal" role="form"> 
           <fieldset style="margin-top:10px">
                <div class="form-group">
                  <div class="col-md-1">
                  <button type="button" class="btn btn-primary" id="saveconstantBtn"><spring:message code="lable.constant.constantSave"/></button>
                  </div>                  
               </div>  
            </fieldset> 
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="constantType"><spring:message code="lable.constant.constantType"/></label>
                 <div class="col-md-2">
	                 <select  class="form-control" id="constantType">
					 	<option selected value=""></option>				
						<option value="P_TYPE"><spring:message code="lable.constant.constantPType"/></option>
						<option value="C_TYPE"><spring:message code="lable.constant.constantCType"/></option>
						<option value="REPAIR_LEVEL"><spring:message code="lable.constant.constantRType"/></option>
					 </select>
				 </div>

                 <label class="col-md-1 control-label" for="constantName"><spring:message code="lable.constant.constantName"/></label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="constantName" name="constantName">
                 </div>
                 
                 <label class="col-md-1 control-label" for="parentNo"><spring:message code="lable.constant.constantParentNo"/></label>
                 <div class="col-md-2">
                   <select  class="form-control" id="parentNo">
					 <option selected value=""></option>				
					  <c:forEach var="constant" items="${constants}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 
                 <label class="col-md-1 control-label" for="sort"><spring:message code="lable.constant.constantSort"/></label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="sort" name="sort">
                 </div>
              </div>
         </fieldset>
         <fieldset style="margin-top:10px">
              <div class="form-group">   

                 <label class="col-md-1 control-label" for="attribute1"><spring:message code="lable.constant.constantAttribute1"/></label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="attribute1" name="attribute1">
                 </div>

                 <label class="col-md-1 control-label" for="attribute2"><spring:message code="lable.constant.constantAttribute2"/></label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="attribute2" name="attribute2">
                 </div>
                 
                 <label class="col-md-1 control-label" for="attribute3"><spring:message code="lable.constant.constantAttribute3"/></label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="attribute3" name="attribute3">
                 </div>     
              </div>
           </fieldset>
                  
       </form>
	  </div>
	</div>
</div>
<div id="alertDiv"></div>
</body>

<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  
<script type="text/javascript" src="/js/identification/constant/constantAdd.js" charset="UTF-8"></script>
<script type="text/javascript">
   identification.constantAdd = new Identification.constant.Add();
</script>
</html>
		
		

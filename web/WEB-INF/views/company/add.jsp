<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	  <div class="panel-heading">新增单位信息</div>
	  <div class="panel-body"> 
      <form class="form-horizontal" role="form">
      		<fieldset>
                <div class="form-group">
                  <div class="col-md-1">
                  <button type="button" class="btn btn-primary btn-sm" id="saveCompanyBtn">保存单位</button>
                  </div>                  
               </div>  
            </fieldset>  
           	<fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="companyName">单位名称</label>
                 <div class="col-md-2">
                     <input class="form-control" id="companyName" type="text"/>
                 </div>
                 
                 <label class="col-md-1 control-label" for="companyCode">单位代号</label>
                 <div class="col-md-2">                
                    <input class="form-control" id="companyCode" type="text"/>
                 </div>
                 
                 <label class="col-md-1 control-label" for="remark">备注</label>
                 <div class="col-md-2">                
                    <input class="form-control" id="remark" type="text"/>
                 </div>
                 <!--  
                 <label class="col-md-1 control-label" for="companyType">单位类型</label>
                 <div class="col-md-2">                
					<select  class="form-control" id="companyType">
					 <option selected value=""></option>				
					  <c:forEach var="companyType" items="${companyType}" varStatus="status">
						  <option value="${company.companyNo}">${company.companyName}</option>
					  </c:forEach>			 
					</select>
                 </div> 
                 -->              
              </div>
           </fieldset>
                  
       </form>
	  </div>
	</div>
</div>
<div id="alertDiv"></div>
</body>

<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  
<script type="text/javascript" src="/js/identification/company/companyAdd.js" charset="UTF-8"></script>
<script type="text/javascript">
   identification.companyAdd = new Identification.company.Add();
</script>
</html>
		
		

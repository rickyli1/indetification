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
	  <div class="panel-heading">新增常量信息</div>
	  <div class="panel-body"> 
      <form class="form-horizontal" role="form"> 
           <fieldset style="margin-top:10px">
                <div class="form-group">
                  <div class="col-md-1">
                  <button type="button" class="btn btn-primary" id="saveconstantBtn">保存常量</button>
                  </div>                  
               </div>  
            </fieldset> 
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="constantType">常量类型</label>
                 <div class="col-md-2">
	                 <select  class="form-control" id="constantType">
					 	<option selected value=""></option>				
						<option value="P_TYPE">专业</option>
						<option value="C_TYPE">子专业</option>
						<option value="REPAIR_LEVEL">检修级别</option>
					 </select>
				 </div>

                 <label class="col-md-1 control-label" for="constantName">常量名称</label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="constantName" name="constantName">
                 </div>
                 
                 <label class="col-md-1 control-label" for="parentNo">父节点</label>
                 <div class="col-md-2">
                   <select  class="form-control" id="parentNo">
					 <option selected value=""></option>				
					  <c:forEach var="constant" items="${constants}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 
                 <label class="col-md-1 control-label" for="sort">排序</label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="sort" name="sort">
                 </div>
              </div>
         </fieldset>
         <fieldset style="margin-top:10px">
              <div class="form-group">   

                 <label class="col-md-1 control-label" for="attribute1">附加属性1</label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="attribute1" name="attribute1">
                 </div>

                 <label class="col-md-1 control-label" for="attribute2">附加属性2</label>
                 <div class="col-md-2">
                    <input type="text" class="form-control" id="attribute2" name="attribute2">
                 </div>
                 
                 <label class="col-md-1 control-label" for="attribute3">附加属性3</label>
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
		
		

																							<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			  <div class="panel-heading">数据导出</div>
			  <div class="panel-body"> 
			  <form action="exportEquipmentList" method="post"  class="form-horizontal" role="form"> 
				  <div class="col-md-2">
				    <input  type="submit" class="btn btn-primary btn-sm" value="导出"/>	      
		          </div>		          
		      </form>
		      </div>
		     </div>
       	</div> 
      
		<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  
	  </body>
</html>


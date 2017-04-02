<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
	<head> 
	    <meta charset="utf-8">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="/css/bootstrap/bootstrap-theme.min.css">
		<link rel="stylesheet" href="/css/bootstrap/docs.min.css">
		<link href="/css/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/css/common.css">
	</head>
	 <body>
		<div class="container">
	      <c:import url="/WEB-INF/views/common/navgate.jsp"></c:import>

		  <h4 style="margin-top:-9px">Upload>Upload</h4>
		  <form action="baseInfoUpload" method="post" enctype="multipart/form-data"> 
		  <div class="jumbotron" style="height:150px;">
		     <table style="margin-top:-30px">
		     	<tr>
		     	<td>
		     	 
				<input type="file" name="file" />
		     	</td>
		     	 <td >
		     	 	<input  type="submit" class="btn btn-default" style="margin-left:61px" value="Upload"/>
		     	</td>
		     	</tr>
		     </table>
		  </div>
		  </form>
       	</div> 
      
		<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  
	  </body>
</html>


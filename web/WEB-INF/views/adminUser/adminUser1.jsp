<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html> 
	<head> 
	<title>管理员</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
		<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
		<link href="../../css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link rel="stylesheet" href="../../css/common.css">   
</head> 

<body> 
<c:import url="/WEB-INF/views/navigation.jsp"></c:import>

		<form action="/adminUser/add" method="post">
		 <div class="tbl_defalut">
			<table border="1">
			<colgroup><col style="width:120px">
			<col>

			</colgroup><tbody><tr>
			<th>名字<span class="point">*</span></th>
			<td>
				<input type="text" name="userName" class="input" style="width:150px">
			</td>
			</tr>
			
			<tr>
		    <th>密码<span class="point">*</span></th>
			<td>
				<input type="password" name="password" id="password" class="input" style="width:150px">
			</td>
			</tr>
			
			<tr>
		    <th>密码<span class="point">*</span></th>
			<td>
				<input type="password" name="confirmPassword" id="confirmPassword" class="input" style="width:150px">
			</td>
			</tr>	
			
			
			<tr>
		    <th>&nbsp;</th>
			<td>
				<input type="submit" value="确认"/>&nbsp;
				<button id="cancelBtn">取消</button>&nbsp;
			</td>
			</tr>					
	
			</tbody>
			
			</table>
		</div>
    </form>

</body>
</html>

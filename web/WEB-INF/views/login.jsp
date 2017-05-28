<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
 
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
<c:import url="/WEB-INF/views/common/commonCss.jsp"></c:import>
</head>
<body onload='document.loginForm.username.focus();' style="background:url(/images/7.jpg)no-repeat;background-size:100%">
 <div class="container">
	<div  style="width:443px;margin: 100px auto;">
	  <div> 
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>
 
		  <table>
			<tr>
				<td>用户名:</td>
				<td width="20px">&nbsp;</td>
				<td><input type='text' name='username' value='test'></td>
			</tr>
		    <tr>
				<td>&nbsp;</td>
				<td width="20px">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td width="20px">&nbsp;</td>
				<td><input type='password' name='password' value="123"/></td>
			</tr>
		    <tr>
				<td>&nbsp;</td>
				<td width="20px">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>			
			<tr align="right">
				<td colspan='3'><input name="submit" type="submit"
					class="btn btn-primary btn-sm"  value="登陆" /></td>
			</tr>
		  </table>
 
		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
 
		</form>
	  </div>
	</div>
</div>	
 
</body>

</html>
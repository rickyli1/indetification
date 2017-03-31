<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="req" value="${pageContext.request}" />
<c:set var="reqUrl" value="${req.requestURL}"/>
<c:set var="uri" value="${req.requestURI}"/>
<c:set var="uriLength" value="${fn:length(uri)}"/>

<c:set var="baseUrl" value='${fn:replace(reqUrl,uri,"")}/'/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <script type="text/javascript">
      alert("${msg}");
      window.location.href = "${baseUrl}"+"${url}";
    </script>
    
</head>
<body>

</body>
</html>
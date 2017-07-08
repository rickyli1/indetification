<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html> 
<head>
<title>request</title>
<link rel="stylesheet" href="/css/jquery/autocomplete.min.css">
<style type="text/css">
    .ui-autocomplete{
        display:block;
        z-index:99999;
        width: 200px;
    }
    
 .ui-widget {
	font-family: Arial,Helvetica,sans-serif;
	font-size: 1em;
}
.ui-widget .ui-widget {
	font-size: 1em;
}
.ui-widget input,
.ui-widget select,
.ui-widget textarea,
.ui-widget button {
	font-family: Arial,Helvetica,sans-serif;
	font-size: 1em;
}
.ui-widget.ui-widget-content {
	border: 1px solid #c5c5c5;
}
.ui-widget-content {
	border: 1px solid #dddddd;
	background: #ffffff;
	color: #333333;
}
.ui-widget-content a {
	color: #333333;
}
.ui-widget-header {
	border: 1px solid #dddddd;
	background: #e9e9e9;
	color: #333333;
	font-weight: bold;
}
.ui-widget-header a {
	color: #333333;
}
    
.ui-menu {
	list-style: none;
	padding: 0;
	margin: 0;
	display: block;
	outline: 0;
}
.ui-menu .ui-menu {
	position: absolute;
}
.ui-menu .ui-menu-item {
	margin: 0;
	cursor: pointer;
	/* support: IE10, see #8844 */
	list-style-image: url("data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7");
}
.ui-menu .ui-menu-item-wrapper {
	position: relative;
	padding: 3px 1em 3px .4em;
}
.ui-menu .ui-menu-divider {
	margin: 5px 0;
	height: 0;
	font-size: 0;
	line-height: 0;
	border-width: 1px 0 0 0;
}
.ui-menu .ui-state-focus,
.ui-menu .ui-state-active {
	margin: -1px;
}    
</style>
<c:import url="/WEB-INF/views/common/commonCss.jsp"></c:import>
</head>
<body>
 <div class="container	">
    <c:import url="/WEB-INF/views/common/navgate.jsp"></c:import>
	<div class="panel panel-primary">
	  <div class="panel-heading"><spring:message code="label.expert.add.title"/></div>
	  <div class="panel-body"> 
      <form class="form-horizontal" role="form">
             <fieldset>
                <div class="form-group">
                  <div class="col-md-1">
                  <button type="button" class="btn btn-primary btn-sm" id="saveExpertBtn"><spring:message code="label.expert.add.saveBtn"/></button>
                  </div> 
               </div>
            </fieldset>   
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="expertName"><spring:message code="label.expert.add.expertName"/></label>
                 <div class="col-md-2">                
                    <input class="form-control" id="expertName" type="text"/>
                 </div>  
                 <label class="col-md-1 control-label" for="profession"><spring:message code="label.expert.add.profession"/></label>
                 <div class="col-md-2">                
                    <input class="form-control" id="profession" type="text"/>
                 </div>
                 <label class="col-md-1 control-label" for="company" id="companyLable"><spring:message code="label.expert.add.companyLable"/></label>
                 <div class="col-md-2">                
                  <input type="text" class="form-control"  id="company"/>
					  <select  class="form-control" id="companySelect" style="display:none">
					  <c:forEach var="company" items="${companys}" varStatus="status">
						  <option value="${company.companyNo}">${company.companyName}</option>
					  </c:forEach>
					</select>
                 </div>    
                 <label class="col-md-1 control-label" for="professionalTitle"><spring:message code="label.expert.add.professionalTitle"/></label>
                 <div class="col-md-2">   
			        <input class="form-control" id="professionalTitle" type="text"/>
			     </div>
			  </div>
			  <div class="form-group">
                 <label class="col-md-1 control-label" for="remark"><spring:message code="label.expert.add.remark"/></label>
                 <div class="col-md-2">
			        <input class="form-control" id="remark" type="text"/>
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
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="/js/common/vendor/jquery.ui.widget.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/js/common/jquery/jquery.iframe-transport.js"></script>
<script src="/js/common/jquery/jquery.ui.js"></script> 
   <script type="text/javascript" src="/js/identification/expert/expertAdd.js" charset="UTF-8"></script>
   <script type="text/javascript">
   identification.expert = new Identification.expert.Add();
</script>
</html>
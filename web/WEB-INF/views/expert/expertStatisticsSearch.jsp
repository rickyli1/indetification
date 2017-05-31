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
	  <div class="panel-heading">专家评审统计</div>
		  <div class="panel-body"> 
		  
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="expertName">专家姓名</label>
                 <div class="col-md-2" style="width:180px;">
					 <input class="form-control" type="text" id="expertName" name="expertName">
                 </div>
                 
	            <div class="col-md-1" style="float:right;">
	            	<button id="searchBtn" class="btn btn-primary">查询</button>
	            </div>
	            
              </div>
           </fieldset>  		  

	       	<div id="expertStatisticsList">
	       	<c:import url="/WEB-INF/views/expert/expertStatisticsList.jsp" charEncoding="UTF-8"></c:import>  
	       	</div>
      	      
	      </div>
      </div>
      </div>
			
<!-- yangqi     -->
 <div id="searchCondition">
 	<input type="hidden" id="page" value="1"/>
 	<input type="hidden" id="expertNameHide" value=""/>
 </div>

		<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  

	    <script type="text/javascript" src="/js/identification/expert/expertStatisticsList.js" charset="UTF-8"></script>	    
	    <script type="text/javascript">
	    identification.expertStatisticsList = new Identification.expert.expertStatisticsList();

	    function goPage() {
	    	identification.expertStatisticsList.searchList();
		}
      </script>

	  </body>
</html>


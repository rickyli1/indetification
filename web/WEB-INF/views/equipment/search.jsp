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
	  <div class="panel-heading">装备信息检索</div>
		  <div class="panel-body"> 
		  
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                <label class="col-md-1 control-label" for="companyName">专业</label>
                 <div class="col-md-2" style="width:180px;">
                  <select  class="form-control" id="groupNo">
					 <option selected value=""></option>				
					  <c:forEach var="constant" items="${constants}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 <label class="col-md-1 control-label" for="companyName">专业类别</label>
                 <div class="col-md-2" style="width:180px;">
                   <select  class="form-control" id="subGroupNo">
					 <option selected value=""></option>				
					    <c:forEach var="constant" items="${constantsChild}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 <label class="col-md-1 control-label" for="equipmentName">设备名称</label>
                 <div class="col-md-2" style="width:180px;">               
					 <input class="form-control" type="text" id="equipmentName" name="equipmentName">
                 </div>
                 
                 <label class="col-md-1 control-label" for="expertNameCon">修别</label>
                 <div class="col-md-2" style="width:180px;">                
                     <select  class="form-control" id="repairLevel">
					 <option selected value=""></option>				
					    <c:forEach var="constant" items="${repairLevelList}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>                 
              </div>
           </fieldset>  		  


             <fieldset style="margin-top:10px">
             	<!-- 申请日期条件，客户说去掉，暂时隐藏 -->
                <div class="form-group" hidden>
                 <label class="col-md-1 control-label" for="applicationDate">申请日期</label>
                 <div class="col-md-2">
                    <span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="applicationDateFrom" data-link-format="yyyy-mm-dd">
                    <input class="form-control"  type="text" value="" >
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </span>
				    <input type="hidden" id="applicationDateFrom" value="" />
				 </div>
				 <div class="col-md-1">   
				    <span>~</span>
				  </div>
				  <div class="col-md-2"  style="margin-left:-53px">
	       		    <span class="input-group date form_date"  data-date="" data-date-format="yyyy-mm-dd" data-link-field="applicationDateTo" data-link-format="yyyy-mm-dd">
	                   	<input class="form-control" type="text" value="" />
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
	               	</span>
					<input type="hidden" id="applicationDateTo" value="" />     				     
                  </div>  
                 </div>
                 
	            <div class="col-md-1" style="float:right;">
	            	<button id="searchBtn" class="btn btn-primary">查询</button>
	            </div> 
	             <div class="col-md-1" style="float:right;">
	            	<button id="exportBtn" class="btn btn-primary">报告导出</button>
	            </div> 
            </fieldset>  		  
	       	<div id="equipmentResultList">
	       	<c:import url="/WEB-INF/views/equipment/list.jsp" charEncoding="UTF-8"></c:import>  
	       	</div>
      	      
	      </div>
      </div>
      </div>
			
<!-- yangqi     -->
 <div id="searchCondition">
 	<input type="hidden" id="page" value="30"/>
 	<input type="hidden" id="equipmentNameHide" value=""/>
 	<input type="hidden" id="groupNoHide" value=""/>
 	<input type="hidden" id="subGroupNoHide" value=""/>
 	<input type="hidden" id="repairLevelHide" value=""/>
 </div>		
   


      
		<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  

	    <script type="text/javascript" src="/js/identification/equipment/equipment.js" charset="UTF-8"></script>	    
	    <script type="text/javascript">
	    identification.equipment = new Identification.equipment.List();

	    function goPage() {
	    	identification.equipment.searchEquipmentList();
		}
      </script>

	  </body>
</html>


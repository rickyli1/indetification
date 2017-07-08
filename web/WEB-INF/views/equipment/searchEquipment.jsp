<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	  <div class="panel-heading"><spring:message code="lable.equipment.equipmentSearch"/></div>
		  <div class="panel-body"> 
		  
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                <label class="col-md-1 control-label" for="companyName"><spring:message code="lable.equipment.group"/></label>
                 <div class="col-md-2" style="width:180px;">
                  <select  class="form-control" id="groupNo">
					 <option selected value=""></option>				
					  <c:forEach var="constant" items="${constants}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 <label class="col-md-1 control-label" for="companyName"><spring:message code="lable.equipment.subGroup"/></label>
                 <div class="col-md-2" style="width:180px;">
                   <select  class="form-control" id="subGroupNo">
					 <option selected value=""></option>				
					    <c:forEach var="constant" items="${constantsChild}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 <label class="col-md-1 control-label" for="equipmentName"><spring:message code="lable.equipment.equipmentName"/></label>
                 <div class="col-md-2" style="width:180px;">               
					 <input class="form-control" type="text" id="equipmentName" name="equipmentName">
                 </div>
                 
              </div>
            </fieldset>  		  

            <fieldset style="margin-top:10px">
	            <div class="col-md-1" style="float:right;">
	            	<button id="searchBtn" class="btn btn-primary"><spring:message code="lable.equipment.equipmentFind"/></button>
	            </div> 
            </fieldset>  		  
	       	<div id="equipmentResultList">
	       		<c:import url="/WEB-INF/views/equipment/listEquipment.jsp" charEncoding="UTF-8"></c:import>  
	       	</div>
	       	
	      <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true">
	      	<div class="modal-dialog" style="width:900px">
	      		<form method="post">
	      			<div class="modal-content">
	      				<div class="modal-header">
	      					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        		<h4 class="modal-title" id="detailModalLabel"><spring:message code="lable.equipment.equipmentInfo"/></h4>
	      				</div>
					<c:import url="/WEB-INF/views/equipment/update.jsp" charEncoding="UTF-8"></c:import>
					</div>
				</form>
			</div>
		  </div>
	      <div class="modal-backdrop fade in" style="display:none" id="loading">
			<div class="loading"></div>  
		  </div>	
    
	      </div>
      </div>
      </div>

<div id="alertDiv"></div>			
<!-- yangqi     -->
 <div id="searchCondition">
 	<input type="hidden" id="page" value="1"/>
 	<input type="hidden" id="equipmentNameHide" value=""/>
 	<input type="hidden" id="groupNoHide" value=""/>
 	<input type="hidden" id="subGroupNoHide" value=""/>
 </div>	


	    <script type="text/javascript" src="/js/identification/equipment/equipmentAdd.js" charset="UTF-8"></script>	    
	    <script type="text/javascript" src="/js/identification/equipment/equipmentList.js" charset="UTF-8"></script>	    
	    <script type="text/javascript">
	    identification.equipmentList = new Identification.equipmentList.List();

	    function goPage() {
	    	identification.equipmentList.searchList();
		}
	    
	    function goDel(equipmentNo) {
	    	identification.equipmentList.goDel(equipmentNo);
		}
	    
	    function goEquipmentUpdate(equipmentNo) {
			//window.open("/equipment/updateInit/"+equipmentNo);
			identification.add = new Identification.equipment.Add();
	    	identification.add.goDetail(equipmentNo);
		}
      </script>

	  </body>
</html>


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
	  <div class="panel-heading">修改设备信息</div>
	  <div class="panel-body"> 
      <form class="form-horizontal" role="form"> 
           <fieldset>
              <legend> </legend>
              <div class="form-group">
              
                 <label class="col-md-1 control-label" for="equipmentName">设备名称</label>
                 <div class="col-md-2">                
                    <input class="form-control" id="equipmentName" type="text" value="${equipment.equipmentName}"/>
                	<input type="hidden" id="equipmentNo" type="text" value="${equipment.equipmentNo}"/>
                 </div>  
                 <label class="col-md-1 control-label" for="company">专业</label>
                 <div class="col-md-2">                
					<select  class="form-control" id="groupNo">
					  <c:forEach var="constant" items="${constants}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 
                 <label class="col-md-1 control-label" for="company">专业类别</label>
                 <div class="col-md-2">                
					<select  class="form-control" id="subGroupNo">
				      <c:forEach var="constant" items="${constantsChild}" varStatus="status">
						  <option value="${constant.constantNo}">${constant.constantName}</option>
					  </c:forEach>				
					</select>
                 </div>    
                 <label class="col-md-1 control-label" for="company">排序</label>
                 <div class="col-md-2">   
			             <input class="form-control" value ="" id="sort"  onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');"/>
			     </div>
			  </div>  
			  <div class="form-group">  
			     <label class="col-md-1 control-label" for="company">备注</label>
			 	   <div class="col-md-2">   
			            <input class="form-control" type="text" id="remark"/>
			      </div>          
              </div>
           </fieldset>
            <fieldset>
                <div class="form-group">
                  <div class="col-md-1">
                  <button type="button" class="btn btn-primary btn-sm" id="updateEquipmentBtn">保存信息</button>
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
<script type="text/javascript" src="/js/identification/equipment/equipmentAdd.js" charset="UTF-8"></script>
<script type="text/javascript">
   identification.equipmentAdd = new Identification.equipment.Add();
</script>
</html>
		
		

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
	  <div class="panel-heading">申请注册</div>
	  <div class="panel-body"> 
      <form class="form-horizontal" role="form">
             <fieldset>
                <div class="form-group">
                  <div class="col-md-10">
                  <button type="button" class="btn btn-primary btn-sm" id="addApplicationDetailBtn">添加详情</button>
                  <span style="color:blue; font-size:5px">*可多次添加</span>
                  </div>
                  <div class="col-md-1">
                  <button type="button" class="btn btn-primary btn-sm" id="saveApplicationBtn">保存申请</button>
                  </div>                  
               </div>  
            </fieldset>   
           <fieldset>
              <legend> </legend>
              <div class="form-group">
                 <label class="col-md-1 control-label" for="applicationDate">申请日期</label>
                 <div class="col-md-2">
                    <span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="applicationDate" data-link-format="yyyy-mm-dd">
                    <input class="form-control"  type="text" value="" >
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </span>
				     <input type="hidden" id="applicationDate" value="" />
                 </div>
                 <label class="col-md-1 control-label" for="company">申请单位</label>
                 <div class="col-md-3">                
					<select  class="form-control" id="company">
					 <option selected value=""></option>				
					  <c:forEach var="company" items="${companys}" varStatus="status">
						  <option value="${company.companyNo}">${company.companyName}</option>
					  </c:forEach>					 
					</select>
                 </div>
                 
                 <label class="col-md-1 control-label" for="department">代表机构</label>
                 <div class="col-md-3">                
                    <input class="form-control" id="department" type="text"/>
                 </div>                 
              </div>
           </fieldset>     
           <fieldset>             
               <div class="form-group">
                 <div class="col-md-*">
					<table class="table table-hover table-bordered" id="applicationDetailTable">
					      <thead>
					        <tr>
					          <th>设备</th>
					          <th>修理级别</th>
					          <th>专家</th>
					          <th>结果</th>
					          <th>整改标记</th>
					          <th>有效期期</th>
					          <th>备注</th>
					          <th>操作</th>
					        </tr>
					      </thead>
					      <tbody id="applicationDetailBody">
					      </tbody>
					    </table>
                 </div>             
               </div>
           </fieldset>
       </form>
	  </div>
	</div>
</div>	
<div id="alertDiv"></div>
</body>

<script id="detailTemplate" type="text/x-jquery-tmpl">
<tr id="tr{{= no}}">
	<td>
	<select  class="form-control" id="equipment{{= no}}">
        <option selected value=""></option>
        {{each equipments}} <option value="{{= $value.equipmentNo}}">{{= $value.equipmentName}}</option>{{/each}}
	</select>    
	<td>	
	<select  class="form-control" id="repairLevel{{= no}}">
         <option selected value=""></option>
        {{each repairLevels}} <option value="{{= $value.constantNo}}">{{= $value.constantName}}</option>{{/each}}
	</select>  
	
	</td>
	<td>
	<select  class="form-control" id="expert{{= no}}">
         <option selected value=""></option>
        {{each experts}} <option value="{{= $value.expertNo}}">{{= $value.expertName}}</option>{{/each}}
	</select>  
	</td>
	<td>
	<input type="radio" name="result{{= no}}" value="1">通过
	<input type="radio" name="result{{= no}}" value="0">不通过
	</td>								  
	<td>
	<input type="radio" name="isReform{{= no}}" value="1">整改
	<input type="radio" name="isReform{{= no}}" value="0">无整改
	</td>	
	<td>
	<span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="timeLimit{{= no}}" data-link-format="yyyy-mm-dd">
	<input class="form-control"  type="text" value="" >
	<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
	</span>
		<input type="hidden" id="timeLimit{{= no}}" value="" />
	</td>
    <td>
         <input type="text" value ="" id="remark{{= no}}"／>
    </td>		
    <td>
         <button type="button" class="btn btn-primary btn-sm deleteClass"  id="delete{{= no}}" data-no="{{= no}}">删除</button>
    </td>					  
</tr>
</script>
<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  
   <script type="text/javascript" src="/js/identification/application/applicationAdd.js" charset="UTF-8"></script>	    
   <script type="text/javascript">
   identification.application = new Identification.application.Add();
</script>
</html>
		
		

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
                 <label class="col-md-1 control-label" for="applicationDate">申请日期</label>
                 <div class="col-md-2">
                    <span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input class="form-control"  type="text" value="" >
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </span>
				     <input type="hidden" id="dtp_input2" value="" />
                 </div>
                 <label class="col-md-1 control-label" for="company">申请单位</label>
                 <div class="col-md-3">                
					<select  class="form-control">
					  <option>1</option>
					  <option>2</option>
					  <option>3</option>
					  <option>4</option>
					  <option>5</option>
					</select>
                 </div>
                 
                 <label class="col-md-1 control-label" for="department">代表机构</label>
                 <div class="col-md-3">                
                    <input class="form-control" id="department" type="text"/>
                 </div>                 
              </div>
           </fieldset>     
           <fieldset>
                <legend> </legend>
                <div class="form-group">
                  <div class="col-md-10">
                  <button type="button" class="btn btn-primary btn-sm" id="addApplicationDetailBtn">添加详情</button>
                  <span style="color:blue; font-size:5px">*可多次添加</span>
                  </div>
               </div>               
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
					        </tr>
					      </thead>
					      <tbody id="applicationDetailBody">
					        <tr>
					          <td><input class="form-control"  type="text" value="" ></td>
					          <td>					
					          <select  class="form-control">
								  <option>11111</option>
								  <option>2</option>
								  <option>3</option>
								  <option>4</option>
								  <option>5</option>
							  </select>
							  </td>
							  <td>
					          <select  class="form-control">
								  <option>wwwww</option>
								  <option>2</option>
								  <option>3</option>
								  <option>4</option>
								  <option>5</option>
							  </select>
							  </td>
							  <td>
								<input type="radio" name="11">是
								<input type="radio" name="11">否
							  </td>								  
							  <td>
								<input type="radio" name="11">是
								<input type="radio" name="11">否
							  </td>	
							  <td>
						  	    <span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
			                    <input class="form-control"  type="text" value="" >
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                    </span>
							     <input type="hidden" id="dtp_input2" value="" />
							  </td>						  
					        </tr>
					      </tbody>
					    </table>
                 </div>             
               </div>
           </fieldset>
       </form>
	  </div>
	</div>
</div>	
 <div id="hah"></div>
</body>
<script id="test" type="text/x-jquery-tmpl">

	<tr>
		<td>${Title}</td>
		<td>Languages:
			<em>
				{{each Languages}}
					{{= $value.Name}}
				{{/each}}
			</em>
		</td>
	</tr>
</script>
<script id="detailTemplate" type="text/x-jquery-tmpl">
<tr>
	<td><input class="form-control"  type="text" value="" ></td>
	<td>					
	<select  class="form-control repairLevelClass">
        {{each repairLevels}} <option value="{{= $value.constantNo}}">{{= $value.constantName}}</option>{{/each}}
	</select>
	</td>
	<td>
	<select  class="form-control expertsNoClass">
        {{each experts}} <option value="{{= $value.expertNo}}">{{= $value.expertName}}</option>{{/each}}
	</select>
	</td>
	<td>
	<input type="radio" name="1">通过
	<input type="radio" name="0">不通过
	</td>								  
	<td>
	<input type="radio" name="1">整改
	<input type="radio" name="0">无整改
	</td>	
	<td>
	<span class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
	<input class="form-control"  type="text" value="" >
	<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
	</span>
		<input type="hidden" id="dtp_input2" value="" />
	</td>						  
</tr>
</script>
<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  
   <script type="text/javascript" src="/js/identification/application/applicationAdd.js" charset="UTF-8"></script>	    
   <script type="text/javascript">
   identification.application = new Identification.application.Add();
</script>
</html>
		
		

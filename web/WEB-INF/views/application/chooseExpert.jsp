<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<div class="modal-body">   
<div class="container-fluid">
<div class="row">

<div class="col-md-* col-xs-* col-sm-*">
    <div class="row">
       <div class="col-xs-2 col-sm-2 col-md-2"> <label class="control-label" for="chooseExpertName" style="margin-top:8px;margin-left:13px">专家名</label></div>
      <div class="col-xs-8 col-sm-6 col-md-8">  <input type="text" class="form-control" id="chooseExpertName"/>  </div>
      <div class="col-xs-2 col-sm-2 col-md-2"> <button type="button" class="btn btn-primary btn-sm" id="searchExpertBtn" style="margin-left:38px">查询</button> </div>
    </div>
</div>

	
   
</div>
<div class="row">
  <div class="col-xs-12 col-sm-6 col-md-8">
      	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>	               
	                <th>姓名</th>
	                <th>专业</th>
	                <th>职称</th>
	                <th>单位</th>
	                <th>操作</th>
	              </tr>
	            </thead>
	            <tbody id="expertBody">
	            </tbody>
	         </table>
         </div> 
          <div class="text-center">
                <ul id="pagination-expert" class="pagination-sm pagination">
               </ul>
          </div>	          
  </div>
  <div class="col-xs-6  col-sm-6 col-md-4">
       	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th>评审专家</th>
	                <th>组长设置</th>	  
	                <th>操作</th>             
	              </tr>
	            </thead>
	            <tbody id="setExpertBody">
	            </tbody>
	         </table>
         </div> 
  </div>
</div>
</div> 
 </div>
			   		      
  <div class="modal-footer">
    <button type="button" id="saveExpertBtn" class="btn btn-primary btn-sm"  style="margin-right:28px">确定</button>
  </div>	 
<div><input type="hidden" id="page"/></div>
<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>   
<script type="text/javascript" src="/js/common/jquery/jquery.twbsPagination.min.js" charset="UTF-8"></script>    
<script type="text/javascript" src="/js/identification/application/chooseExpert.js" charset="UTF-8"></script>	    
<script type="text/javascript">
 identification.applicationChooseExpert = new Identification.application.ChooseExpert();
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
	<head> 
	    <meta charset="utf-8">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="/css/bootstrap/bootstrap-theme.min.css">
		<link rel="stylesheet" href="/css/bootstrap/docs.min.css">
		<link href="/css/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/css/common.css">
	</head>
	<body>
		<div class="container">
			<c:import url="/WEB-INF/views/common/navgate.jsp"></c:import>

			<h4 style="margin-top:-9px">申请信息管理>申请信息检索</h4>
			
			<div class="jumbotron" style="height:150px;">
				<table style="margin-top:-30px">
		     		<tr>
			     		<td>
			     	   		<table width="890px;">
		                   		<colgroup>
									<col style="width:130px">
									<col>
									<col style="width:130px">
									<col>
								</colgroup>				
					 			<tr>
<!--
									<th>申请编号</th> 
					   	  			<td><input type="text"  id="applicationNo" name="applicationNo"></td>
 -->
					   	  			<th>申请日期</th> 
					   	  			<td colspan="3" nowrap="nowrap"> 
										<div style="margin-top: 15px;">
								        	<table>
								            	<tr>
								               		<td>				                
								               	    	<span class="input-group date form_date col-md-3" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
								                    		<input class="form-control" style="min-width: 135px" size="16" type="text" value="" />
															<span class="input-group-addon">
																<span class="glyphicon glyphicon-calendar"></span>
															</span>
								                    	</span>
												     	<input type="hidden" id="dtp_input2" value="" />
													</td>
													
													<td width="30px"><span style="margin-left:-19px;font-size: 21px">~<span>
													</td>
													
							                    	<td>		                								
						                            	<span class="input-group date form_date col-md-3" style="margin-left:-21px;" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
									                    	<input class="form-control" size="16"  style="min-width: 135px" type="text" value="" />
															<span class="input-group-addon">
																<span class="glyphicon glyphicon-calendar"></span>
															</span>
									                	</span>
														<input type="hidden" id="dtp_input1" value="" />
								  					</td>
								            	</tr>
							            	</table>
										</div>
							    	</td>
		
					   			</tr>
					   
							    <tr>
									<th>单位名称</th> 
										<td><input type="text" id="companyName" name="companyName"></td>
									<th>设备名称</th> 
							   	  		<td><input type="text" id="equipmentName" name="equipmentName"></td>
							    </tr>
							    <tr>
							   	  	<th>专家姓名</th> 
							   	  		<td><input type="text" id="expertNameCon" name="expertName"></td>
							   	</tr>
							</table>
		     			</td>
		     	
						<td>
							<br><br><br>
		     				<button id="searchBtn" class="btn btn-default" style="margin-left:61px">查询</button>
		    			</td>
					</tr>
				</table>
			</div>
			
<!-- yangqi     -->
 <div id="searchCondition">
 	<input type="hidden" id="page" value="1"/>
 	<input type="hidden" id="companyNameHide" value=""/>
 	<input type="hidden" id="equipmentNameHide" value=""/>
 	<input type="hidden" id="expertNameConHide" value=""/>
 </div>		
   
	       	<div id="applicationResultList">
	       	<c:import url="/WEB-INF/views/application/list.jsp" charEncoding="UTF-8"></c:import>  
	       	</div>
       	</div> 

      
		<c:import url="/WEB-INF/views/common/commonScript.jsp"></c:import>  

	    <script type="text/javascript" src="/js/training/application/application.js" charset="UTF-8"></script>	    
	    <script type="text/javascript">
	    train.application = new Tarin.application.List();

	    function goPage() {
	    	train.application.searchList();
		}
      </script>

	  </body>
</html>


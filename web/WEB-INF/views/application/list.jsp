<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
   
      	 <div style="padding-top: 10px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th>No</th>
	                <th>单位名称</th>
	                <th>设备名称</th>
	                <th>修理等级</th>
	                <th>申请结果</th>
	                <th>有效期限</th>
	                <th>专家组</th>
	                <th>操作</th>
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="apply" items="${applicationResultList}" varStatus="status">
		               <tr>
		                <td>${status.count+(page-1)*pageSize}</td>
		                <td>${apply.companyName}</td>
		                <td>${apply.equipmentName}</td>
		                <td>${apply.repairLevel}</td>
		                <td>${apply.result}</td>
		                <td>${apply.timeLimit}</td>
		                <td>${apply.expertsName}</td>
		                <td>
							<button id="detailBtn" class="btn btn-primary" type="button" data-toggle="modal" data-target="#detailModal" onclick="goApplicationDetail('${apply.applicationNo}')">详情</button>
							<button id="modifyBtn" class="btn btn-primary btn-sm" type="button" data-toggle="modal" data-target="#detailModal" onclick="goApplicationUpdate('${apply.applicationNo}')">修改</button>
							<button id="delBtn" class="btn btn-primary" type="button" onclick="goApplicationDelete('${apply.reportNo}')">删除</button>
		                </td>
		              </tr>
	            	</c:forEach>
	            </tbody>
	         </table>
         </div>
		
          <div class="text-center">
                <ul id="pagination_appList" class="pagination-sm pagination">
               </ul>
          </div>
 <div id="listCondition">
 	<input type="hidden" id="applicationNoHidden" value=""/>
 </div>		
	
<script src="/js/common/jquery/jquery-1.11.1.min.js"></script>          
<script type="text/javascript" src="/js/common/jquery/jquery.twbsPagination.min.js" charset="UTF-8"></script>

<script type="text/javascript">

	// 跳转至详情页
	function goApplicationDetail(applicationNo) {
	    $("#applicationNoHidden").val(applicationNo);
	    identification.applicationDetail.goPage();
	}
	
	function goApplicationUpdate(applicationNo) {
		window.open("/application/updateInit/"+applicationNo);
	}
	
	function goApplicationDelete(reportNo) {
		identification.application.goDelete(reportNo);
	}
	
	$('#pagination_appList').twbsPagination({
	    totalPages: '${totalPage}',
	    startPage: '${page}',
	    visiblePages: 10,
	    onPageClick: function (event, page) {
	    	$("#page").val(page);
		    event.preventDefault();
	    	goPage(page);
	    }
	});
 </script>
      
      
      
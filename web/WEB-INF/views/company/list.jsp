<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
   
      	 <div style="padding-top: 10px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th>No</th>
	                <th>单位名称</th>
	                <th>单位代号</th>
	                <th>备注</th>
	                <th>操作</th>
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="company" items="${companyResultList}" varStatus="status">
		               <tr>
		                <td>${status.count+(page-1)*pageSize}</td>
		                <td>${company.companyName}</td>
		                <td>${company.companyCode}</td>
		                <td>${company.remark}</td>
		                <td>
		                	<button id="detailBtn" class="btn btn-primary" type="button" data-toggle="modal" data-target="#detailModal" onclick="goUpdate('${company.companyNo}')">修改</button>
							<button id="deleteBtn" class="btn btn-primary" type="button" onclick="goDelete('${company.companyNo}')">删除</button>
		                </td>
		              </tr>
	            	</c:forEach>
	            </tbody>
	         </table>
         </div>
		 <div id="alertDiv"></div>
          <div class="text-center">
                <ul id="pagination-demo" class="pagination-sm pagination">
               </ul>
          </div>		
<script src="/js/common/jquery/jquery-1.11.1.min.js"></script>          
<script type="text/javascript" src="/js/common/jquery/jquery.twbsPagination.min.js" charset="UTF-8"></script>

<script type="text/javascript">
	
	function goDelete(companyNo) {
    	identification.company.goDelete(companyNo);
	};
	
	function goUpdate(companyNo) {
		identification.companyUpdate.goDetail(companyNo);
	};
	
	if('${totalPage}' > 1){
		$('#pagination-demo').twbsPagination({
		    totalPages: ${totalPage},
		    startPage: ${page},
		    visiblePages: 30,
		    onPageClick: function (event, page) {
		    	$("#page").val(page);
			    event.preventDefault();
		    	goPage(page);
		    }
		});
	}
 </script>
      
      
      
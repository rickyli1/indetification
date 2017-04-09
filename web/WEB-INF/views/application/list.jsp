<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
   
      	 <div style="padding-top: 24px;">
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
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="apply" items="${applicationResultList}" varStatus="status">
		               <tr>
		                <td>${status.count+(page-1)*10}</td>
		                <td>${apply.companyName}</td>
		                <td>${apply.equipmentName}</td>
		                <td>${apply.repairLevel}</td>
		                <td>${apply.result}</td>
		                <td>${apply.timeLimit}</td>
		                <td>${apply.expertsName}</td>
		              </tr>
	            	</c:forEach>
	            </tbody>
	         </table>
         </div>
		
          <div class="text-center">
                <ul id="pagination-demo" class="pagination-sm pagination">
               </ul>
          </div>		
<script src="/js/common/jquery/jquery-1.11.1.min.js"></script>          
<script type="text/javascript" src="/js/common/jquery/jquery.twbsPagination.min.js" charset="UTF-8"></script>

<script type="text/javascript">
	
	$('#pagination-demo').twbsPagination({
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
      
      
      
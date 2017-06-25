<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
   
      	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th>No</th>
	                <th>专业</th>
	                <th>专业类别</th>
	                <th>设备型号及名称</th>
	                <th>修别</th>
	                <th>承修单位选择范围</th>
	                <th>有效期限</th>
	                <th>备注</th>
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="apply" items="${equipmentResultList}" varStatus="status">
		              
		                <c:choose>
							 <c:when  test="${!empty apply.remark}"> 
					             <c:forEach var="subappliy" items="${apply.exportList}" varStatus="status1">
				               		<tr>
				               		<c:choose>
									   <c:when  test="${status1.first== true }">  
										<td>${status.count+(page-1)*pageSize}</td>
						                <td>${apply.groupName}</td>
						                <td>${apply.subGroupName}</td>
						                <td>${apply.equipmentName}</td>
									   </c:when>
									   <c:otherwise> 
										<td></td>
						                <td></td>
						                <td></td>
						                <td></td>
									   </c:otherwise>
									</c:choose>
		
					                <td>${subappliy.repairName}</td>
					                <td>${subappliy.companyNames}</td>
					                <td>${subappliy.timeLimit}</td>
					                <td>${subappliy.remark}</td>
					                </tr>
				                </c:forEach>
							 </c:when>
							 <c:otherwise> 
								 <tr>
								 	<td>${status.count+(page-1)*10}</td>
					                <td>${apply.groupName}</td>
					                <td>${apply.subGroupName}</td>
					                <td>${apply.equipmentName}</td>
					                <td></td>
					                <td></td>
					                <td></td>
					                <td></td>
					             </tr>
						    </c:otherwise>   
						</c:choose>
					      
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
      
      
      
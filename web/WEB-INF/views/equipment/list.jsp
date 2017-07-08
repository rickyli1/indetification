<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
   
      	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th><spring:message code="lable.equipment.group"/></th>
	                <th><spring:message code="lable.equipment.subGroup"/></th>
	                <th><spring:message code="lable.equipment.equipmentName"/></th>
	                <th><spring:message code="lable.equipment.modifyCategory"/></th>
	                <th><spring:message code="lable.equipment.modifyCompany"/></th>
	                <th><spring:message code="lable.equipment.limit"/></th>
	                <th><spring:message code="lable.equipment.remarks"/></th>
	                
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
						                <td>${apply.groupName}</td>
						                <td>${apply.subGroupName}</td>
						                <td>${apply.equipmentName}</td>
									   </c:when>
									   <c:otherwise> 
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
      
      
      
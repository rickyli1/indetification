<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
      	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th>No</th>
	                <th><spring:message code="lable.equipment.group"/></th>
	                <th><spring:message code="lable.equipment.subGroup"/></th>
	                <th><spring:message code="lable.equipment.equipmentName"/></th>
	                <th><spring:message code="lable.equipment.remarks"/></th>
	                <th><spring:message code="lable.equipment.operate"/></th>
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="apply" items="${equipmentResultList}" varStatus="status">
		              
		                <c:choose>
							 <c:when  test="${!empty apply.applicationNo}"> 
					             <c:forEach var="subappliy" items="${apply.exportList}" varStatus="status1">
				               		<tr>
				               		<c:choose>
									   <c:when  test="${status1.first== true }">  
										<td>${status.count+(page-1)*pageSize}</td>
						                <td>${apply.groupName}</td>
						                <td>${apply.subGroupName}</td>
						                <td>${apply.equipmentName}</td>
						                 <td>
						                	<button id="detailBtn" class="btn btn-primary btn-sm" type="button" data-toggle="modal" data-target="#detailModal" onclick="goEquipmentUpdate('${apply.equipmentNo}')"><spring:message code="lable.equipment.equipmentUpdate"/></button>
						                	<button id="deleteBtn" class="btn btn-primary" type="button"   onclick="goDel'${apply.equipmentNo}')"><spring:message code="lable.equipment.equipmentDelete"/></button>
						                </td>
									   </c:when>
									</c:choose>
		
					                </tr>
				                </c:forEach>
							 </c:when>
							 <c:otherwise> 
								 <tr>
								 	<td>${status.count+(page-1)*10}</td>
					                <td>${apply.groupName}</td>
					                <td>${apply.subGroupName}</td>
					                <td>${apply.equipmentName}</td>
					                <td>${apply.remark}</td>
				                    <td>
					                    <button id="detailBtn" class="btn btn-primary" type="button" data-toggle="modal" data-target="#detailModal" onclick="goEquipmentUpdate('${apply.equipmentNo}')"><spring:message code="lable.equipment.equipmentUpdate"/></button>
					                    <button id="deleteBtn" class="btn btn-primary" type="button"  onclick="goDel('${apply.equipmentNo}')"><spring:message code="lable.equipment.equipmentDelete"/></button>
					                </td>
					             </tr>
						    </c:otherwise>   
						</c:choose>
					      
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
	
if('${totalPage}' > 1){
	$('#pagination-demo').twbsPagination({
	    totalPages: ${totalPage},
	    startPage: ${page},
	    visiblePages: 10,
	    onPageClick: function (event, page) {
	    	$("#page").val(page);
		    event.preventDefault();
	    	goPage(page);
	    }
	});
}
 </script>
      
      
      
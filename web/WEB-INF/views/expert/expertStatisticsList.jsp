<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th width=10%><spring:message code="label.expert.expertStatisticsList.expertName"/></th>
	                <th width=10%><spring:message code="label.expert.expertStatisticsList.profession"/></th>
	                <th width=15%><spring:message code="label.expert.expertStatisticsList.companyName"/></th>
	                <th width=10%><spring:message code="label.expert.expertStatisticsList.professionalTitle"/></th>
	                <th><spring:message code="label.expert.expertStatisticsList.company"/></th>
	                <th width=10%><spring:message code="label.expert.expertStatisticsList.equipment"/></th>
	                <th width=10%><spring:message code="label.expert.expertStatisticsList.level"/></th>
	                <th width=15%><spring:message code="label.expert.expertStatisticsList.role"/></th>
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="expert" items="${expertStatisticsList}" varStatus="status">
							<c:forEach var="subReport" items="${expert.reportList}" varStatus="status1">
					    	<tr>
					    		<c:choose>
									<c:when test="${status1.first == true}">  
								    	<td>${expert.expertName}</td>
								    	<td>${expert.profession}</td>
								    	<td>${expert.companyName}</td>
								    	<td>${expert.professionalTitle}</td>
									</c:when>
									<c:otherwise> 
								    	<td></td>
								    	<td></td>
								    	<td></td>
								    	<td></td>
									</c:otherwise>
								</c:choose>
								<td>${subReport.reportCompanyName}</td>
						    	<td>${subReport.equipmentName}</td>
						    	<td>${subReport.repairLevelName}</td>
						    	<td>${subReport.role}</td>
							</tr>
					    	</c:forEach>
	            	</c:forEach>
	            </tbody>
	         </table>
         </div>
		
          <div class="text-center">
                <ul id="pagination_expertStatic" class="pagination-sm pagination">
               </ul>
          </div>		
<script src="/js/common/jquery/jquery-1.11.1.min.js"></script>          
<script type="text/javascript" src="/js/common/jquery/jquery.twbsPagination.min.js" charset="UTF-8"></script>

<script type="text/javascript">
if('${totalPage}' > 1){	
	$('#pagination_expertStatic').twbsPagination({
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

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   
      	 <div style="padding-top: 10px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th width=3%>No</th>
	                <th><spring:message code="lable.application.list.company.name"/></th>
	                <th><spring:message code="lable.application.list.equipment.name"/></th>
	                <th><spring:message code="lable.application.list.repair.level"/></th>
	                <th><spring:message code="lable.application.list.application.result"/></th>
	                <th><spring:message code="lable.application.list.limit.date"/></th>
	                <th><spring:message code="lable.application.list.experts"/></th>
	                <th width=15%><spring:message code="lable.application.list.opertaion"/></th>
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
							<button id="detailBtn" class="btn btn-primary btn-sm" type="button" data-toggle="modal" data-target="#detailModal" onclick="goApplicationDetail('${apply.applicationNo}')"><spring:message code="button.application.list.detail"/></button>
							<button id="modifyBtn" class="btn btn-primary btn-sm" type="button" data-toggle="modal" onclick="goApplicationUpdate('${apply.applicationNo}')"><spring:message code="button.application.list.update"/></button>
							<button id="delBtn" class="btn btn-primary btn-sm" type="button" onclick="goApplicationDelete('${apply.applicationNo}','${apply.reportNo}')"><spring:message code="button.application.list.delete"/></button>
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
	
	function goApplicationDelete(applicationNo,reportNo) {
		identification.application.goDelete(applicationNo,reportNo);
	}
	
	if('${totalPage}' > 1){
		$('#pagination_appList').twbsPagination({
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
      
      
      
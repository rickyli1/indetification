<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
      	 <div style="padding-top: 10px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th><spring:message code="label.expert.list.No"/></th>
	                <th><spring:message code="label.expert.list.expertName"/></th>
	                <th><spring:message code="label.expert.list.profession"/></th>
	                <th><spring:message code="label.expert.list.companyName"/></th>
	                <th><spring:message code="label.expert.list.professionalTitle"/></th>
	                <th><spring:message code="label.expert.list.remark"/></th>
	                <th><spring:message code="label.expert.list.operate"/></th>
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="expert" items="${expertResultList}" varStatus="status">
		               <tr>
		                <td>${status.count+(page-1)*pageSize}</td>
		                <td>${expert.expertName}</td>
		                <td>${expert.profession}</td>
		                <td>${expert.companyName}</td>
		                <td>${expert.professionalTitle}</td>
		                <td>${expert.remark}</td>
		                <td>
		                <!-- 
							<button id="modifyBtn" class="btn btn-primary" type="button" data-toggle="modal" data-target="#detailModal" onclick="goDetail('${apply.applicationNo}')">修改</button>
						-->
							<button id="modifyBtn" class="btn btn-primary" type="button" data-toggle="modal" data-target="#modifyModal" onclick="goModify('${expert.expertNo}')"><spring:message code="label.expert.list.modifyBtn"/></button>
							<button id="delBtn" class="btn btn-primary" type="button" onclick="goDelete('${expert.expertNo}')"><spring:message code="label.expert.list.delBtn"/></button>
		                </td>
		              </tr>
	            	</c:forEach>
	            </tbody>
	         </table>
         </div>
		
          <div class="text-center">
                <ul id="pagination-demo" class="pagination-sm pagination">
               </ul>
          </div>
 
 <div id="listCondition">
 	<input type="hidden" id="expertNoHidden" value=""/>
 </div>

<script src="/js/common/jquery/jquery-1.11.1.min.js"></script>          
<script type="text/javascript" src="/js/common/jquery/jquery.twbsPagination.min.js" charset="UTF-8"></script>

<script type="text/javascript">

	// 跳转至详情页
	function goModify(expertNo) {
//	    $("#expertNoHidden").val(expertNo);
	    identification.expertModify.goPage(expertNo);
	}
	function goDelete(expertNo) {
		identification.expert.goDelete(expertNo);
	};
	
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
      
      
      
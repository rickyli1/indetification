<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
   
      	 <div style="padding-top: 24px;">
	         <table class="table table-bordered table-striped">
	            <thead>
	              <tr>
	                <th width="10px"><input type="checkbox" id="chkAll"></th>
	                <th>No</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>Username</th>
	              </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="user" items="${adminUserList}" varStatus="status">
		               <tr>
		                <td><input type="checkbox" class="chk"></td>
		                <td>1</td>
		                <td>${user.userName}</td>
		                <td>Otto</td>
		                <td>@mdo</td>
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
	    totalPages: '${totalCount}',
	    visiblePages: 10,
	    onPageClick: function (event, page) {
	    	$("#page").val(page);
		    event.preventDefault();
	    	goPage(page);
	    }
	});
 </script>
      
      
      
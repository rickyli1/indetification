<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-inverse" role="navigation">
   <div class="container">
     <div id="navbar" class="navbar-collapse collapse">
       <ul class="nav navbar-nav">
         <!--<li class="active">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">User <span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
             <li><a href="#">User</a></li>
             <li><a href="/adminUser/list">设备管理</a></li>
           </ul>		            
         </li>-->
         <li><a href="#/base"><spring:message code="lable.base"/></a></li>
         <li><a href="#/application"><spring:message code="lable.application"/></a></li>
         <li><a href="#/equipment"><spring:message code="lable.equipment"/></a></li>
         <li><a href="#/expert"><spring:message code="lable.expert"/></a></li>
         <li><a href="#/company"><spring:message code="lable.company"/></a></li>
       </ul>
     </div><!--/.nav-collapse -->
   </div>
</nav>
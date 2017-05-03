<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>

			.navbar-default {
			  background-color: #2063E8;
			  border-color: #1337a3;
			}
			.navbar-default .navbar-brand {
			  color: #f3f5f9;
			}
			.navbar-default .navbar-brand:hover,
			.navbar-default .navbar-brand:focus {
			  color: #d6dbee;
			}
			.navbar-default .navbar-text {
			  color: #f3f5f9;
			}
			.navbar-default .navbar-nav > li > a {
			  color: #f3f5f9;
			}
			.navbar-default .navbar-nav > li > a:hover,
			.navbar-default .navbar-nav > li > a:focus {
			  color: #d6dbee;
			}
						.navbar-default .navbar-nav > li > .dropdown-menu {
			  background-color: #3c5fe7;
			}
			.navbar-default .navbar-nav > li > .dropdown-menu > li > a {
			  color: #f3f5f9;
			}
			.navbar-default .navbar-nav > li > .dropdown-menu > li > a:hover,
			.navbar-default .navbar-nav > li > .dropdown-menu > li > a:focus {
			  color: #d6dbee;
			  background-color: #1337a3;
			}
			.navbar-default .navbar-nav > li > .dropdown-menu > li > .divider {
			  background-color: #3c5fe7;
			}
			.navbar-default .navbar-nav .open .dropdown-menu > .active > a,
			.navbar-default .navbar-nav .open .dropdown-menu > .active > a:hover,
			.navbar-default .navbar-nav .open .dropdown-menu > .active > a:focus {
			  color: #d6dbee;
			  background-color: #1337a3;
			}
						.navbar-default .navbar-nav > .active > a,
			.navbar-default .navbar-nav > .active > a:hover,
			.navbar-default .navbar-nav > .active > a:focus {
			  color: #d6dbee;
			  background-color: #1337a3;
			}
			.navbar-default .navbar-nav > .open > a,
			.navbar-default .navbar-nav > .open > a:hover,
			.navbar-default .navbar-nav > .open > a:focus {
			  color: #d6dbee;
			  background-color: #1337a3;
			}
			.navbar-default .navbar-toggle {
			  border-color: #1337a3;
			}
			.navbar-default .navbar-toggle:hover,
			.navbar-default .navbar-toggle:focus {
			  background-color: #1337a3;
			}
			.navbar-default .navbar-toggle .icon-bar {
			  background-color: #f3f5f9;
			}
			.navbar-default .navbar-collapse,
			.navbar-default .navbar-form {
			  border-color: #f3f5f9;
			}
			.navbar-default .navbar-link {
			  color: #f3f5f9;
			}
			.navbar-default .navbar-link:hover {
			  color: #d6dbee;
			}
			@media (max-width: 767px) {
			  .navbar-default .navbar-nav .open .dropdown-menu > li > a {
			    color: #f3f5f9;
			  }
			  .navbar-default .navbar-nav .open .dropdown-menu > li > a:hover,
			  .navbar-default .navbar-nav .open .dropdown-menu > li > a:focus {
			    color: #d6dbee;
			  }
			  .navbar-default .navbar-nav .open .dropdown-menu > .active > a,
			  .navbar-default .navbar-nav .open .dropdown-menu > .active > a:hover,
			  .navbar-default .navbar-nav .open .dropdown-menu > .active > a:focus {
			    color: #d6dbee;
			    background-color: #1337a3;
			  }
			
</style>
<!--<div><img alt="" src="/images/ban2.jpg" style="width:100%;height:100%"></div> -->
<nav class="navbar navbar-default" role="navigation">
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
        
         <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.base"/> <span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
              <li><a href="/upload/init"><spring:message code="lable.upload"/></a></li>
           </ul>
         </li>         
         
         <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.application.search"/> <span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
             <li><a href="/application/init"><spring:message code="lable.application.search"/></a></li>
             <li><a href="/application/addInit"><spring:message code="lable.application.add"/></a></li>
           </ul>
         </li>
         <li>  <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.equipment.search"/> <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
             <li><a href="/equipment/init"><spring:message code="lable.equipment.search"/></a></li>
             <li><a href="/equipment/addInit"><spring:message code="lable.equipment.add"/></a></li>
           </ul>
         </li>
         <li><a href="#/expert"><spring:message code="lable.expert"/></a></li>
         <li><a href="#/company"><spring:message code="lable.company"/></a></li>
        
       </ul>
     </div><!--/.nav-collapse -->
   </div>
</nav>
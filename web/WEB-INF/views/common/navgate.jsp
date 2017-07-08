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
<div><img alt="" src="/images/ban2.jpg" style="width:100%;height:50%"></div>
<nav class="navbar navbar-default" role="navigation">
   <div class="container">
     <div id="navbar" class="navbar-collapse collapse">
       <ul class="nav navbar-nav">
         <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.application.search"/> <span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
             <li><a href="/application/init"><spring:message code="lable.application.search"/></a></li>
             <li><a href="/application/addInit"><spring:message code="lable.application.add"/></a></li>
           </ul>
         </li>
         <li>  <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.equipment.search"/> <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
              <li><a href="/equipment/initEquipment"><spring:message code="lable.equipment.search"/></a></li>
             <li><a href="/equipment/addInit"><spring:message code="lable.equipment.add"/></a></li>
           </ul>
         </li>
         <li>  <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.company"/> <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
             <li><a href="/company/init"><spring:message code="lable.company.search"/></a></li>
             <li><a href="/company/addInit"><spring:message code="lable.company.add"/></a></li>
           </ul>
         </li>
		<li><a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.expert"/><span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
             <li><a href="/expert/init"><spring:message code="lable.expert.search"/></a></li>
             <li><a href="/expert/addInit"><spring:message code="lable.expert.add"/></a></li>
           </ul>
		</li>
		
		<li><a href=" " class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.constant"/> <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
             <li><a href="/constant/init"><spring:message code="lable.constant.search"/></a></li>
             <li><a href="/constant/addInit"><spring:message code="lable.constant.add"/></a></li>
           </ul>
         </li>
        
         <li>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><spring:message code="lable.statistics"/> <span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
                <li><a href="/equipment/init"><spring:message code="lable.equipment.statistics"/></a></li>
                <li><a href="/statistics/init"><spring:message code="lable.expert.statistics"/></a></li>
           </ul>
         </li>             
        
       </ul>
        <a href="/j_spring_security_logout" role="button" class="btn btn-primary btn-sm navbar-right" style="margin-top:6px;margin-right:50px">退出</a>      
        <ul class="nav navbar-nav navbar-right">
           <li>  
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">       
                <span class="glyphicon glyphicon-cog navbar-right" style="color: #F5F5DC; margin-right:10px" aria-hidden="true">
                </span>
                </a>
                <ul class="dropdown-menu" role="menu">
                <li><a href="/upload/init"><spring:message code="lable.upload"/></a></li>
                </ul>
         </li>
    </ul>
     </div><!--/.nav-collapse -->
   </div>
</nav>
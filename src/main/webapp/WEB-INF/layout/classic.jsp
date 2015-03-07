<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="../layout/taglib.jsp"%>

<!DOCTYPE html>

<html>
<head>


<link rel="stylesheet" href="<spring:url value='/resources/custom.css'/> ">


<!--Bootstrap For offline -->

<link rel="stylesheet" href="<spring:url value='/resources/css/bootstrap.min.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<spring:url value='/resources/css/bootstrap-theme.min.css'/>" />
    <link rel="stylesheet" href="<spring:url value='/resources/css/font-awesome.min.css'/>" />
    <script src="<spring:url value='/resources/js/jquery-2.1.1.min.js'/>"></script>
    <script src="<spring:url value='/resources/js/bootstrap.min.js'/>"></script>
    <script src="<spring:url value='/resources/js/bootstrap-datepicker.js'/>"></script>

<!--Bootstrap For offline -->


<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="http://eternicode.github.io/bootstrap-datepicker/bootstrap-datepicker/css/datepicker3.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/json2/20140204/json2.js"></script>
<script type="text/javascript" src="http://eternicode.github.io/bootstrap-datepicker/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="current"/>

<div class="container">
 <nav class="nav navbar-inverse  navbar-fixed-top" style="background-color:#2f4f4f" role="navigation" id="mainnav">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        <a class="navbar-brand" href="<spring:url value="/" />">Online Test Platform</a>
      </div>
       <div class="navbar-collapse collapse">
       <div class=" col-sm-3 navbar-right">
        <form action="http://www.google.com/search" method="get" class="navbar-form" role="search">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
             <div class="input-group-btn">
              <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
             </div>
          </div>
        </form>
       </div>
       <div class="btn-group navbar-btn navbar-right"style="width:200px;"> 
       <security:authorize access="! isAuthenticated()">            
          <a href="<spring:url value="/login.html" />" type="button" class="btn btn-success">Log in</a>
          </security:authorize>
          <security:authorize access="! isAuthenticated()">
          <a href="<spring:url value="/register.html" />" type="button" class="btn btn-primary"> Sign Up</a>
          </security:authorize>
        </div>  
      <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
              <security:authorize access="hasRole('ROLE_ADMIN')">
              	<li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users.html" />">Users</a></li>
              </security:authorize>
              <security:authorize access="hasRole('ROLE_TEACHER')">
              	<li class="${current == 'createcourse' ? 'active' : ''}"><a href="<spring:url value="/createcourse.html" />">Create Course</a></li>
                  <li class="${current == 'teacherDashboard' ? 'active' : ''}"><a href="<spring:url value="/teacherDashboard.html" />">Teacher Dashboard </a></li>
              </security:authorize>
              <security:authorize access="hasRole('ROLE_STUDENT')">
                  <li class="${current == 'studentDashboard' ? 'active' : ''}"><a href="<spring:url value="/studentDashboard.html" />">Student Dashboard</a></li>
              </security:authorize>
              <security:authorize access="isAuthenticated()">
              	<li><a href="<spring:url value="/logout" />">Logout</a></li>
              </security:authorize>
            </ul>
          </div><!--/.navbar-collapse -->
          </div>
   </nav>
 </div> 
 

<!--bannar-->
<div class="container" style="margin-top:15px;">
	<section>	
	</section>
</div>  
	<br>
	<br>
<tiles:insertAttribute name="body" />
	
</body>

<tiles:insertAttribute name="footer" />

</html>
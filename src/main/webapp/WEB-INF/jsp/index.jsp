<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<h1>${request.id}</h1>
<section style="margin-top:100px;">
   <div class="col-lg-10 col-lg-offset-1 ">
	<div class="panel panel-default">
  <div class="panel-body">
   <div class="row">
  <div class="col-lg-6">
     <form action="http://www.google.com/search" method="get" role="search">  
      <input type="text" class="form-control" placeholder="search by chatagory,course name,University or instroctor">
     </form>  
  </div><!-- /.col-lg-6 -->
  
</div><!--end-row-->

<h3>Courses</h3><hr>
<c:forEach  items="${course }" var="course">
<div class="col-xs-12">
		
		   <div class="row fluid">             		  			   
			  <img src="<c:url value='/resources/images/database.jpg'/>" alt="" class="col-xs-3" role="presentation">
			  <div class="col-xs-6">
				<p> ${course.user.uvname} </p>
				<a href='<spring:url value="aboutcourse/${course.id}.html"></spring:url>'><b>${course.title }</b></a>
				<p><em>with<a href="#">${course.user.name}</a></em></p>
				<p>Starting from ${course.startDate} </p>
			  </div>	
			  <div class="col-xs-3">			   	
			     <a href="aboutcourse/${course.id}.html" class="btn btn-success pull-right">Learn More</a><br><br>
			     <security:authorize>
			     <a href='<spring:url value="/joinrequest/${course.id}.html"></spring:url>' class="btn btn-primary pull-right">Join</a>
                 </security:authorize>
              </div>			  		
			</div>
			<hr>

	</div>
</c:forEach>
	
</div><!--end-panel-body-->
</div><!--end-panel-->
</div>

</section>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<section style="margin-top:100px;">
   <div class="col-lg-10 col-lg-offset-1 ">
	<div class="panel panel-default">
  <div class="panel-body">
   <div class="row">
  <div class="col-lg-6">
     <form action="http://www.google.com/search" method="get" role="search">  
      <input type="text" class="form-control" placeholder="search by chatagory,course name,University or instroctor">
     </form>  
  </div><!-- /.col-lg-6 -->
  
</div><!--end-row-->
<hr>
	<div class="col-xs-2">	  
		<form>
		   <div class="form-group">
		   <label for=""class=" control-label">short by</label>
			<select>
				<option>Starting soon</option>
				<option>2</option>
				<option>3</option>
			</select>
		  <div class="checkbox">
                   <label>
                     <input type="checkbox"><a href="#">Engneering</a>
			<div class="checkbox">
                   <label>
                     <input type="checkbox"><a href="#">CSE</a>
                   </label><br>
                   <label>
                     <input type="checkbox"><a href="#">softwer</a>
                   </label><br>
                   <label>
                     <input type="checkbox"><a href="#">EEE</a>
                   </label><br>
                </div> 
                </label>
               </div>              
		   </div>
		</form>
	</div>
  	
	<div class="col-xs-10">
       <blockquote>
		<h3>Courses</h3><hr>
		<div class="row-fluid">             		  			   
			  <img src="<c:url value='/resources/images/database.jpg'/>" alt="" role="presentation">			   	
			  <button class="btn btn-success pull-right">Learn More</button>				
			  <div style="float:right;margin-right:300px;" >
				<a href="#">Deffodil International University </a><br>
				<a href="#"><b>Database</b></a><br>
				<p><em>with<a href="#"> S. Akhter Hossain</a></em></p>
			  </div>			
			</div>
			<hr>
			<div class="row-fluid">             		  			   
			  <img src="<c:url value='/resources/images/database.jpg'/>" alt="" role="presentation">			   	
			  <button class="btn btn-success pull-right">Learn More</button>				
			  <div style="float:right;margin-right:300px;" >
				<a href="#">Deffodil International University </a><br>
				<a href="#"><b>Networking</b></a><br>
				<p><em>with<a href="#"> Narayan</a></em></p>
			  </div>			
			</div><hr>
			<div class="row-fluid">             		  			   
			  <img src="<c:url value='/resources/images/database.jpg'/>" alt="" role="presentation">			   	
			  <button class="btn btn-success pull-right">Learn More</button>				
			  <div style="float:right;margin-right:300px;" >
				<a href="#">Deffodil International University </a><br>
				<a href="#"><b>java</b></a><br>
				<p><em>with<a href="#"> S. Akhter Hossain</a></em></p>
			  </div>			
			</div><hr>
			<div class="row-fluid">    
			  <img src="<c:url value='/resources/images/database.jpg'/>" alt="" role="presentation">			   	
			  <button class="btn btn-success pull-right">Learn More</button>				
			  <div style="float:right;margin-right:300px;" >
				<a href="#">Deffodil International University </a><br>
				<a href="#"><b>PhP</b></a><br>
				<p><em>with<a href="#"> Jabed Morshed</a></em></p> 
			   </div>
			</div>
       </blockquote>  
	</div>
</div><!--end-panel-body-->
</div><!--end-panel-->
</div>
</section> --%>
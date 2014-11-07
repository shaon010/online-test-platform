<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="container" style="padding-top:100px;"> 
  <div class="row"> 
    
    <div class="col-lg-2" id="profile">
       <a class="" href="#">     
       <img class="col-lg-12" src="<c:url value='/resources/images/man.jpg'/>" alt="..."> 
       </a>       
       <div class="">
          <h4 class="">ttt</h4>
          <p>Daffodil International University<br>Dept. of CSE<br>Senior Lecturer</p>          
       </div>       
    </div>
    
    <div class="col-lg-10">
      
        <div class="pull-right">
           <a href="Createcourse.html" class="btn btn-default " style="">
             <span class="glyphicon glyphicon-plus"></span>New Course
           </a>
        </div><br><br>        
        <div class="panel panel-default" id="your-course">
          <div class="panel-heading">
            <h4>Your courses</h4>
          </div>
          <div class="panel-body">       
             <div class="row">
               <div class="col-md-2">
                  <a href="Tcourse-page.html" class="thumbnail">
                    <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                      <div class="caption" style="margin-top:-25px;">
                         <h3>Database</h3>                         
                      </div>
                  </a>
                </div>
                <div class="col-md-2">
                   <a href="Tcourse-page.html" class="thumbnail">
                     <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                       <div class="caption" style="margin-top:-25px;">
                          <h3>Java</h3>                           
                        </div>
                      </a>
                    </div>
                    <div class="col-md-2">
                      <a href="Tcourse-page.html" class="thumbnail">
                        <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                        <div class="caption" style="margin-top:-25px;">
                           <h3>Network</h3>                           
                        </div>
                      </a>
                    </div>
                </div>
                  <a href="course.html" class="pull-right">View More..</a>
            </div>
        </div><!--end your course panel--> 

        <div class="panel panel-default" id="Other-uv">
          <div class="panel-heading">
            <h4>Similar courses from other university</h4>
          </div><hr>
          <div class="panel-body">       
             <div class="row">
               <div class="col-md-2">
                  <div class="thumbnail">
                    <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                      <div class="caption" style="margin-top:-25px;">
                         <h3>Database</h3>
                         <p><small>S.Akhter Hossain<br>DIU<br>Depart.Head CSE</small></p>        
                        <a href="#" class="btn btn-primary" role="button">Join</a> 
                      </div>
                  </div>
                </div>
                <div class="col-md-2">
                   <div class="thumbnail">
                      <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                       <div class="caption" style="margin-top:-25px;">
                          <h3>Java</h3> 
                          <p><small>S.Akhter Hossain<br>DIU<br>Depart.Head CSE</small></p>       
                          <a href="#" class="btn btn-primary" role="button">Join</a> 
                        </div>
                      </div>
                    </div>
                    <div class="col-md-2">
                      <div class="thumbnail">
                        <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                        <div class="caption" style="margin-top:-25px;">
                           <h3>Network</h3>
                           <p><small>S.Akhter Hossain<br>DIU<br>Depart.Head CSE</small></p>      
                            <a href="#" class="btn btn-primary" role="button">Join</a> 
                        </div>
                      </div>
                    </div>
                </div>
                  <a href="course.html" class="pull-right">View More..</a>
            </div>
        </div><!--end-Similar courses from other university-panel-->            
    </div>         
  
  </div>
</div>
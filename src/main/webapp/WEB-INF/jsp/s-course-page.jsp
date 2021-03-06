<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="container" style="height:500px;">
	<section style="margin-top:100px;">
		<div class="container">
     <div class="row">
      <div class="col-lg-4">
       <img src="<c:url value='/resources/images/database.jpg'/>" alt="...">
          <div class="caption">
          <h3>${course.title}</h3>
          <p><small>${course.user.name}<br>${course.user.uvname}<br>${course.user.position}</small></p>
          <a href="#" class="btn btn-primary" role="button">Leave</a>
        </div>
      </div> 
      <div class="col-lg-8">
         <ul class="nav nav-tabs">
           <li class="active"><a href="#list" data-toggle="tab">Quizs</a></li>
           <li><a href="#show" data-toggle="tab">Announcement</a></li>
          </ul><br>
        <div class="tab-content">
         <div class="tab-pane fade in active" id="list">
          <table class="table table-striped">
          <tr>
          <!--  <th>No</th> -->
           <th>Quiz name</th>
           <th>Start Date</th>
           <th>Valid Date</th> 
           <th>Marks</th>
          </tr> 
          <c:if test="${quizes!=null && quizes.size()!=0}">
          <c:forEach items="${quizes}" var="quiz">
          <tr>
            <!-- <td>1</td> -->
              <c:if test="${results.size()!=0}">
              <c:if test="${completedQuizIdList.contains(quiz.id)}">
                  <c:forEach items="${results}" var="result">
                      <c:if test="${result.quiz.id==quiz.id}">
                 <td>${quiz.title}</td>
                  <td>${quiz.startDate}</td>
                  <td>${quiz.endDate}</td>
                  <td >${result.obtainedMarks}</td>
                      </c:if>
                  </c:forEach>
              </c:if>
              <c:if test="${completedQuizIdList.contains(quiz.id)==false}">
                  <td><a href="<spring:url value="/quiz/attend/${quiz.id}.html" />" >${quiz.title}</a></td>
                  <td>${quiz.startDate}</td>
                  <td>${quiz.endDate}</td>
                  <td >N/A</td>
              </c:if>
              </c:if>
              <c:if test="${results.size()==0}">
                  <td><a href="<spring:url value="/quiz/attend/${quiz.id}.html" />" >${quiz.title}</a></td>
                  <td>${quiz.startDate}</td>
                  <td>${quiz.endDate}</td>
                  <td >N/A</td>
              </c:if>
          </tr>
          </c:forEach>
          </c:if>  
          </table><!--end table-->
          
           <div class="modal fade bs-example-modal-md" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                     <div class="modal-dialog modal-md">
                       <div class="modal-content">
                         <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                           <h4 class="modal-title" id="myModalLabel">Are You Sure ?</h4>
                         </div>
                         <div class="modal-body">
                          <div class="rules">
                            <ul>
                              <li>Be honest at exam</li>
                              <li>Do not copy from others</li>
                              <li>Exam time is limited</li>
                              <li>Be careful about your net connection</li>
                              <li>Better, use a laptop for cont. electricity</li>
                            </ul>
                          </div>
                         
                          <div class="" Style="margin-left:200px;">
                           <button type="button" class="btn btn-success" data-dismiss="modal">Go for Exam</button>
                           <button type="button" class="btn btn-danger">Cancel</button>
                          </div>
                         </div> 
                       </div>
                     </div>
             </div><!--end modal-->
            
         </div><!--end list-->
         <div class="tab-pane fade active" id="show">
           <h3>Date:01-01-2015</h3>
           <p>New course file uploaded</p><hr>
           <h3>Date:01-01-2015</h3>
           <p>Next exam will be on Saturday</p><hr>
         </div><!--end show-->        
        </div>
      </div> 
     </div>
    </div>
    </section>

</div>  
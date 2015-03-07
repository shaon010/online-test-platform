<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	
	
	
	
	
	<!-- THIS IS COURSE MANAGEMENT PAGE with 4 TAB -->
	
	

	

<%@ include file="../layout/taglib.jsp"%>
<div class="container" style="margin-top:100px;" id="main-container">
    <div class="row">
      
     <div class="col-lg-2">
      <img src="<c:url value='/resources/images/database.jpg'/>" alt="...">
      <h1>${course.title}</h1>
      <a class="btn btn-danger" href="<spring:url value="/course/delete/${course.id}.html"/>">Delete</a>
     </div>






<div class="col-lg-10">
       <ul class="nav nav-tabs">
          <li class="active"><a href="#section-1" data-toggle="tab">Announcement</a></li>          
          <li ><a href="#section-2" data-toggle="tab">Create new quiz </a></li>
          <li ><a href="#section-3" data-toggle="tab">Quiz Management</a></li>
          <li ><a href="#section-4" data-toggle="tab">Student List</a></li>
          <li><a href="#section-5" data-toggle="tab">Student Request</a></li>          
        </ul><br><!--end-pills-->
      
      <div class="tab-content">
        <div id="section-1" class="tab-pane fade in active" style="height:500px;">
         <div class= "row">
          <div class="col-lg-5">
           <textarea class="form-control" rows="3"> </textarea>
           <div class="form-group">
             <label for="exampleInputFile">File input</label>
             <input type="file" id="exampleInputFile1">
           </div>
           <a href="#" class="btn btn-default">Upload</a>
          </div>
         </div>
       </div><!--end-section-1-->
       
       
       
       
       
      <!-- CREATE QUIZ TAB --> 
       
       
       <div id="section-2" class="tab-pane fade active">          
        <div class="panel panel-default " style="border-color:black;">
            <div class="panel-heading">
               <h2>Create new quiz</h2>
            </div>
            <div class="panel-body">
             <div class="row">  
            <form:form commandName="quiz" id="quizform" class="form-horizontal" method="post">
                    <div class="col-lg-6">
                          <div class="form-group">             
                            <label for="Title"class="col-lg-1 control-label">Title</label>
                               <div class="col-lg-11">
                                 <form:input type="text" path="title" class=" form-control" placeholder="Quiz Title" />  
                                </div>                                
                          </div>
                          <div class="form-group ">             
                            <label for="1st"class="col-lg-1 control-label">Date</label>
                               <div class="col-lg-5">
                                 <form:input path="startDate" type="text" class="form-control date-picker"  placeholder="yyyy/mm/dd" />
                                </div>
                            <label for="2st"class="col-lg-1 control-label">To</label>
                               <div class="col-lg-5">
                                 <form:input type="text" path="endDate" class=" form-control date-picker" placeholder="yyyy/mm/dd"/>
                                </div> 
                          </div>                     
                      
                      
                     </div><!--end-name-date-->  
                     
                     <div class="col-lg-6 ">
                     
                          <div class="form-group"> 
                            <label for="time"class="col-lg-6 control-label">Exam Time Duration</label>
                               <div class="col-lg-6 ">
                                 <form:select class="form-control" path="duration">
                                   <option value="5">5 minute</option>
                                   <option value="10">10 minute</option>
                                   <option value="15">15 minute</option>
                                   <option value="20">20 minute</option>
                                   <option value="30">30 minute</option>
                                 </form:select>  
                                </div>
                          </div>
                          <div class="form-group"> 
                            <label for="time"class="col-lg-6 control-label">Each Question point</label>
                               <div class="col-lg-6 ">
                                 <form:select class="form-control" path="point">
                                   <option value="1">1</option>
                                   <option value="2">2</option>
                                   <option value="3">3</option>
                                   <option value="4">4</option>
                                   <option value="5">5</option>
                                   <option value="6">6</option>
                                 </form:select>  
                                </div>
                          </div>
                          </div>
                       </form:form>
                     </div><!--time-point-->          
                <hr>
              
                    <div class="row">
							<div class="col-lg-5">
								<h3>Multiple choose</h3>
								<p>Write your Question:</p>
								<form:form class="form-horizontal" commandName="mcq" method="post" id="mcqform" >

									<div class="form-group" style="padding-left: 20px;">
										<form:textarea path="question"  class="form-control"
											rows="3"/>
									</div>

									 <div class="form-group" style="padding-left:20px;">
                          <label for="exampleInputFile">File input</label>
                          <form:input path="imagepath" type="file" />                          
                       </div> 

									<label class="checkbox " style="padding-left: 20px;"> <form:checkbox
											path="checkbox1" id="inlineCheckbox1" value="1"/>  <form:input
											path="choice1" id="choice1" type="text" class="col-lg-8" />
									</label>
									<br>

									<label class="checkbox" style="padding-left: 20px;"> <form:checkbox
											path="checkbox2" id="inlineCheckbox2" value="2"/>  <form:input
											path="choice2" id="choice2" type="text" class="col-lg-8" />
									</label>
									<br>

									<label class="checkbox" style="padding-left: 20px;"> <form:checkbox
											path="checkbox3" id="inlineCheckbox1" value="3" />  <form:input
											path="choice3" id="choice3" type="text" class="col-lg-8" />
									</label>
									<br>

									<label class="checkbox" style="padding-left: 20px;"> <form:checkbox
											path="checkbox4" id="inlineCheckbox1" value="4"/> <form:input
											path="choice4" id="choice4" type="text" class="col-lg-8" />
									</label>
									<br>
									<label class="checkbox" style="padding-left: 20px;"> <form:checkbox
											path="checkbox5" id="inlineCheckbox1" value="5"/>  <form:input
											path="choice5" id="choice5" type="text" class="col-lg-8" />
									</label>
									<br>
									<p class="help-block">Identify the correct answers
										checkbox</p>
									<div class="btn group">
										<a  class="btn btn-default" onclick="makeAjaxCallmcq();"><span
											class="glyphicon glyphicon-plus"></span> Add</a> 
									</div>

								</form:form><hr>
                    
                      <h3>True False</h3>
                      <form:form commandName="tf"  class="form-horizontal" id="tfform" method="post">
                       <p>Write your Question:</p>
                       <form:textarea class="form-control" rows="3" path="question"/>
                        <div class="form-group" style="padding-left: 20px;">
                          <label for="exampleInputFile">File input</label>
                          <input type="file" id="exampleInputFile">                          
                       </div>
                       
                       <div class="radio-inline">
                         <label>
                           <form:radiobutton path="tfOption" value="true" checked="true"/>
                            True 
                         </label>
                     </div>
                     <div class="radio-inline">
                         <label>
                           <form:radiobutton  path="tfOption" value="false" />
                            False
                         </label>
                     </div> 
                     <p class="help-block">Mention the correct answer</p> 
                     <div class="btn group">
                        <a class="btn btn-default" onclick="makeAjaxCalltf();"><span class="glyphicon glyphicon-plus"></span> Add</a>
                      </div> 
                      </form:form> 
                     </div><!--end-left-col-->  
                       
                       
                       
                                       
                    <div class="col-lg-7" style="padding-left: 150px;">
                      <h3>Short Question</h3>
                        <form:form commandName="sq" id="sqform" method="post">
                      
                       <p>Write your Question:</p>
                       <form:textarea path="question" class="form-control" rows="3"></form:textarea>
                       
                         <div class="form-group">
                            <label for="ans" class="">Correct Answer:</label>
                            <form:input type="text" path="answer" class="form-control"/>
                            <p class="help-block">Short question will not be pointed automatically.You may give answer for your refference!</p> 
                          
                         </div>
                       
                       <div class="btn group">
                        <a  class="btn btn-default" onclick="makeAjaxCallsq();"><span class="glyphicon glyphicon-plus"></span> Add</a>
                       </div> 
                       </form:form>
                       <br>
                       <br>
                       <br>
                       <br>
                       <br>
                       <br>
                       <br>
                       <br>
                      <div class="alert center-text"  id="alert">
                      </div>
                      
                    </div><!--end-right-col--> 
       </div>
       
      			 <div class="container text-center"> 
                  <a href='<spring:url value="/clearsession/${course.id}.html"/>' class="btn btn-danger ">Cancel</a>
                  <a href='<spring:url value="/preview.html"/>' onclick="submitQuizForm();" class="btn btn-default ">Preview</a>
                </div>
       </div>
       </div>
       </div>





       <!-- CREATE QUIZ TAB END -->
       
       
       
       
       
       
       
       <div id="section-4" class="tab-pane fade active ">
         <div class="panel panel-default">
           <div class="panel-heading text-center">
             <h2> Student list</h2>
           </div><!--end panel-heading-->
           <c:if test="${courseStudent.size()!=0}">
               <c:forEach items="${courseStudent}" var="student">
           <div class="panel-body" id="student-list">
             <ul class="media-list" >
                <li class="media col-lg-11">
                   <a class="pull-left" href="#">
                    <img class="media-object col-sm-7" src="<c:url value='/resources/images/student.png'/>" alt="...">
                   </a>
                  <div class="media-body">
                    <h4 class="media-heading">${student.user.name}</h4>
                    <p>${student.user.name}<br>{Id:}</p>
                  </div>
                </li>
                <a class="btn btn-default col-lg-1" onclick='removeStudent("<spring:url value="/course/removeStudent/${course.id}/${student.user.id}.html"/>")'>Remove</a>  <hr>
             </ul>
           </div><!--end panel-body-->
            </c:forEach>
           </c:if>
         </div><!--end-panel-->
       </div><!--end-section-4-->
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       <div id="section-5" class="tab-pane fade active ">
         <div class="panel panel-default">
           <div class="panel-heading text-center">
             <h2>Student Request</h2>
           </div><!--end panel-heading-->
           <c:forEach items="${request}" var="request">
           <div class="panel-body">
             <ul class="media-list">
                <li class="media col-lg-9">
                   <a class="pull-left" href="#">
                    <img class="media-object col-sm-7" src="<c:url value='/resources/images/student.png'/>" alt="...">
                   </a>
                  <div class="media-body ">
                    <h2 class="media-heading">${request.user.name}</h2>
                    <p>${request.user.uvname}<br>Dept. of CSE<br>ID:111-15-1350</p>         
                  </div>                  
                </li>
                
                <div class="col-lg-3 inline">
                    <form action='<spring:url value="/acceptCourseRequest/${request.course.id}.html" />' >
                        <input type="hidden" value="${request.user.id}" name="studentId">
                       <button type="submit" class="btn btn-success btn-md">Accept</button>
                       <a href="#" class="btn btn-danger btn-md">Reject</a>
                    </form>
                  </div><hr>
             </ul>
           </div><!--end panel-body-->
           </c:forEach>
         </div><!--end-panel-->
       </div><!--end-section-5-->
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        <div class="tab-pane fade active" id="section-3" style="height:500px;">
          <table class="table table-striped" id="manage-table">
          <tr>
           <th>Quiz Title</th>
           <th>Action</th>
           <th>Start Date</th>
           <th>Valid Date</th> 
           <th>Report</th>
          </tr>
              <c:if test="${courseQuiz.size()!=0}">
                  <c:forEach items="${courseQuiz}" var="quiz">
          <tr>
            <td>${quiz.title}</td>
            <td><button class="btn-danger delete-quiz" href="#" onclick='deletequiz("<spring:url value="/quiz/delete/${course.id}/${quiz.id}.html"/>")' ><i class="fa fa-trash-o fa-fw"></i></button></td>
            <td>${quiz.startDate}</td>
            <td>${quiz.endDate}</td>
            <td>N/A</td>
          </tr>
                  </c:forEach>
              </c:if>
        </table>
        </div><!--end-section-3-->
      </div><!--end-tab-content-->        
     </div><!--end-col-lg-10-->      
     </div>
     </div>
     






<script>
	function makeAjaxCallmcq() {
		$.ajax({
			type : "post",
			url : "<spring:url value="/savemcq.html"/>",
			cache : false,
			data : $('#mcqform').serialize(),
			 success : function(response) {
			    // var obj = JSON.parse(response);
			     $("#alert").text("Mcq question added successfully");
			     $("#alert").addClass("alert-success");
			    },
			
			 error : function() {
				
				 alert('Error while request..'); 
			} 
		});
	}
    function deletequiz(url) {
		$.ajax({
			type : "get",
			url : url,
			cache : false,
			 success : function(response) {
			    console.log("deleted");
                 $("#manage-table").html($(response).find("#manage-table"));
			    },

			 error : function() {

				 alert('Error while request..');
			}
		});
	}
    function removeStudent(url) {
		$.ajax({
			type : "get",
			url : url,
			cache : false,
			 success : function(response) {
			    console.log("deleted");
                 $("#student-list").html($(response).find("#student-list"));
			    },

			 error : function() {

				 alert('Error while request..');
			}
		});
	}

	function makeAjaxCalltf() {
		$.ajax({
			type : "post",
			url : "<spring:url value="/savetf.html"/>",
			cache : false,
			data : $('#tfform').serialize(),
			 success : function(response) {
			    // var obj = JSON.parse(response);
			     $("#alert").text("True False question added successfully");
			     $("#alert").addClass("alert-success");
			    },
			
			 error : function() {
				
				 alert('Error while request..'); 
			} 
		});
	}
	
	function makeAjaxCallsq() {
		$.ajax({
			type : "post",
			url : "<spring:url value="/savesq.html"/>",
			cache : false,
			data : $('#sqform').serialize(),
			 success : function(response) {
			    // var obj = JSON.parse(response);
			     $("#alert").text("Short question added successfully");
			     $("#alert").addClass("alert-success");
			    },
			
			 error : function() {
				
				 alert('Error while request..'); 
			} 
		});
	}
	function submitQuizForm(e) {
       // e.preventDefault();
		$.ajax({
			type : "post",
			url : "<spring:url value="/storequiz/${course.id}.html"/>",
			cache : false,
			data : $('#quizform').serialize(),
			 success : function(response) {
			    },
			 error : function() {
				/*  alert('Error while request..'); */ 
			} 
		});
	}
    $('.date-picker').datepicker({
        todayBtn: "linked",
        autoclose: true,
        format: 'yyyy/mm/dd',
        todayHighlight: true
    });

</script>
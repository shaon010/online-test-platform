<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="container" style="margin-top:100px;">
	<div class="panel panel-default">
    <div class="panel-heading text-center">
       <h4>Create new course</h4>
    </div><br>
    <div class="panel body">
      <form:form commandName="course" class="form-horizontal" role="Create course">
        <div class="form-group"> 
          <label for="name"class="col-lg-3 control-label">Enter Course Title:</label>
          <div class="col-lg-6">
            <form:input path="title" class=" form-control" placeholder="Course title"/>  
          </div>
        </div><br><!--end course-name-->
       <!--  <div class="form-group"> 
          <label for="picture"class="col-lg-3 control-label">Add A Picture:</label>
          <div class="col-lg-6">
            <div class="row">
              <div class=" col-lg-4" >
                <div class="panel panel-default" style="height:150px;" >
                  <div class="panel-body">
                    <img src="" class="col-lg-12">
                  </div>
                </div>
              </div>
            </div>    --> 
            <center>
            <div class="form-group">
              <label for="exampleInputFile">Add A Picture:</label>
              <input type="file" id="exampleInputFile">                          
            </div> </center>
          <!-- </div>
        </div> --><br><!--end picture-->
         <div class="form-group ">             
                            <label for="1st"class="col-lg-3 control-label">Start Date</label>
                               <div class="col-lg-3">
                                 <form:input type="date" path="startDate" class=" form-control" placeholder="mm/dd/yyyy"/>  
                                </div>
                            
                          </div> 
                          
        <div class="form-group">
          <label for="2st"class="col-lg-3 control-label">End Date</label>
                               <div class="col-lg-3">
                                 <form:input type="date" path="endDate" class=" form-control" placeholder="mm/dd/yyyy"/>  
                                </div> 
        </div><br><!--end about course-->
        <div class="form-group">
          <label for=""class="col-lg-3 control-label">Write About Course:</label>
          <div class="col-lg-6">
          <form:textarea path="description" class="form-control" rows="3"/>
          </div>
        </div><br><!--end about course-->
       <br>
        <div class="form-group"> 
          <label for="name"class="col-lg-3 control-label">FAQ1</label>
          <div class="col-lg-6">
            <form:input path="faq1" class=" form-control" placeholder="FAQ1"/>  
          </div>
        </div><br>
        <div class="form-group">
          <label for=""class="col-lg-3 control-label">FAQ1 Answer</label>
          <div class="col-lg-6">
          <form:textarea path="faq1ans" class="form-control" rows="3"/>
          </div>
        </div><br>
        <div class="form-group"> 
          <label for="name"class="col-lg-3 control-label">FAQ2</label>
          <div class="col-lg-6">
            <form:input path="faq2" class=" form-control" placeholder="FAQ2"/>  
          </div>
        </div><br>
        <div class="form-group">
          <label for=""class="col-lg-3 control-label">FAQ2 Answer</label>
          <div class="col-lg-6">
          <form:textarea path="faq2ans" class="form-control" rows="3"/>
          </div>
        </div><br>
        <div class="form-group"> 
          <label for="name"class="col-lg-3 control-label">FAQ3</label>
          <div class="col-lg-6">
            <form:input path="faq3" class=" form-control" placeholder="FAQ3"/>  
          </div>
        </div><br>
        <div class="form-group">
          <label for=""class="col-lg-3 control-label">FAQ3 Answer</label>
          <div class="col-lg-6">
          <form:textarea path="faq3ans" class="form-control" rows="3"/>
          </div>
        </div><br>
        <div class="form-group"> 
          <label for="name"class="col-lg-3 control-label">FAQ4</label>
          <div class="col-lg-6">
            <form:input path="faq4" class=" form-control" placeholder="FAQ4"/>  
          </div>
        </div><br>
        <div class="form-group">
          <label for=""class="col-lg-3 control-label">FAQ4 Answer</label>
          <div class="col-lg-6">
          <form:textarea path="faq4ans" class="form-control" rows="3"/>
          </div>
        </div><br>
         <div class="form-group"> 
          <label for="name"class="col-lg-3 control-label">FAQ5</label>
          <div class="col-lg-6">
            <form:input path="faq5" class=" form-control" placeholder="FAQ5"/>  
          </div>
        </div><br>
        <div class="form-group">
          <label for=""class="col-lg-3 control-label">FAQ5 Answer</label>
          <div class="col-lg-6">
          <form:textarea path="faq5ans" class="form-control" rows="3"/>
          </div>
        </div>
        <div class="text-center"><input type="submit" value="Save" class="btn btn-lg btn-primary" /></div><br>
      </form:form>
    </div>
  </div><!--end panel-->
</div>
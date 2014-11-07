<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<h1><c:out value="${user.name}" /></h1>

   <div class="container">
   	 <div class="col-lg-offset-1 col-lg-10">
        <div class="panel panel-default">
        	<div class="panel-heading">About me</div><br>
        	<div class="body">
        	  <div class="row">
        	  	<div class="col-lg-4">
        	  	   <img src="man.jpg" class="col-lg-10">
        	  	   <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    Edit</button>
                   <!-- Modal -->
                   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                     <div class="modal-dialog modal-lg">
                       <div class="modal-content">
                         <div class="modal-header">
                           <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                           <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                         </div>
                         <div class="modal-body">
                           <div class="form-group">
                             <label for="Pic"class="col-sm-4 control-label">Change profile picture:</label>
                             <div class="col-sm-5">
                               <label for="exampleInputFile"></label>
                               <input type="file" id="exampleInputFile">
                             </div>                          
                           </div><br><br>
                           <div class="form-group"> 
                            <label for="Phone"class="col-sm-4 control-label">Phone No :</label>
                            <div class="col-sm-5">
                             <input type="text" id="Phone" class=" form-control"placeholder="">  
                            </div>                        
                           </div><br><br>
                           <div class="form-group"> 
                             <label for="address"class="col-sm-4 control-label">Address :</label>
                             <div class="col-sm-5">
                               <textarea class="form-control" rows="2"> </textarea> 
                             </div>                        
                           </div><br><br><hr>
                           <div class="form-group"> 
                              <label for="dep"class="col-sm-4 control-label">Department :</label>
                              <div class="col-sm-5">
                                <select class="form-control" id="dep">
                                  <option>select</option>
                                  <option>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                </select>    
                              </div>                        
                           </div><br><br>
                           <div class="form-group"> 
                              <label for="sec"class="col-sm-4 control-label">Position :</label>
                              <div class="col-sm-5">
                                <input type="text" id="Phone" class=" form-control"placeholder="">  
                              </div>                        
                           </div><br><br>
                           <div class="form-group"> 
                              <label for="id"class="col-sm-4 control-label">Teacher ID:</label>
                              <div class="col-sm-5">
                                <input type="text" id="id" class=" form-control"placeholder="">  
                              </div>                        
                           </div><br><br>
                           <div class="form-group"> 
                             <label for="about"class="col-sm-4 control-label">About Yourself :</label>
                             <div class="col-sm-5">
                               <textarea class="form-control" rows="3"> </textarea> 
                             </div>                        
                           </div><br><br>
                         </div>
                         <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          <button type="button" class="btn btn-primary">Save changes</button>
                         </div>
                       </div>
                      </div>
                   </div><!--end modal-->          
      

        	  	</div><!--end left col-->
        	  	<div class="col-lg-8">
        	  		<div class="label-group">
        	  			<label class="col-lg-4">Name:</label>
        	  			<label class="col-lg-8" style="margin-left:-100px;">Raju</label>
        	  		</div>
        	  		<div class="label-group">
        	  			<label class="col-lg-4">Institutes:</label>
        	  			<label class="col-lg-8" style="margin-left:-100px;">Daffodil International University</label>
        	  		</div>
        	  		<div class="label-group">
        	  			<label class="col-lg-4">Email:</label>
        	  			<label class="col-lg-8" style="margin-left:-100px;">name@gmail.com</label>
        	  		</div>
        	  	</div><!--end right col-->
        	  </div><br><br><!--end row-->	
        	</div>
        </div><!--end panel-->  	 	
   	 </div><!--end offset-->
   	     	   	 
   </div><!--end container-->
 
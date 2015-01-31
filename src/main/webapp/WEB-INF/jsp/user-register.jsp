<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="container text-center" style="margin-top: 100px;">
	<div class="row">
		<div class="col-lg-offset-2 col-lg-8">
			<div class="panel panel-heading " style="border-color: black">
				<div class="panel-tittle">
					<h1>Sign up Form</h1>
				</div>
				<hr>
				<div class="panel-body">

					<form:form commandName="user" cssClass="form-horizontal registrationForm">
						<c:if test="${param.success eq true}">
							<div class="alert alert-success">Registration successful!</div>
						</c:if>
											
						 <div class="form-group">
							<label for="roles" class="col-sm-4 control-label">Sign up as</label>
							<div class="col-sm-5">
								<select class="form-control" name="role" id="role" required>
									<option>-- select --</option>
									<option value="1">Student</option>
									<option value="2">Teacher</option>
                     			</select>
                     
							</div>
						</div>  
						<div class="form-group">
							<label for="name" class="col-sm-4 control-label">Enter
								Your Name</label>
							<div class="col-sm-5">
								<form:input path="name" class=" form-control"
									placeholder="Full name" />
								<form:errors path="name" />
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="username" class="col-sm-4 control-label">Enter
								Your User Name </label>
							<div class="col-sm-5">
								<form:input path="username" class=" form-control"
									placeholder="username" />
								<form:errors path="username" />

							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="Email" class="col-sm-4 control-label">Enter
								Your Email</label>
							<div class="col-sm-5">
								<form:input path="email" class=" form-control"
									placeholder="Email Address" />
								<form:errors path="email" />

							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="uvname" class="col-sm-4 control-label">Institute
								Name</label>
							<div class="col-sm-5">
								<form:select class="form-control" path="uvname" required="true">
									<option><-- select --></option>
									<option value="1">DIU</option>
									<option value="2">DU</option>
									<option value="3">AIUB</option>
									<option value="4">BUET</option>
                     </form:select>
                     
							</div>
						</div>
						<br>
						<%--  <div class="form-group"> 
        	     <label for="Position"class="col-sm-4 control-label">Position</label>
   				   <div class="col-sm-5">
   				   <form:input path="position" class=" form-control" placeholder="Position"/>	
   				   	</div>
   				</div><br>  --%>
						<div class="form-group">
							<label for="pass" class="col-sm-4 control-label">Enter
								Your Password</label>
							<div class="col-sm-5">
								<form:input type="password" class="form-control" path="password"
									placeholder="password" />
								<form:errors path="password" />
							</div>
						</div>
						<br>
						<div class="form-group">
							<label for="re-pass" class="col-sm-4 control-label">Re-enter
								Your Password</label>
							<div class="col-sm-5">
								<input type="password" name="password_again" id="password_again"
									class="form-control" />
							</div>
						</div>
						<input type="submit" value="Save" class="btn btn-lg btn-primary" />
					</form:form>
					<!--end-form-->

				</div>
				<!--end-panel-body-->
			</div>
		</div>
		<!--end-panel-->
	</div>
	<!--end-row-->
</div>
<!--end-container-->

<%-- <form:form commandName="user" cssClass="form-horizontal registrationForm">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successful!</div>
	</c:if>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="username" cssClass="form-control" />
			<form:errors path="username" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" />
			<form:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password again:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form> --%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".registrationForm")
								.validate(
										{
											rules : {
												name : {
													required : true,
													minlength : 3,
													remote : {
														url : "<spring:url value='/register/available.html' />",
														type : "get",
														data : {
															username : function() {
																return $(
																		"#username")
																		.val();
															}
														}
													}
												},
												email : {
													required : true,
													email : true
												},
												password : {
													required : true,
													minlength : 5
												},
												password_again : {
													required : true,
													minlength : 5,
													equalTo : "#password"
												}
											},
											highlight : function(element) {
												$(element).closest(
														'.form-group')
														.removeClass(
																'has-success')
														.addClass('has-error');
											},
											unhighlight : function(element) {
												$(element)
														.closest('.form-group')
														.removeClass(
																'has-error')
														.addClass('has-success');
											},
											messages : {
												username : {
													remote : "Such username already exists!"
												}
											}
										});
					});
</script>
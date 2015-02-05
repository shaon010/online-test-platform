<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<%-- 

<form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check" />" method="POST">
	<h2 class="form-signin-heading">Please sign in</h2>
	<input type="text" name="j_username" class="form-control" placeholder="Name" required autofocus> 
	<input type="password" name="j_password" class="form-control" placeholder="Password" required> 
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form> --%>


<div class="container text-center" style="margin-top: 100px;">
	<div class="row">
		<div class="col-lg-offset-2 col-lg-8">
			<div class="panel panel-defult " style="border-color: black">
				<div class="panel-heading"style:"">
					<h2 class="form-signin-heading">Please sign in</h2>
				</div>
				<hr>
				<div class="panel-body">
					<form class="form-horizontal" role="log in form"
						action="<spring:url value="/j_spring_security_check" />"
						method="POST">
					<!-- 	<div class="form-group">
							<label for="as" class="col-lg-4 col-sm-4 control-label">Log
								In As</label>
							<div class="col-lg-5 col-sm-5">
								<select class="form-control" id="as">
									<option>Student</option>
									<option>Teacher</option>
								</select>
							</div>
						</div>
						<br> -->
						<div class="form-group">
							<label for="name" class="col-sm-4 control-label">User Name</label>
							<div class="col-sm-5">
								<input type="text" name="j_username" class="form-control"
									placeholder="Name" required autofocus>

							</div>
						</div>
						
						<div class="form-group">
							<label for="pass" class="col-sm-4 control-label">Password</label>
							<div class="col-sm-5">
								<input type="password" name="j_password" class="form-control"
									placeholder="Password" required>
							</div>
						</div>

                        
						<div class="checkbox" >
							<input type="checkbox"
								name='_spring_security_remember_me' checked="checked" style="float: none;">
								Remember me | <a href="#">Forget your password?</a>
							
						</div>
						<br>
						<button type="Submit" class="btn btn-success">Log In</button>
					</form>
				</div>

			</div>

		</div>
	</div>
	<!--end-row-->
</div>
<!--end-container-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>${request.id}</h1>
<div class="container" style="margin-top: 100px;">

	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-5">
					<img src="<c:url value='/resources/images/database.jpg'/>"
						alt="cover piv" class="col-lg-12">
				</div>
				<div class="col-lg-7"></div>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-8">
					<h2>About the course</h2>
					<p>${course.description}</p>

					<section>
						<div class="FQA-head">
							<h2>FAQ</h2>
						</div>
						<div class="panel-group" id="qa">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h5 class="panel-tittle">
										<a href="#qa-1" data-toggle="collapse" data-parent="#qa">${course.faq1}</a>
									</h5>
								</div>
								<div class="panel-collapse collapse in" id="qa-1">
									<div class="panel-body">${course.faq1ans}</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h5 class="panel-tittle">
										<a href="#qa-2" data-toggle="collapse" data-parent="#qa">${course.faq2}
											2</a>
									</h5>
								</div>
								<div class="panel-collapse collapse" id="qa-2">
									<div class="panel-body">${course.faq2ans}</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h5 class="panel-tittle">
										<a href="#qa-3" data-toggle="collapse" data-parent="#qa">${course.faq3}</a>
									</h5>
								</div>
								<div class="panel-collapse collapse" id="qa-3">
									<div class="panel-body">${course.faq3ans}</div>
								</div>
							</div>
						</div>
					</section>
				</div>

				<div class="col-lg-4">
					<!-- <h3>Session</h3>
					<select class="form-control">
						<option>select</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select> --><br>			     
					<c:if test="${request.id==null}">
					 <a href='<spring:url value="/joinrequest/${course.id}.html"></spring:url>' class="btn btn-primary pull-right">Join</a>
					</c:if>
				</div> 
			</div>
		</div>
		<!--end panel-body-->
	</div>
	<!--end panel-->
</div>
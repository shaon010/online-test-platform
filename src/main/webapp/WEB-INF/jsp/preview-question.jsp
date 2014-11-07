<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-offset-2 col-lg-10">
				<div class="panel panel-defult " style="border-color: black;">
					<div class="body">
						<div class="Text-center">
						<c:if test="${quiz!=null}">
							<center>
								<h2>Title: ${quiz.title}</h2>
								<br>
								<h4>Each question point: ${quiz.point}</h4>
								<br>
								<h4>Exam duration: ${quiz.duration} minute</h4>
								<hr>
							</center>
							</c:if>
						</div>
						<div class="row">
							<div class="col-lg-8" style="padding-left: 30px;">
								<c:if test="${mcq!=null}">
									<h2>MCQ</h2>
									<c:forEach items="${mcq}" var="mcq">
										<h4>
											${mcq.question}<a href="#" class="btn">[Edit]</a> <a href="#"
												class="btn">[Delete]</a>
										</h4>
										<p class="help-block">The first letter may be R</p>

										<div style="padding-left: 20px;">
											<label class="checkbox "> <input type="checkbox"
												id="inlineCheckbox1" value="option1">${mcq.choice1}
											</label> <label class="checkbox "> <input type="checkbox"
												id="inlineCheckbox1" value="option1">${mcq.choice2}
											</label><label class="checkbox "> <input type="checkbox"
												id="inlineCheckbox1" value="option1">${mcq.choice3}
											</label> <label class="checkbox "> <input type="checkbox"
												id="inlineCheckbox1" value="option1">${mcq.choice4}
											</label> <label class="checkbox"> <input type="checkbox"
												id="inlineCheckbox1" value="option1">${mcq.choice5}
											</label>
										</div>
										<br>
									</c:forEach>
								</c:if>
								<c:if test="${tf!=null}">
									<br>
									<br>
									<h2>True False</h2>
									<c:forEach items="${tf}" var="tf">
										<h4>${tf.question}
											<a href="#" class="btn">[Edit]</a> <a href="#" class="btn">[Delete]</a>
										</h4>
										<p class="help-block">The first letter may be R</p>
										<br>
										<div class="radio-inline">
											<label> <input type="radio" name="optionsRadios"
												id="optionsRadios1"> True
											</label>
										</div>
										<div class="radio-inline">
											<label> <input type="radio" name="optionsRadios"
												id="optionsRadios1"> False
											</label>
										</div>
										<br>

									</c:forEach>

								</c:if>

								<c:if test="${sq!=null}">
									<br>
									<br>
									<h2>Short Questions</h2>
									<c:forEach items="${sq}" var="sq">
										<h4>
											${sq.question} <a href="#" class="btn">[Edit]</a> <a href="#"
												class="btn">[Delete]</a>
										</h4>
										<p class="help-block">The first letter may be R</p>

										<textarea class="form-control" rows="3"> </textarea>
										<br>
									</c:forEach>
								</c:if>
							</div>
						</div>
						<!--end row-->
						<div class="text-center">
							<a
								href='<spring:url value="/saveQuizQuestion.html"></spring:url>'
								class="btn btn-success">Finish</a> <a
								href="<spring:url value="/clearsession.html"></spring:url>"
								class="btn btn-danger">Cancel</a>
						</div>
						<br> <br>
					</div>
					<!--end body-->
				</div>
				<!--end panel-->
			</div>
			<!--end offset-->
		</div>
		<
		<!--end main row-->
	</div>
	<!--end container-->

</body>
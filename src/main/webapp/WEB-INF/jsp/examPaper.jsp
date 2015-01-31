<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-offset-2 col-lg-10">
				<div class="panel panel-defult " style="border-color: black;">
					<c:if test="${quiz!=null}">
					<div class="body">
						<div class="Text-center">
							<center>
								<h2>Title: ${quiz.title}</h2>
								<br>
								<h4>Each question point: ${quiz.point}</h4>
								<br>
								<h4>Exam duration: ${quiz.duration} minute</h4>
								<hr>
							</center>
						</div>
						<div class="row">
							<div class="col-lg-8" style="padding-left: 30px;">
								<c:if test="${quiz.mcqList!=null}">
									<h3>MCQ</h3>
									<c:forEach items="${quiz.mcqList}" var="mcq">
										<h4>
											${mcq.question}
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
								<c:if test="${quiz.tfList!=null}">
									<br>
									<br>
									<h3>True False</h3>
									<c:forEach items="${quiz.tfList}" var="tf">
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

								<c:if test="${quiz.sqList!=null}">
									<br>
									<br>
									<h3>Short Questions</h3>
									<c:forEach items="${quiz.sqList}" var="sq">
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
							<a href='<spring:url value="/saveQuizQuestion.html"></spring:url>'
								class="btn btn-success">Submit</a>
						</div>
						<br> <br>
					</div>
					</c:if>
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
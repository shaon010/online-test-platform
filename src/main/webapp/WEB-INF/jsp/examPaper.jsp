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

                        <form action="/saveQuizAns.html" method="post" id="examPaper">
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
                            <input type="hidden" name="quizId" value="${quiz.id}"/>
							<div class="col-lg-8" style="padding-left: 30px;">
								<c:if test="${quiz.mcqList!=null}">
									<h3>MCQ</h3>
									<c:forEach items="${quiz.mcqList.size()!=0}" var="mcq">
										<h4>
											${mcq.question}
										</h4>
										<p class="help-block">The first letter may be R</p>
										<div style="padding-left: 20px;">
											<label class="checkbox "> <input type="checkbox" name="checkbox1[]"
												id="inlineCheckbox1" value=1>${mcq.choice1}
											</label>
                                            <label class="checkbox "> <input type="checkbox"
												id="inlineCheckbox1" name="checkbox2[]" value=2>${mcq.choice2}
											</label>
                                            <label class="checkbox "> <input type="checkbox"
												id="inlineCheckbox1" name="checkbox3[]" value=3 >${mcq.choice3}
											</label>
                                            <label class="checkbox "> <input type="checkbox"
												id="inlineCheckbox1" name="checkbox4[]" value=4>${mcq.choice4}
											</label>
                                            <label class="checkbox"> <input type="checkbox"
												id="inlineCheckbox1" name="checkbox5[]" value=5>${mcq.choice5}
											</label>
                                            <input type="hidden" value="${mcq.id}" name="mcq[]">
										</div>
										<br>
									</c:forEach>
								</c:if>
								<c:if test="${quiz.tfList.size()!=0}">
									<br>
									<br>
                                    <div>
									<h3>True False</h3>
									<c:forEach items="${quiz.tfList}" var="tf" >
                                        <div>
										<h4>${tf.question}
										</h4>
										<p class="help-block">The first letter may be R</p>
										<br>
                                            <input type="hidden" value="${tf.id}" name="tf[]">
                                            <div class="radio-inline">
											<label> <input type="radio" name="tfOption[]${tf.id}" value="true" checked> True
											</label>
										</div>
										<div class="radio-inline">
											<label> <input type="radio" name="tfOption[]${tf.id}"
												id="optionsRadios2" value="false"> False
											</label>
										</div>
										<br>
                                        </div>
									</c:forEach>
                                    </div>
								</c:if>

								<c:if test="${quiz.sqList.size()!=0}">
									<br>
									<br>
									<h3>Short Questions</h3>
									<c:forEach items="${quiz.sqList}" var="sq">
										<h4>
											${sq.question}
										</h4>
										<p class="help-block">The first letter may be R</p>
										<textarea class="form-control" rows="3" name="sqAns[]"> </textarea>
										<br>
                                        <input type="hidden" value="${sq.id}" name="sq[]">
									</c:forEach>
								</c:if>
							</div>
						</div>
						<!--end row-->
                            <div class="text-center">
                                <input type="submit" class="btn btn-success" onclick="postExamPaper()">
                            </div>
                        </form>
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

<script type="text/javascript">

    $('#examPaper').submit(function () {

        $.ajax({
            url: $(this).attr('action'),
            type: 'POST',
            data: JSON.stringify($(this).serializeArray()),
            contentType: 'application/json',
            success: function () {
                alert('Successfully submitted!!');
                location.href = "/studentCoursePage/${quiz.course.id}.html?success=true"
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('An error has occured!! :-(')
            }
        });

        return false
    });

</script>
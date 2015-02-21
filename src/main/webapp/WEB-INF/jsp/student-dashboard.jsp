<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<div class="container" style="padding-top:100px;">
    <div class="row">
        <div class="col-lg-2">
            <a class="" href="#">
                <img class="col-lg-12" src="student.png" alt="...">
            </a>
            <div class="">
                <h4>Raju</h4>
                <p>Daffodil International University<br>Dept. of CSE</p>
            </div>
        </div><!--end col-lg-2-->

        <div class="col-lg-10">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2>Your courses</h2>
                </div><hr>
                <div class="panel-body">
                    <div class="row">

                            <c:forEach items="${studentCourses}" var="studentCourse">
                                <div class="col-md-2">
                                    <a href="<spring:url value="/studentCoursePage/${studentCourse.course.id}.html"/>" class="thumbnail">
                                        <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                                        <div class="caption" style="margin-top:-25px;">
                                            <h3>${studentCourse.course.title}</h3>
                                            <p><small>${studentCourse.course.user.name}</small></p>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>

                    </div>
                    <a href="course.html" class="pull-right">View More..</a>
                </div>
            </div><!-- end your courses panel-->

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2>Afforded courses by your university</h2>
                </div><hr>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="thumbnail">
                                <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                                <div class="caption" style="margin-top:-25px;">
                                    <h3>Database</h3>
                                    <p><small>S.Akhter Hossain</small></p>
                                    <a href="#" class="btn btn-primary" role="button">Join</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="thumbnail">
                                <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                                <div class="caption" style="margin-top:-25px;">
                                    <h3>Java</h3>
                                    <p><small>S.Akhter Hossain</small></p>
                                    <a href="#" class="btn btn-primary" role="button">Join</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="thumbnail">
                                <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                                <div class="caption" style="margin-top:-25px;">
                                    <h3>Network</h3>
                                    <p><small>S.Akhter Hossain</small></p>
                                    <a href="#" class="btn btn-primary" role="button">Join</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a href="course.html" class="pull-right">View More..</a>
                </div>
            </div><!--end Afforded courses by your university panel-->

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2>Similar courses from other university</h2>
                </div><hr>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="thumbnail">
                                <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                                <div class="caption" style="margin-top:-25px;">
                                    <h3>Database</h3>
                                    <p><small>S.Akhter Hossain<br>DIU<br>Depart.Head CSE</small></p>
                                    <a href="#" class="btn btn-primary" role="button">Join</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="thumbnail">
                                <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                                <div class="caption" style="margin-top:-25px;">
                                    <h3>Java</h3>
                                    <p><small>S.Akhter Hossain<br>AIUB<br>Depart.Head CSE</small></p>
                                    <a href="#" class="btn btn-primary" role="button">Join</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="thumbnail">
                                <img src="<c:url value='/resources/images/database.jpg'/>" alt="..." class="col-lg-12">
                                <div class="caption" style="margin-top:-25px;">
                                    <h3>Network</h3>
                                    <p><small>S.Akhter Hossain<br>BRACS<br>Depart.Head CSE</small></p>
                                    <a href="#" class="btn btn-primary" role="button">Join</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a href="course.html" class="pull-right">View More..</a>
                </div>
            </div><!--end Similar courses of other university panel-->
        </div><!--end col-lg-10-->
    </div>
</div>
package org.otp.repository;

import org.otp.entity.Course;
import org.otp.entity.CourseJoinRequest;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseJoinRequestRepository extends JpaRepository<CourseJoinRequest, Integer>{

	CourseJoinRequest findByUserAndCourse(Users user, Course course);


    List<CourseJoinRequest> findAllByCourse(Course course);

    CourseJoinRequest findByCourseAndUser(Course course, Users user);
}

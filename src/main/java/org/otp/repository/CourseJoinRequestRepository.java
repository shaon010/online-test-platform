package org.otp.repository;

import org.otp.entity.Course;
import org.otp.entity.CourseJoinRequest;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJoinRequestRepository extends JpaRepository<CourseJoinRequest, Integer>{

	CourseJoinRequest findByUserAndCourse(Users user, Course course);

	


}

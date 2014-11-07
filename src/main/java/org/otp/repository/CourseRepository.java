package org.otp.repository;

import org.otp.entity.Course;
import org.otp.entity.Quiz;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	


}

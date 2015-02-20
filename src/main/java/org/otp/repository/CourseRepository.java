package org.otp.repository;

import org.otp.entity.Course;
import org.otp.entity.Quiz;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer>{


    List<Course> findAllByUser(Users user);
}

package org.otp.repository;

import org.otp.entity.Course;
import org.otp.entity.Quiz;
import org.otp.entity.Result;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer>{

    List<Result> findAllByUser(Users user);

    List<Result> findAllByUserAndQuiz_Course_Id(Users user, int courseId);
    // List<Result> findAllByUserAndCourse(Users user, Course course);
}

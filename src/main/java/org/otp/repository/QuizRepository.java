package org.otp.repository;

import org.otp.entity.Course;
import org.otp.entity.Quiz;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{


    List<Quiz> findAllByCourse_IdAndActive(int course, boolean active);
}

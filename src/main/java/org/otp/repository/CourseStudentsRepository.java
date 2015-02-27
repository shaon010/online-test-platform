package org.otp.repository;

import org.otp.entity.Course;
import org.otp.entity.CourseStudents;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseStudentsRepository extends JpaRepository<CourseStudents, Integer>{


    List<CourseStudents> findAllByUser(Users user);

    List<CourseStudents> findAllByCourse_Id(int courseId);

    List<CourseStudents> findAllByCourse_IdAndUser_Id(int courseId, int studentId);
}

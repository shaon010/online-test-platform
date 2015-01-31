package org.otp.repository;

import java.util.List;

import org.otp.entity.Mcq;
import org.otp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface McqRepository extends JpaRepository<Mcq, Integer>{

	List<Mcq> findAllByQuiz(Quiz quiz);

	


}

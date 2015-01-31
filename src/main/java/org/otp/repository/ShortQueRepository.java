package org.otp.repository;

import java.util.List;

import org.otp.entity.Quiz;
import org.otp.entity.ShortQue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortQueRepository extends JpaRepository<ShortQue, Integer>{

	List<ShortQue> findAllByQuiz(Quiz quiz);

	


}

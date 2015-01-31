package org.otp.repository;

import java.util.List;

import org.otp.entity.Quiz;
import org.otp.entity.TF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TFRepository extends JpaRepository<TF, Integer>{

	List<TF> findAllByQuiz(Quiz quiz);

	


}

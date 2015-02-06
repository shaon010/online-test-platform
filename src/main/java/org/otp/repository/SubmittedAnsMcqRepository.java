package org.otp.repository;

import org.otp.entity.Mcq;
import org.otp.entity.Quiz;
import org.otp.entity.SubmittedAnsMcq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmittedAnsMcqRepository extends JpaRepository<SubmittedAnsMcq, Integer>{


}

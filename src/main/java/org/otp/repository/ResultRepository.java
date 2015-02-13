package org.otp.repository;

import org.otp.entity.Quiz;
import org.otp.entity.Result;
import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer>{

    List<Result> findAllByUser(Users user);
}

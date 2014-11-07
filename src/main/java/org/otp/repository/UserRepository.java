package org.otp.repository;

import org.otp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>{

	

	Users findByUsername(String name);


}

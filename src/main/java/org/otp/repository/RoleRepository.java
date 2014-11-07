package org.otp.repository;

import org.otp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}

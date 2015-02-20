package org.otp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.otp.entity.Course;
import org.otp.entity.Role;
import org.otp.entity.Users;
import org.otp.repository.CourseRepository;
import org.otp.repository.RoleRepository;
import org.otp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	

	public Users findOne(int id) {
		return userRepository.findOne(id);
	}
	
	
	public void save(Users user, String role) {
		user.setEnabled(1);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		if (role.equals("2")) {
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByName("ROLE_TEACHER"));
			user.setRoles(roles);
		} else {
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleRepository.findByName("ROLE_STUDENT"));
			user.setRoles(roles);
		}
		
		/*List<Role> role=user.getRoles();

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName(""));
		user.setRoles(role);*/
		userRepository.save(user);
	}

	
	private boolean role(String string) {
		// TODO Auto-generated method stub
		return false;
	}


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(@P("id")int id) {
		userRepository.delete(id);
	}

	public Users findOne(String username) {
		return userRepository.findByUsername(username);
	}

	public List<Users> getUsers() {
		return userRepository.findAll();
	}

}

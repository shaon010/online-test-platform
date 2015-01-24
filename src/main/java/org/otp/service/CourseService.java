package org.otp.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.otp.entity.Course;
import org.otp.entity.CourseJoinRequest;
import org.otp.entity.CourseStudents;
import org.otp.entity.Users;
import org.otp.repository.CourseAnnouncementReository;
import org.otp.repository.CourseJoinRequestRepository;
import org.otp.repository.CourseRepository;
import org.otp.repository.CourseStudentsRepository;
import org.otp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseJoinRequestRepository courseJoinRequestRepository;
	
	@Autowired
	private CourseStudentsRepository courseStudentsRepository;
	
	@Autowired
	private CourseAnnouncementReository courseAnnouncementReository;

	public void save(Course course, String name) {
		Users user = userRepository.findByUsername(name);
		course.setPublishedDate(new Date());
		course.setUser(user);
		courseRepository.save(course);
	}

	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseRepository.findAll(new PageRequest(0, 20, Direction.DESC, "startDate")).getContent();
	}

	public Course findById(int id) {
		// TODO Auto-generated method stub
		return courseRepository.findOne(id);
	}

	public void saveJoinRequest(int id, String name) {
		Users user = userRepository.findByUsername(name);
		Course course = courseRepository.findOne(id);
		CourseJoinRequest courseJoinRequest = new CourseJoinRequest();
		courseJoinRequest.setCourse(course);
		courseJoinRequest.setUser(user);
		courseJoinRequest.setRequestDate(new Date());
		courseJoinRequestRepository.save(courseJoinRequest);

	}
	public void saveCourseStudent(int id, String name) {
		Users user = userRepository.findByUsername(name);
		Course course = courseRepository.findOne(id);
		CourseStudents courseStudent=new CourseStudents();
		courseStudent.setCourse(course);
		courseStudent.setUser(user);
		courseStudent.setJoinDate(new Date());
		courseStudentsRepository.save(courseStudent);		
	}

	public CourseJoinRequest findByUserFromRequest(String name, int id) {
		Users user = userRepository.findByUsername(name);
		Course course=courseRepository.findOne(id);
		//int userid= user.getId();
		return courseJoinRequestRepository.findByUserAndCourse(user,course);
	}

	public List<CourseJoinRequest> findAllRequest() {
		// TODO Auto-generated method stub
		return courseJoinRequestRepository.findAll();
		
	}

	
	
	
	
	
/*
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	public Users findOne(int id) {
		return userRepository.findOne(id);
	}
	
	
	public void save(Users user) {
		user.setEnabled(1);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);

		userRepository.save(user);
	}

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(@P("id")int id) {
		userRepository.delete(id);
	}

	public Users findOne(String username) {
		return userRepository.findByName(username);
	}

	public List<Users> getUsers() {
		return userRepository.findAll();
	}*/

}

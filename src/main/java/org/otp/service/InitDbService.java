package org.otp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.otp.entity.Course;
import org.otp.entity.Role;
import org.otp.entity.Users;
import org.otp.repository.CourseRepository;
import org.otp.repository.RoleRepository;
import org.otp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@PostConstruct
	public void init() {
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			
			Role roleStudent = new Role();
			roleStudent.setName("ROLE_STUDENT");
			roleRepository.save(roleStudent);
			
			Role roleTeacher = new Role();
			roleTeacher.setName("ROLE_TEACHER");
			roleRepository.save(roleTeacher);

			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);

			Users userAdmin = new Users();
			userAdmin.setEnabled(1);
			userAdmin.setUsername("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleAdmin);
			roles.add(roleStudent);
			roles.add(roleTeacher);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);
			
			Users userStudent = new Users();
			userStudent.setEnabled(1);
			userStudent.setUsername("sss");
			userStudent.setName("Demo Student");
			userStudent.setUvname("DIU");
			userStudent.setPassword(encoder.encode("sssss"));
			List<Role> roles2 = new ArrayList<Role>();
			roles2.add(roleStudent);
			userStudent.setRoles(roles2);
			userRepository.save(userStudent);
			
			Users userTeacher = new Users();
			userTeacher.setEnabled(1);
			userTeacher.setUsername("ttt");
			userTeacher.setName("Demo Teacher");
			userTeacher.setUvname("DIU");
			userTeacher.setPassword(encoder.encode("ttttt"));
			List<Role> roles1 = new ArrayList<Role>();
			roles1.add(roleTeacher);
		    userTeacher.setRoles(roles1);
			userRepository.save(userTeacher);
			
			Course course1=new Course();
			course1.setDescription("In this course you will get an introduction to the main tools "
					+ "and ideas in the data scientist's toolbox. The course gives an overview of the"
					+ " data, questions, and tools that data analysts and data scientists work with. "
					+ "There are two components to this course. The first is a conceptual introduction to"
					+ " the ideas behind turning data into actionable knowledge. The second is a practical "
					+ "introduction to the tools that will be used in the program like version control, "
					+ "markdown, git, GitHub, R, and RStudio.");
			course1.setStartDate("2014-10-01");
			course1.setPublishedDate(new Date());
			course1.setTitle("Software Engineering");
			course1.setUser(userTeacher);
			course1.setFaq1("Accomplishment?");
			course1.setFaq1ans("Yes");
			course1.setFaq2("Accomplishment?2");
			course1.setFaq2ans("Yes");
			course1.setFaq3("Accomplishment?3");
			course1.setFaq3ans("Yes");
			courseRepository.save(course1);
			
			Course course2=new Course();
			course2.setDescription("In this course you will get an introduction to the main tools "
					+ "and ideas in the data scientist's toolbox. The course gives an overview of the"
					+ " data, questions, and tools that data analysts and data scientists work with. "
					+ "There are two components to this course. The first is a conceptual introduction to"
					+ " the ideas behind turning data into actionable knowledge. The second is a practical "
					+ "introduction to the tools that will be used in the program like version control, "
					+ "markdown, git, GitHub, R, and RStudio.");
			course2.setStartDate("2014-10-05");
			course2.setPublishedDate(new Date());
			course2.setTitle("Data Mining");
			course2.setUser(userTeacher);
			course2.setFaq1("Accomplishment?");
			course2.setFaq1ans("Yes");
			course2.setFaq2("Accomplishment?2");
			course2.setFaq2ans("Yes");
			course2.setFaq3("Accomplishment?3");
			course2.setFaq3ans("Yes");
			courseRepository.save(course2);
			
			Course course3=new Course();
			course3.setDescription("In this course you will get an introduction to the main tools "
					+ "and ideas in the data scientist's toolbox. The course gives an overview of the"
					+ " data, questions, and tools that data analysts and data scientists work with. "
					+ "There are two components to this course. The first is a conceptual introduction to"
					+ " the ideas behind turning data into actionable knowledge. The second is a practical "
					+ "introduction to the tools that will be used in the program like version control, "
					+ "markdown, git, GitHub, R, and RStudio.");
			course3.setStartDate("2014-10-10");
			course3.setPublishedDate(new Date());
			course3.setTitle("Java");
			course3.setUser(userTeacher);
			course3.setFaq1("Accomplishment?");
			course3.setFaq1ans("Yes");
			course3.setFaq2("Accomplishment?2");
			course3.setFaq2ans("Yes");
			course3.setFaq3("Accomplishment?3");
			course3.setFaq3ans("Yes");
			courseRepository.save(course3);
			
		}
	}
}


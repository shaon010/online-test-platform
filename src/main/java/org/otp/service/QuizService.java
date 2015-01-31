package org.otp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.otp.entity.Mcq;
import org.otp.entity.Quiz;
import org.otp.entity.ShortQue;
import org.otp.entity.TF;
import org.otp.repository.McqRepository;
import org.otp.repository.QuizRepository;
import org.otp.repository.RoleRepository;
import org.otp.repository.ShortQueRepository;
import org.otp.repository.TFRepository;
import org.otp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuizService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private McqRepository mcqRepository;
	@Autowired
	private TFRepository tfRepository;
	@Autowired
	private ShortQueRepository sqRepository;

	public void save(Quiz quiz) {
		quizRepository.save(quiz);
		
	}

	public void save(Mcq mcq) {
		mcqRepository.save(mcq);

	}
	
	public void save(ShortQue sq) {
		sqRepository.save(sq);
		
	}
	
	public void save(TF tf) {
		tfRepository.save(tf);
		
	}

	public List<Quiz> findAllQuizes() {
		return quizRepository.findAll();
	}

	public Quiz findById(int id) {
		Quiz quiz=quizRepository.findOne(id);
		List<Mcq> mcqList=mcqRepository.findAllByQuiz(quiz);
		List<TF> tfList=tfRepository.findAllByQuiz(quiz);
		List<ShortQue> sqList=sqRepository.findAllByQuiz(quiz);
		quiz.setMcqList(mcqList);
		quiz.setSqList(sqList);
		quiz.setTfList(tfList);
		return quiz;
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

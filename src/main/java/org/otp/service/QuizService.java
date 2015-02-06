package org.otp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.otp.entity.*;
import org.otp.repository.*;
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
    @Autowired
    private SubmittedAnsMcqRepository submittedAnsMcqRepository;
    @Autowired
    private SubmittedAnsShortQueRepository submittedAnsShortQueRepository;
    @Autowired
    private SubmittedAnsTFRepository submittedAnsTFRepository;

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

    public void saveQuizAns(int[] mcqId, int[] sqId, int[] tfId, int[] checkbox1,
                            int[] checkbox2, int[] checkbox3, int[] checkbox4, int[] checkbox5,
                            String[] tfOption, String[] sqAns,String user) {
        Users users=userRepository.findByUsername(user);
        for(int i=0;i<mcqId.length;i++){
           Mcq mcq= mcqRepository.findOne(mcqId[i]);
            SubmittedAnsMcq submittedAnsMcq=new SubmittedAnsMcq();
            if(checkbox1[0]!=-1 && checkbox1.length>i){
                submittedAnsMcq.setCheckbox1(checkbox1[i]);
            }
            if(checkbox2[0]!=-1&& checkbox2.length>i){
                submittedAnsMcq.setCheckbox2(checkbox2[i]);
            }
            if(checkbox3[0]!=-1&& checkbox3.length>i){
                submittedAnsMcq.setCheckbox3(checkbox3[i]);
            }
            if(checkbox4[0]!=-1&& checkbox4.length>i){
                submittedAnsMcq.setCheckbox4(checkbox4[i]);
            }
            if(checkbox5[0]!=-1&& checkbox5.length>i){
                submittedAnsMcq.setCheckbox5(checkbox5[i]);
            }
            submittedAnsMcq.setMcq(mcq);
            submittedAnsMcq.setUser(users);
            submittedAnsMcqRepository.save(submittedAnsMcq);
        }
        for(int i=0;i<sqId.length;i++){
            ShortQue shortQue=sqRepository.findOne(sqId[i]);
            SubmittedAnsShortQue submittedAnsShortQue=new SubmittedAnsShortQue();
            submittedAnsShortQue.setAnswer(sqAns[i]);
            submittedAnsShortQue.setSq(shortQue);
            submittedAnsShortQue.setUser(users);
            submittedAnsShortQueRepository.save(submittedAnsShortQue);
        }
        for(int i=0;i<tfId.length;i++){
           TF tf=tfRepository.findOne(tfId[i]);
            SubmittedAnsTF submittedAnsTF=new SubmittedAnsTF();
            submittedAnsTF.setTfOption(tfOption[i]);
            submittedAnsTF.setTf(tf);
            submittedAnsTF.setUser(users);
            submittedAnsTFRepository.save(submittedAnsTF);

        }

            
        }
        
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



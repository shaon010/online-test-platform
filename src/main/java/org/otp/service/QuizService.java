package org.otp.service;

import java.util.List;
import java.util.Map;

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
    int tfCheckingId=0;

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

    public void saveQuizAns(List<Map<String, String>> submittedQuiz) {
        SubmittedAnsMcq submittedAnsMcq=new SubmittedAnsMcq();
        SubmittedAnsShortQue submittedAnsShortQue =new SubmittedAnsShortQue();
        SubmittedAnsTF submittedAnsTF = new SubmittedAnsTF();
        Mcq mcq= new Mcq();
        TF tf = new TF();
        ShortQue shortQue=new ShortQue();


        for (Map<String, String> formInput : submittedQuiz) {
            if(formInput.get("name").equals("checkbox1[]")){
                int ans=Integer.parseInt(formInput.get("value"));
                submittedAnsMcq.setCheckbox1(ans);
            }
            else if(formInput.get("name").equals("checkbox2[]")){
                int ans=Integer.parseInt(formInput.get("value"));
                submittedAnsMcq.setCheckbox2(ans);
            }
           else if(formInput.get("name").equals("checkbox3[]")){
                int ans=Integer.parseInt(formInput.get("value"));
                submittedAnsMcq.setCheckbox3(ans);
            }
           else if(formInput.get("name").equals("checkbox4[]")){
                int ans=Integer.parseInt(formInput.get("value"));
                submittedAnsMcq.setCheckbox4(ans);
            }
            else if(formInput.get("name").equals("checkbox5[]")){
                int ans=Integer.parseInt(formInput.get("value"));
                submittedAnsMcq.setCheckbox5(ans);
            }
            else if(formInput.get("name").equals("mcq[]")){
                mcq= mcqRepository.findOne(Integer.parseInt(formInput.get("value")));
                submittedAnsMcq.setMcq(mcq);
                if(submittedAnsMcq.getCheckbox1()==mcq.getCheckbox1()&&submittedAnsMcq.getCheckbox2()==mcq.getCheckbox2()&&
                        submittedAnsMcq.getCheckbox3()==mcq.getCheckbox3()&&submittedAnsMcq.getCheckbox4()==mcq.getCheckbox4()&&
                        submittedAnsMcq.getCheckbox5()==mcq.getCheckbox5()){
                    submittedAnsMcq.setAnsState(true);
                }
                submittedAnsMcqRepository.save(submittedAnsMcq);
               submittedAnsMcq= new SubmittedAnsMcq();
            }
            else if(formInput.get("name").equals("tf[]")){
                tfCheckingId=Integer.parseInt(formInput.get("value"));
                tf=tfRepository.findOne(tfCheckingId);
                submittedAnsTF.setTf(tf);
            }
            else if(formInput.get("name").equals("tfOption[]"+String.valueOf(tfCheckingId))){
                String  ans=formInput.get("value");
                submittedAnsTF.setTfOption(ans);
                if(tf.getTfOption().equals(submittedAnsTF.getTfOption())){
                    submittedAnsTF.setAnsState(true);
                }
                submittedAnsTFRepository.save(submittedAnsTF);
                submittedAnsTF=new SubmittedAnsTF();
            }
            else if(formInput.get("name").equals("sqAns[]")){
                String ans=formInput.get("value");
                submittedAnsShortQue.setAnswer(ans);
            }
            else if(formInput.get("name").equals("sq[]")){
                shortQue=sqRepository.findOne(Integer.parseInt(formInput.get("value")));
                submittedAnsShortQue.setSq(shortQue);
                submittedAnsShortQueRepository.save(submittedAnsShortQue);
                submittedAnsShortQue=new SubmittedAnsShortQue();
            }
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



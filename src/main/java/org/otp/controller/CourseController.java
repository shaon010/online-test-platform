package org.otp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.otp.entity.Course;
import org.otp.entity.Mcq;
import org.otp.entity.Quiz;
import org.otp.entity.ShortQue;
import org.otp.entity.TF;
import org.otp.service.CourseService;
import org.otp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class CourseController {
	
	@Autowired
	QuizService quizService;
	@Autowired
	CourseService courseService;
	
	@ModelAttribute("course")
	public Course constructCourse() {
		return new Course();
	}

	@ModelAttribute("mcq")
	public Mcq constructMcq() {
		return new Mcq();
	}
	
	@ModelAttribute("quiz")
	public Quiz constructQuiz() {
		return new Quiz();
	}
	@ModelAttribute("tf")
	public TF constructTF() {
		return new TF();
	}
	@ModelAttribute("sq")
	public ShortQue constructShortQue() {
		return new ShortQue();
	}
	
	@RequestMapping("/createquiz")
	public String createQuizinInit(Model model, Principal principal) {
		model.addAttribute("request", courseService.findAllRequest());
		return "createquiz";
	}
	
	@RequestMapping("/createcourse")
	public String createCourseInit(Model model, Principal principal) {
		return "createcourse";
	}
	@RequestMapping("/studentCoursePage")
	public String studentCoursePageInit(Model model, Principal principal) {
		model.addAttribute("quizes", quizService.findAllQuizes());
		return "studentCoursePage";
	}
	@RequestMapping("/quiz/attend/{id}")
	public String attendQuizInit(Model model, Principal principal,@PathVariable int id) {
		model.addAttribute("quiz", quizService.findById(id));
		return "exampaper";
	}
    
    
    @RequestMapping("/saveQuizAns")
	public String saveQuiz(Model model, Principal principal,
                           @RequestParam(value="checkbox1[]",defaultValue ="-1") int[] checkbox1,
                           @RequestParam(value="checkbox2[]",defaultValue ="-1") int[] checkbox2,
                           @RequestParam(value="checkbox3[]",defaultValue ="-1") int[] checkbox3,
                           @RequestParam(value="checkbox4[]",defaultValue ="-1") int[] checkbox4,
                           @RequestParam(value="checkbox5[]",defaultValue ="-1") int[] checkbox5,
                           @RequestParam(value="tfOption[]",defaultValue ="-1") String[] tfOption,
                           @RequestParam(value="sqAns[]",defaultValue ="-1") String[] sqAns,
                           @RequestParam(value="mcq[]",defaultValue ="-1") int[] mcq,
                           @RequestParam(value="sq[]",defaultValue ="-1") int[] sq,
                           @RequestParam(value="tf[]",defaultValue ="-1") int[] tf
                           ) {
        String user = principal.getName();
        quizService.saveQuizAns(mcq, sq, tf, checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, tfOption, sqAns,user);
        System.out.println("shaon");
		System.out.println(checkbox1[0]);
		System.out.println(sq[0]);
		System.out.println(tfOption[0]);
		System.out.println(sqAns[0]);
        if(mcq!=null){
            System.out.println("mcq is null");
        }

		//model.addAttribute("quiz", quizService.findById(id));
        
        return  "redirect:/index.html";
	}
	
    
	@RequestMapping("/aboutcourse/{id}")
	public String aboutCourseShow(Model model,Principal principal,@PathVariable int id) {
		String name=null;
		model.addAttribute("course", courseService.findById(id));
		if(principal!=null){
		name=principal.getName();
		}
		model.addAttribute("request",courseService.findByUserFromRequest(name,id));
		return "aboutcourse";
	}
	
	@RequestMapping(value="/createcourse",method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("course") Course course , Principal principal) {
		String name= principal.getName();
		courseService.save(course,name);
		return "redirect:/createcourse.html";
	}
	
	@RequestMapping(value="/storequiz", method=RequestMethod.POST)
	public String quizAjaxCall(Model model,@ModelAttribute("quiz") Quiz quiz, BindingResult result,HttpSession session) {
		  session.setAttribute("quiz", quiz);
		return "preview";
	}
	@RequestMapping("/joinrequest/{id}")
	public String sendJoinRequest(Model model, Principal principal,@PathVariable int id) {
		String name=principal.getName();
		courseService.saveJoinRequest(id,name);
		courseService.saveCourseStudent(id,name);
		//model.addAttribute("course", courseService.findById(id));
		//model.addAttribute("request",courseService.findByUserFromRequest(name));
		//model.addAttribute("course",courseService.getAllCourse() );
		return "redirect:/index.html";
	}
	@RequestMapping(value="/saveQuizQuestion.html")
	public String SaveQuizquestion(HttpSession session) {
		List<Mcq> mcqList= new ArrayList<Mcq>();
		List<TF> tfList= new ArrayList<TF>();
		List<ShortQue> sqList= new ArrayList<ShortQue>();
		Quiz quiz=(Quiz) session.getAttribute("quiz");
		
		quizService.save(quiz);
		
		if(session.getAttribute("mcq")!=null){
			mcqList=(List<Mcq>) session.getAttribute("mcq");
			for (Mcq mcq : mcqList) {
				mcq.setQuiz(quiz);
				quizService.save(mcq);
			}
		}
		
		if(session.getAttribute("tf")!=null){
			tfList=(List<TF>) session.getAttribute("tf");
			for (TF tf : tfList) {
				tf.setQuiz(quiz);
				quizService.save(tf);
			}
		}
		if(session.getAttribute("sq")!=null){
			sqList=(List<ShortQue>) session.getAttribute("sq");
			for (ShortQue sq : sqList) {
				sq.setQuiz(quiz);
				quizService.save(sq);
			}
		}
		
		session.removeAttribute("quiz");
		session.removeAttribute("mcq");
		session.removeAttribute("sq");
		session.removeAttribute("tf");
		return "createquiz";
	}
	
	@RequestMapping(value="/preview")
	public String previewQues(Model model,HttpSession session) {
		
		  model.addAttribute("quiz", session.getAttribute("quiz"));
		  
	/*	  if(session.getAttribute("mcq")==null){
				Mcq mcq=null;
			  session.setAttribute("mcq", mcq);
			}
		  if(session.getAttribute("sq")==null){
				ShortQue sq=null;
			  session.setAttribute("sq", sq);
		  }
		  if(session.getAttribute("tf")==null){
				TF tf=null;
			  session.setAttribute("tf", tf);
		  }
*/
		  model.addAttribute("mcq", session.getAttribute("mcq"));
		  model.addAttribute("sq", session.getAttribute("sq"));
		  model.addAttribute("tf", session.getAttribute("tf"));

		return "preview";
	}
	
	@RequestMapping("/clearsession")
	public String clearSession(Model model, Principal principal,HttpSession session) {
		
		session.removeAttribute("mcq");
		session.removeAttribute("sq");
		session.removeAttribute("tf");
		return "createquiz";
	}
	
/*	
 * 
 * MCQ AJAX CALL
 * 
 * */

	 @SuppressWarnings("unchecked")
	@RequestMapping( value="/savemcq" ,method = RequestMethod.POST)
	 public @ResponseBody
	 String savemcq(@ModelAttribute("mcq") Mcq mcq, BindingResult result,HttpSession session)
	   throws Exception {
		 
	  List<Mcq> mcqList= new ArrayList<Mcq>();
		if(session.getAttribute("mcq")!=null){
			mcqList=(List<Mcq>) session.getAttribute("mcq");
		}
	  
	  
	  mcqList.add(mcq);
	  session.setAttribute("mcq", mcqList);
	  
	 
	//for debugging  
	for (Mcq mcq2 : mcqList) {
		System.out.println(mcq2.getQuestion());
	} //
	  return "success";
	 }
	 
	 /*	
	  * 
	  * TF AJAX CALL
	  * 
	  * */
	 
	 @SuppressWarnings("unchecked")
	@RequestMapping( value="/savetf" ,method = RequestMethod.POST)
	 public @ResponseBody
	 String savetf(@ModelAttribute("tf") TF tf, BindingResult result,HttpSession session)
	   throws Exception {
	  List<TF> tfList= new ArrayList<TF>();
	  
		if(session.getAttribute("tf")!=null){
			tfList=(List<TF>) session.getAttribute("tf");
		}

		tfList.add(tf);
	  
	  session.setAttribute("tf", tfList);
	  
	//for debugging  
	for (TF tf2 : tfList) {
		System.out.println(tf2.getQuestion());
	} 
	  return "success";
	 }

	 /*	
	  * 
	  * Short que AJAX CALL
	  * 
	  *
	  * */
	 @SuppressWarnings("unchecked")
		@RequestMapping( value="/savesq" ,method = RequestMethod.POST)
		 public @ResponseBody
		 String savesq(@ModelAttribute("sq") ShortQue sq, BindingResult result,HttpSession session)
		   throws Exception {
		  List<ShortQue> sqList= new ArrayList<ShortQue>(); 
			if(session.getAttribute("sq")!=null){
				sqList=(List<ShortQue>) session.getAttribute("sq");
			}
			
			sqList.add(sq);
		  
		  session.setAttribute("sq", sqList);
		  
		//for debugging  
		for (ShortQue sq2 : sqList) {
			System.out.println(sq2.getQuestion());
		} //
		  return "success";
		 }
	 
	}

package org.otp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.otp.entity.*;
import org.otp.service.CourseService;
import org.otp.service.QuizService;
import org.otp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class CourseController {

	@Autowired
	QuizService quizService;
	@Autowired
	CourseService courseService;
    @Autowired
    UserService userService;

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

	@RequestMapping("/createquiz/{id}")
	public String createQuizinInit(Model model, Principal principal,@PathVariable int id) {
        model.addAttribute("course", courseService.findById(id));
		model.addAttribute("request", courseService.findAllRequestByCourse(id));
		return "createquiz";
	}

	@RequestMapping("/createcourse")
	public String createCourseInit(Model model, Principal principal) {
		return "createcourse";
	}

	@RequestMapping("/studentCoursePage/{courseId}")
	public String studentCoursePageInit(Model model, Principal principal,@PathVariable int courseId) {
        String userName=principal.getName();
        Users user=userService.findOne(userName);
        model.addAttribute("course",courseService.findById(courseId));
        model.addAttribute("quizes", quizService.findAllQuizesByCourse(courseId));
        model.addAttribute("results",quizService.findResultsByUserAndCourse(user, courseId));
        model.addAttribute("completedQuizIdList",quizService.findAllQuizeByUserAndCourse(user, courseId));
        return "studentCoursePage";
	}
	@RequestMapping("/quiz/attend/{id}")
	public String attendQuizInit(Model model, Principal principal,@PathVariable int id) {
		model.addAttribute("quiz", quizService.findById(id));
		return "exampaper";
	}

    @RequestMapping("/acceptCourseRequest/{courseId}")
	public String acceptCourseRequest(Model model, Principal principal,@PathVariable int courseId,@RequestParam int studentId) {
		courseService.addCourseStudent(courseId,studentId);
		return "redirect:/createquiz/{courseId}.html";
	}


    @RequestMapping(headers = "Content-Type=application/json",  method = RequestMethod.POST, value = "/saveQuizAns")
    @ResponseBody
    public String saveQuiz(@RequestBody List<Map<String, String>> submittedQuiz,Principal principal) throws Exception {
        String userName=principal.getName();
        Users user= userService.findOne(userName);
        quizService.saveQuizAns(submittedQuiz,user);
        System.out.println(submittedQuiz);
        return  "success";
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

	@RequestMapping(value="/storequiz/{courseId}", method=RequestMethod.POST)
	public String quizAjaxCall(Model model,@ModelAttribute("quiz") Quiz quiz,@PathVariable int courseId, BindingResult result,HttpSession session) {
        Course course=courseService.findById(courseId);
        quiz.setCourse(course);
		session.setAttribute("quiz", quiz);
		return "redirect:/preview.html";
	}
	@RequestMapping("/joinrequest/{id}")
	public String sendJoinRequest(Model model, Principal principal,@PathVariable int id) {
		String name=principal.getName();
		courseService.saveJoinRequest(id,name);
		//courseService.saveCourseStudent(id,name);
		//model.addAttribute("course", courseService.findById(id));
		//model.addAttribute("request",courseService.findByUserFromRequest(name));
		//model.addAttribute("course",courseService.getAllCourse() );
		return "redirect:/index.html";
	}
	@RequestMapping(value="/saveQuizQuestion/{courseId}.html")
	public String SaveQuizquestion(HttpSession session, @PathVariable int courseId) {
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
        return "redirect:/createquiz/{courseId}.html";
	}

	@RequestMapping(value="/preview")
	public String previewQues(Model model,HttpSession session) {

		  model.addAttribute("quiz", session.getAttribute("quiz"));
		  model.addAttribute("mcq", session.getAttribute("mcq"));
		  model.addAttribute("sq", session.getAttribute("sq"));
		  model.addAttribute("tf", session.getAttribute("tf"));

		return "preview";
	}

	@RequestMapping("/clearsession/{courseId}")
	public String clearSession(Model model, Principal principal,HttpSession session, @PathVariable int courseId) {

		session.removeAttribute("mcq");
		session.removeAttribute("sq");
		session.removeAttribute("tf");
		return "redirect:/createquiz/{courseId}.html";
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

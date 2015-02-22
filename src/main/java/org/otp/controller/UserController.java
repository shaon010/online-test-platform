package org.otp.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.otp.entity.Mcq;
import org.otp.service.CourseService;
import org.otp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
    @Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/teacherDashboard")
	public String teacherDashboard(Model model, Principal principal) {
		String teacher = principal.getName();
		/*model.addAttribute("user", userService.findOneWithPosts(name));*/
        model.addAttribute("teacherCourses", courseService.findAllByTeacher(teacher));
		return "teacherDashboard";
	}
    @RequestMapping("/studentDashboard")
	public String studentDashboard(Model model, Principal principal) {
		String student = principal.getName();
        model.addAttribute("studentCourses", courseService.findAllByStudent(student));
        model.addAttribute("student", userService.findOne(student));
        return "studentDashboard";
	}
	
	
	

	}

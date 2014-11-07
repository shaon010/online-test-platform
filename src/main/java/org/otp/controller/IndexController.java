package org.otp.controller;


import java.security.Principal;

import org.otp.service.CourseService;
import org.otp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {
@Autowired
private CourseService courseService;

	

	@RequestMapping("/index")
	public String index(Model model,Principal principal) {
		model.addAttribute("course",courseService.getAllCourse() );
		return "index";
	}
	
}

package org.otp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.otp.entity.Users;
import org.otp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public Users constructUser() {
		return new Users();
	}

	@RequestMapping
	public String showRegister() {
		return "user-register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") Users user, BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return "user-register";
		}
		
		String role=request.getParameter("role");
		
		userService.save(user,role);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userService.findOne(username) == null;
		return available.toString();
	}

}

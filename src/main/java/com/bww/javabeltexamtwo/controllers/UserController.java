package com.bww.javabeltexamtwo.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bww.javabeltexamtwo.models.LoginUser;
import com.bww.javabeltexamtwo.models.Task;
import com.bww.javabeltexamtwo.models.User;
import com.bww.javabeltexamtwo.services.TaskService;
import com.bww.javabeltexamtwo.services.UserService;

@Controller
public class UserController {

	private static UserService userServ;
	private static TaskService taskServ;

	public UserController(UserService userServ, TaskService taskServ) {
		this.userServ = userServ;
		this.taskServ = taskServ;
	}

	@GetMapping("/")
	public String signIn(Model model) {
		model.addAttribute("registerringUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "login.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerringUser") User registerringUser, BindingResult result,
			Model model, HttpSession session) {
		if (!registerringUser.getPassword().equals(registerringUser.getConfirmPassword())) {
			result.rejectValue("confirm", "Match", "Confirm Password must match Password!");
		}
		if (userServ.getUser(registerringUser.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email already in use!");
		}

		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "login.jsp";
		} else {
			User u = userServ.create(registerringUser);
			session.setAttribute("user", u.getId());
			return "redirect:/tasks";
		}
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model,
			HttpSession session) {
		User loggingInUser = userServ.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("registerringUser", new User());
			return "login.jsp";
		} else {
			session.setAttribute("user", loggingInUser.getId());
			return "redirect:/tasks";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
}
	
package com.bww.javabeltexamtwo.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bww.javabeltexamtwo.models.Task;
import com.bww.javabeltexamtwo.models.User;
import com.bww.javabeltexamtwo.services.TaskService;
import com.bww.javabeltexamtwo.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private static TaskService taskServ;

	public HomeController(TaskService taskServ) {
		this.taskServ = taskServ;
	}

	@GetMapping("/tasks")
	public String tasks(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user");
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		if (user == null) {
			return "redirect:/";
		}
		model.addAttribute("allTasks", taskServ.getTask());
		return "dashboard.jsp";
	}

	@RequestMapping("/tasks/new")
	public String createTask(@ModelAttribute("newTask") Task newTask) {
		return "createTask.jsp";
	}
	
	@PostMapping("/createTask")
	public String createTask(@ModelAttribute("newTask") Task newTask, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user");
		User user = userService.getUser(userId);
		newTask.setUser(user);
		taskServ.saveTask(newTask);
		return "redirect:/tasks";
	}

	@GetMapping("/tasks/{id}")
	public String showTaskPage(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user");
		User user = userService.getUser(userId);
		if (user == null) {
			return "redirect:/";
		}
		model.addAttribute("someTask", taskServ.getTask(id));
		return "showTask.jsp";
	}


	@GetMapping("edit/tasks/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("someTask", taskServ.getTask(id));
		return "editTask.jsp";
	}

	@PostMapping("/tasks/update/{id}")
	public String updateTask(@PathVariable("id") Long id, @Valid @ModelAttribute("someTasks") Task someTask,
			BindingResult result) {
		if (result.hasErrors()) {
			return "editTask.jsp";
		} else {
			taskServ.update(someTask, id);
			return "redirect:/tasks/{id}";
		}
	}
	
	@RequestMapping("/tasks/destroy/{id}")
	public String destroy(@PathVariable("id") Long Id) {
		taskServ.destory(Id);
		return "redirect:/tasks";
	}
}

package com.archana.pizzaorder.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.archana.pizzaorder.models.User;
import com.archana.pizzaorder.services.OrderService;
import com.archana.pizzaorder.services.UserService;
import com.archana.pizzaorder.validators.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	
	private UserService uService;
	
	@Autowired
	private UserValidator validator;
	@Autowired 
	private OrderService oservice;
	
	
	
	@GetMapping("/")
	public String register(@ModelAttribute("user") User user) {
		//model.addAttribute("", model)
		return "register.jsp";
		
	}
	
	@PostMapping("/register")
	public String createRegisterUser(@Valid @ModelAttribute("user") User user,BindingResult result,HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "register.jsp";	
		}
		//create user
		User newUser=this.uService.registerUser(user);
		//Identify the user
		session.setAttribute("user__id", newUser.getId());
		
		return "redirect:/orders/";
		
	}
	
	@PostMapping("/login")
	public String loginUser(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword") String password,RedirectAttributes redirectAttributes ){
		
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttributes.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
			
		}
		
		User userToLogin =this.uService.getUserByEmail(email);
		session.setAttribute("user__id", userToLogin.getId());
		//session.setAttribute("order_id", );
		return "redirect:/orders/";
		
		
	}
	
	@GetMapping("/logout")
	
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
	
	
	@GetMapping("/dashboard")
	public String usertolog(Model model, HttpSession session) {
		User getUser=this.uService.getOneUser((Long)session.getAttribute("user__id"));
		model.addAttribute("user",getUser);
		return "dashboard.jsp";
	}

}

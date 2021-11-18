package com.archana.pizzaorder.controllers;


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

import com.archana.pizzaorder.models.Comment;
import com.archana.pizzaorder.models.Payment;
import com.archana.pizzaorder.models.Pizza;
import com.archana.pizzaorder.models.User;
import com.archana.pizzaorder.services.CommentService;
import com.archana.pizzaorder.services.OrderService;
import com.archana.pizzaorder.services.PaymentService;
import com.archana.pizzaorder.services.PizzaService;
import com.archana.pizzaorder.services.UserService;


@Controller
@RequestMapping("/orders")
public class HomeController {
	
	@Autowired
	private PizzaService pService;
	
	@Autowired 
	private UserService uService;
	
	@Autowired 
	private CommentService cService;
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private PaymentService payService;
	
	@GetMapping("/")
	public String index(Model viewModel, HttpSession session,@ModelAttribute("Pizza")Pizza pizza) {
			
		if(session.getAttribute("user__id") == null) {
		return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		viewModel.addAttribute("allPizza",this.pService.getAllPizza());
				
		return "dashboard.jsp";
		
	}
	
	@GetMapping("/neworder")
	public String newOrder(@Valid @ModelAttribute("Pizza") Pizza pizza,BindingResult result, Model model,HttpSession session) {
		if(session.getAttribute("user__id")==null) {
			return "redirect:/";
		}
		// provide pizza object a user
		pizza.setCreator(this.uService.getOneUser((Long)session.getAttribute("user__id")));
		//get the current user
		User newUser=this.uService.getOneUser(((Long)session.getAttribute("user__id")));
		// add all user to front end
		model.addAttribute("allUser", this.uService.getAllUser());
		model.addAttribute("allPizza", this.pService.getAllPizza());

		return "createyourownpizza.jsp";
	}
	
	@PostMapping("/neworder")
	public String newOrderPlaced(@ModelAttribute("Pizza") Pizza pizza,BindingResult result,HttpSession session, Model model) {
		if(result.hasErrors()) {
			User user= this.uService.getOneUser((Long)session.getAttribute("user__id"));
			model.addAttribute("allUser",user);
			model.addAttribute("allPizza", this.pService.getAllPizza());

			return "createyourownpizza.jsp";
		}
		User user= this.uService.getOneUser((Long)session.getAttribute("user__id"));
		//pizza.setCreator(user);
		System.out.println(pizza.getTopping());
		this.pService.createPizza(pizza);
		Long id = pizza.getId();
		//System.out.println(this.pService.createPizza(pizza).getTopping());
		//return "redirect:/orders/checkout/{id}";
		//return "redirect:/orders/";
		return "redirect:/orders/checkout/"+id;
	}

	@GetMapping("/checkout/{id}")
	public String checkoutOrder(@PathVariable("id") Long id,Model model) {
		Pizza checkoutPizzaOrder=this.pService.getOnePizza(id);
		model.addAttribute("checoutoneorder",this.pService.getOnePizza(id) );
		System.out.println(checkoutPizzaOrder.getTopping());
		return "show.jsp";
		
	}
	
//	@GetMapping("/checkout/payment/{id}")
//	public String paymentOrder(@PathVariable("id") Long id,Model model) {
//		model.addAttribute("pizza", this.pService.getOnePizza(id));
//		return "payment.jsp";
//	}
	
	@GetMapping("/checkout/payment/{id}")
	public String paymentOrder(@ModelAttribute("payment") Payment payment,@PathVariable("id") Long id,BindingResult result,Model model,HttpSession session) {
		User user= this.uService.getOneUser((Long)session.getAttribute("user__id"));
		model.addAttribute("pizza", this.pService.getOnePizza(id));
		return "payment.jsp";
	}
	
	@PostMapping("/checkout/payment/{id}")
	public String paymentOrderPost(@Valid@ModelAttribute("payment") Payment payment,@PathVariable("id") Long id,BindingResult result,Model model,HttpSession session){
		
		if(result.hasErrors()) {
		User user= this.uService.getOneUser((Long)session.getAttribute("user__id"));
		model.addAttribute("pizza", this.pService.getOnePizza(id));
		return "payment.jsp";
		}
		
		// user who makePayment
		User user= this.uService.getOneUser((Long)session.getAttribute("user__id"));
		// create a payment
		this.payService.createPayment(payment);
		return "redirect:/orders/continue";
	
	}
	
	
	@GetMapping("/continue")
	public String countinueFoody() {
		return "continue.jsp";
	}
	
//	//getMapping for payment
//		@GetMapping("/payment")
//		public String makePayment(@ModelAttribute("payment") Payment payment,BindingResult result, Model model,HttpSesssion session) {
//			//if create order ==null 
//			//getOneUsers
//		return "payment.jsp";
//		}
		
		// Post Mapping for payment
	
	
	
	@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
		this.pService.deletePizza(id);
		 
		 return  "redirect:/orders/";
		
	}

	// edit pizza order
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,@ModelAttribute("pizza") Pizza pizza,Model viewModel ){
		viewModel.addAttribute("allUser", this.uService.getAllUser());
		viewModel.addAttribute("pizza", this.pService.getOnePizza(id));
		return "edit.jsp";
	 
	 //return  "redirect:/orders/";
	
}

	
	
	@GetMapping("/postcomments")
	public String getComment(@ModelAttribute("comment") Comment comment,HttpSession session,Model model) {
		model.addAttribute("allComments", this.cService.getAllComments());
		
		User userToComment=this.uService.getOneUser((Long)session.getAttribute("user__id"));
		model.addAttribute("oneUser", userToComment);
		return "comments.jsp";
	}
	
	
	@PostMapping("/postcomments")
	public String postComments(@ModelAttribute("comment") Comment comment, BindingResult result, HttpSession session,Model model ){
		if(result.hasErrors()) {

			User userToComment=this.uService.getOneUser((Long)session.getAttribute("user__id"));
			model.addAttribute("oneUser", userToComment);
			
			return "comments.jsp";
		}

		// create comments
		
		this.cService.createComment(comment);
		model.addAttribute("allComments", this.cService.getAllComments());
		
		return "redirect:/orders/postcomments";
	}
	
	
	// from this id we can pulloutthe comment and we can pull out the session from user.
	
	@GetMapping("/likes/{id}")
	public String likesComment(HttpSession session, Model model,@PathVariable("id") Long id) {
	//get one user
		User userToLikes=this.uService.getOneUser((Long)session.getAttribute("user__id"));
	// get one comment
		Comment commentTolike=this.cService.GetOneComment(id);
		
		//call likes method
		this.cService.likeComment(userToLikes, commentTolike);
		//model.addAttribute("Comments", );

		return "redirect:/orders/postcomments";
	}
	
	@GetMapping("/unlikes/{id}")
	public String UnlikeComment(@PathVariable("id") Long id,HttpSession session){
		 // get one userToComment 
			User userToComment=this.uService.getOneUser((Long)session.getAttribute("user__id"));
		// get one commentto unlike	
			Comment commentToUnlike=this.cService.GetOneComment(id);
			// Call the Unlike Method from service
			this.cService.unlikeComment(userToComment, commentToUnlike);
			return "redirect:/orders/postcomments";

	}
	
	
}

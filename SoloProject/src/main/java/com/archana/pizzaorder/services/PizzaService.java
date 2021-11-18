package com.archana.pizzaorder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archana.pizzaorder.models.Pizza;
import com.archana.pizzaorder.repositories.PizzaRepository;

@Service
public class PizzaService {
	@Autowired 
	private PizzaRepository pRepo;
	
	//Get Pizza order
	public List<Pizza> getAllPizza(){
		return this.pRepo.findAll();
	}
	
	//Create pizza order
	
	public Pizza createPizza(Pizza pizza) {
		int toppings=0;
		String size=pizza.getSize();
		ArrayList<String> toppingCount= new ArrayList<String>();
		for(String i:pizza.getTopping().split(",")) {
			toppingCount.add(i);
		}
		System.out.println(toppingCount);
		toppings=toppingCount.size();
		System.out.println(toppingCount.size());
		if(size.equals("small")) {
			pizza.setPrice(5+(toppings*0.50));
			
		}
		if(size.equals("Medium")) {
			pizza.setPrice(7+(toppings*0.50));
			
		}
		if(size.equals("Large")) {
			pizza.setPrice(15+(toppings*0.50));
			
		}
		if(size.equals("X-Large")) {
			pizza.setPrice(20+(toppings*0.50));
			
		}

		
		return this.pRepo.save(pizza);
	}
	
	
	//Get One Pizza 
	public Pizza getOnePizza(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	//update Pizza 
	public Pizza updatePizza(Pizza pizza) {
		return this.pRepo.save(pizza);
		
	}
	
	//Delete Pizza 
	public void deletePizza(Long id) {
		 this.pRepo.deleteById(id);
	}
	
}

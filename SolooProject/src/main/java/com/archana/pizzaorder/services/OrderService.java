package com.archana.pizzaorder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archana.pizzaorder.models.Order;
import com.archana.pizzaorder.models.Pizza;
import com.archana.pizzaorder.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository oRepo;
	
	// get All order
	public List<Order> getAllOrder(){
		return this.oRepo.findAll();
	}
	
	// create an order
	
	public Order createOrder(Order order) {
		return this.oRepo.save(order);
	}
	// get one order
	public Order getOneOrder(Long id) {
		return this.oRepo.findById(id).orElse(null);
		
	}
	// update an order
	public Order updateOrder(Order order) {
		return this.oRepo.save(order);
	}
	// delete an order
	public void deleteOrder(Long id) {
		this.oRepo.deleteById(id);
	}
	
	// addorder
	public void addPizzaOrder(Order order ,Pizza pizza) {
		//list of orders
		List<Order> pizzaOrder=(List<Order>) order.getPizzaOrdered();
		pizzaOrder.add(order);
		this.oRepo.save(order);
	}
}

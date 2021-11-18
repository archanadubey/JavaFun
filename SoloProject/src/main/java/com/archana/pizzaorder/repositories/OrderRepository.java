package com.archana.pizzaorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.archana.pizzaorder.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findAll();
	//List<Order> findAllByUserIdOrderByOrderNumberAsc();

	

}

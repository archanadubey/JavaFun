package com.archana.pizzaorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.archana.pizzaorder.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
 List <User> findAll();
 boolean existsByEmail(String email);
	User findByEmail(String email);

}

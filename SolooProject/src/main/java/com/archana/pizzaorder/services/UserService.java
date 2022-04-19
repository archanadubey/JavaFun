package com.archana.pizzaorder.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archana.pizzaorder.models.User;
import com.archana.pizzaorder.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	
	private UserRepository uRepo;
	
	//get AllUser
	public List<User> getAllUser(){
		return this.uRepo.findAll();
	}
	
	// Create a user 
	
	public User createOneUser(User user) {
		return this.uRepo.save(user);
	}
	
	// getOne User
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	// User Registration 
	
	public User  registerUser(User user) {
		// generate the password
		String hash=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		// Set the Hashed password to user Password
		user.setPassword(hash);
		
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		//QUery the user by email 
		User user = this.uRepo.findByEmail(email);
		
		if(user==null) {
			return false;
		}else {
			
			 if(BCrypt.checkpw(password, user.getPassword())) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	    }
		
			
	public User getUserByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	
	
	
	
	
	//save
	//update
	//Delete
	

}

package com.archana.pizzaorder.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.archana.pizzaorder.models.User;
import com.archana.pizzaorder.repositories.UserRepository;


@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	//1
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            // 3
            errors.rejectValue("password", "Match","Password is not match!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }         
    
    
    if(this.uRepo.existsByEmail(user.getEmail())) {
    	
    	 errors.rejectValue("email","unique", "email has already been taken!");
    
    }
    
    if(user.getFirstName().equals("Archu")) {
    	 errors.rejectValue("firstName","No Archu Allowed", "Archu is not able to login at this time.");
    	
    }
    }
	
	

}

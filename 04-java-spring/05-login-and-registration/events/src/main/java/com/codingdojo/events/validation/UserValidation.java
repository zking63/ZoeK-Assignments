package com.codingdojo.events.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.events.models.User;
import com.codingdojo.events.repositories.UserRepo;

@Component
public class UserValidation implements Validator{
	@Autowired
	private UserRepo urepo;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if(this.urepo.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Unique");
        }
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        } 
		
	}

}

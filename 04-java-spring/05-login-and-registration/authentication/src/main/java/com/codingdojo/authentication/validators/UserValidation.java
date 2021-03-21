package com.codingdojo.authentication.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepo;

//the reason you set up this custom validation instead of checking if the pws match in the service layer 
//is bc, right now, the registration page has <p><form:errors path="user.*"/></p> which attaches all errors of user object
//to the user if you wanted to show the pw matching error, you you would have to add another line in the registration
//page just for pws, or you can do it this way and have it append automatically

//tells Springboot this is optional but will be defined by us from the ground up
@Component
public class UserValidation {
	//need access to user repo bc this will have to check for duplicate emails
	@Autowired
	private UserRepo urepo;
	
	//clazz is a general naming convention; take a class (diamond constructor <?> could be any) and name it clazz
	public boolean supports(Class<?> clazz) {
		//make the class the User class
		return User.class.equals(clazz);
	}
	
	//write method that has custom validations. Errors is a special library that we can use as an object
	public void validate(Object target, Errors errors) {
		//you have to typecast with custom validations - so we are going to make the target into user
		User user = (User) target;
		//the ! means not - if the password doesn't make the confirmation
		if (!user.getPassword().equals(user.getPasswordConfirmation())){
			//errors.rejectValue() takes in 3 parameters 1.path you want to use from the model (jsp page), 2. name of this instance, 3. error message
			errors.rejectValue("password", "match", "these passwords don't match");
		}
	}
}

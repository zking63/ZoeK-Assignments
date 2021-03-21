package com.codingdojo.authentication.services;

import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepo;
@Service
public class UserService {
    private final UserRepo urepo;
    
    public UserService(UserRepo urepo) {
        this.urepo = urepo;
    }
    
// register user and hash their password
//BCrypt scrambles the pw and saves it as the scrambled pw
    //BCrypt uses salt (set of random characters that go on end of pw)
    public User registerUser(User user) {
    	//generate hash with BCrypt
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        //use setter replace original pw with the hashed string
        user.setPassword(hashed);
        //save new pw to the database
        return urepo.save(user);
    }
    
// find user by email
    public User findByEmail(String email) {
        return urepo.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = urepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
// authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = urepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
// if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}


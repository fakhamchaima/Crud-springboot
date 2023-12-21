package com.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.models.User;
import com.crud.repository.UserRepositiry;
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
private UserRepositiry userRep;
    @PostMapping("/users")
	private ResponseEntity<?>loginUser( @RequestBody  User userData ){
		User user = userRep.findByUserid(userData.getUserid());
		if(user.getPassword().equals(userData.getPassword()))
			return ResponseEntity.ok(user);
		return(ResponseEntity<?>) ResponseEntity.internalServerError();
	}
    @GetMapping("/users")
   private List<User>afficheruser(){
    	return userRep.findAll();
    }
    
}

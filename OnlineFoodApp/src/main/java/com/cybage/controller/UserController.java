package com.cybage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.CustomException;
import com.cybage.model.User;
import com.cybage.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/food-delivery")
public class UserController {

	
	@Autowired
	private UserService userService;

	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUser() {
		System.out.println("vishal1");
		List<User> list =userService.findAllUsers();
		System.out.println("vishal2");
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws CustomException{
		System.out.println("vishal3");
		User userLogin = userService.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		
		if(user.getUserEmail().equals("admin") && user.getUserPassword().equals("admin")) {
			System.out.println("vishalLogin5");
			return new ResponseEntity<>("Admin logged in", HttpStatus.OK);
		}else if(userLogin == null) {
			System.out.println("vishalLogin6");
			return new ResponseEntity<>("Email or password is wrong", HttpStatus.NOT_FOUND);
		}else  {
			System.out.println("vishalLogin4");			
			return new ResponseEntity<>(userLogin, HttpStatus.OK);			
		}	
		
	} 
	


}

package com.org.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;
import com.org.service.UserService;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<?> addUser(@RequestBody Users newUser) 
	{

	return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(newUser));
	}

	@GetMapping("/readAllUsers")
	public List<Users> readAllUsers() {

		return userService.displayAllUser();
	}

	@PutMapping("/updateUser")
	
	public ResponseEntity<?> updateUser(@RequestBody Users updateUser) {

		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(updateUser));
	}

	@GetMapping("/searchUser/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchUserByID(@PathVariable("id") Long userId) {

		return userService.findUserById(userId);
	}
	

//	@DeleteMapping("/deleteUser/{id}")
//	@ExceptionHandler(RecordNotFoundException.class)
//	public void deleteBookingByID(@PathVariable("id") Long userId) {
//
//		userService.deleteUser(userId);
//	}
}
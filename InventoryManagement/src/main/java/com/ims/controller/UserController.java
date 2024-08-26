package com.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.model.User;
import com.ims.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/findUser/userlist")// Admin and support has access
	public ResponseEntity<?> getAlluser(){
		List<User> users = userService.getAllUser();
		
		if(!users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/findUser/{id}")// Admin and support has access
	public ResponseEntity<?> getUserById(@PathVariable int id){
		User usr = userService.getUserByUserId(id);
		
		if(usr!=null) {
			return new ResponseEntity<>(usr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/remove/{userId}")//Only Admin has access
	public ResponseEntity<?> removeUserById(@PathVariable int userId){
		String deletedMessage = userService.deleteUserById(userId);
		return new ResponseEntity<>(deletedMessage, HttpStatus.OK);
		
	}
	
	

}

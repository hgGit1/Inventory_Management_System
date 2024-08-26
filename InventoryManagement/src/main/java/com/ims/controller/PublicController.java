package com.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.model.User;
import com.ims.service.UserService;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/add-user")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		User usr = userService.getUserByUserName(user.getUserName());
		if(usr!=null) {
			return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);	
		}
		int usrId = userService.addNewUser(user);
		
		if(usrId !=0) {
			return new ResponseEntity<>(usrId, HttpStatus.ACCEPTED);
			
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
	
//	@GetMapping("/userlist")
//	public ResponseEntity<?> getAlluser(){
//		List<User> users = userService.getAllUser();
//		
//		if(!users.isEmpty()) {
//			return new ResponseEntity<>(users, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}

}

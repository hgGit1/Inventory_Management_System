package com.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ims.model.User;
import com.ims.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User getUserByUserName(String UserName) {
		 User user = userRepository.findByUserName(UserName);
		 if(user!=null) {
			 return user;
		 }
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserId(int id) {
		
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNewUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User usr = userRepository.save(user);
		if(usr!=null) {
			return user.getUserId();   
		}
		return 0;
	}

}

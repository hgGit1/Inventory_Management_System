package com.ims.service;

import java.util.List;

import com.ims.model.User;

public interface UserService {
	
	public List<User> getAllUser();
	
	public User getUserByUserName(String UserName);
	
	public User getUserByUserId(int id);
	
	public int addNewUser(User user);
	
	public String deleteUserById(int userId);

}

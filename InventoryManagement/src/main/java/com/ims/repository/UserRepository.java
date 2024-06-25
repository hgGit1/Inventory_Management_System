package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserName(String username);

}

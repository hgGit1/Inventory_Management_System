package com.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ims.model.User;
import com.ims.repository.UserRepository;

@Component
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByUserName(username);
		if(user!=null) {
			UserDetails userDetail = org.springframework.security.core.userdetails.User.builder().username(user.getUserName())
					.password(user.getPassword())
					.roles(user.getUserRole().toString())
					.build();
			
			return userDetail;
		}
		throw new UsernameNotFoundException("User not found for Username"+username);
	}
	
//	public String encodePassword(String rawPassword) {
//        return passwordEncoder.encode(rawPassword);
//    }
	
	

}

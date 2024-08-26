package com.ims.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ImsSecurityConfig{



	@Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		
		http
        .authorizeHttpRequests((requests) -> requests
        	.requestMatchers("/public/**").permitAll()
        	.requestMatchers("/user/remove/**", "/user/**").hasAnyRole("ADMIN")
            .requestMatchers("/user/findUser/**","/ims/save-inventory/**","/ims/remove/**","/ims/update/**").hasAnyRole("ADMIN","SUPPORT")
            .requestMatchers("/ims/showAllInventory/**","ims/findById/**").hasAnyRole("ADMIN","SUPPORT","IMSUSER")
            
            //.requestMatchers("/ims/**").hasAnyRole("USER", "SUPPORT")
            .anyRequest().authenticated()
        )
        .httpBasic()
        .and()
        .csrf().disable();

    return http.build();
		
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
//	@Bean
//	UserDetailsService loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		User user = userRepository.findByUserName(username);
//		if(user!=null) {
//			UserDetails userDetail = org.springframework.security.core.userdetails.User.builder().username(user.getUserName())
//					.password(user.getPassword())
//					.roles(user.getUserRole().toString())
//					.build();
//			
//			return new InMemoryUserDetailsManager(userDetail);
//		}
//		throw new UsernameNotFoundException("User not found for Username"+username);
//	}


}

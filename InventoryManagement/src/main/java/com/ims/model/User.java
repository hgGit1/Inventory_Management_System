package com.ims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	public enum userRoleEnum{
		ADMIN, SUPPORT,  IMSUSER;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="USER_ROLE")
	private userRoleEnum userRole;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public userRoleEnum getUserRole() {
		return userRole;
	}

	public void setUserRole(userRoleEnum userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public User(int userId, String userName, String password, userRoleEnum userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole
				+ "]";
	}


//Developed builder class
//	public static class Builder {
//		private String userName;
//		private String password;
//		private userRoleEnum userRole;
//		
//		public Builder userName(String userName) {
//			this.userName = userName;
//			return this;			
//		}
//		
//		public Builder password(String password) {
//			this.password = password;
//			return this;			
//		}
//		
//		public Builder userRole(userRoleEnum userRole) {
//			this.userRole = userRole;
//			return this;			
//		}
//		
//		public User build() {
//			User user = new User();
//			
//			user.userName = this.userName;
//			user.password = this.password;
//			user.userRole = this.userRole;
//			
//			return user;
//		}
//		
//		
//	}
	
	

}

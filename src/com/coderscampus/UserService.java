package com.coderscampus;

public class UserService {
	
	public User createUser (String username, String password, String name) {
		User user = new User(username, password, name);
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
}
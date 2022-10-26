package com.coderscampus;

public class UserApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		
		// Arrays allows us to store multiple objects (or primitives) into
		// ONe variable - Note: an Array is a one type of Data Structure
		
		for (int i = 0; i <100; i++) {
			users[i] = userService.createUser("user" + (i+1), "password" + (i+1));
		}

	}
}

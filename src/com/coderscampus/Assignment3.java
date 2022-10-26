package com.coderscampus;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment3 {

	public static void main(String[] args) {

	public User createUser(String username, String password, String name) {
		User user = new User(username, password, name);
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		UserService userService = new UserService();
		return user;
		
		User[] users = new User[100];
		
		for (int i = 0; i < 100; i++) {
			users[i] = userService.createUser("user" + (i+1), "password" + (i+1));
		}
		
		

		System.out.println("Too many failed login attempts, you are now locked out.");

	}
}
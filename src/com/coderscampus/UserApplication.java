package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserApplication {

	private static User[] users = new User[4];

	public static void main(String[] args) throws IOException {
		UserService userService = new UserService();
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			int i = 0;
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] stringArray = line.split(",");
				users[i] = userService.createUser(stringArray[0], stringArray[1], stringArray[2]);
				i = i + 1;
			}
		} finally {
			{
				fileReader.close();
			}
		}
		// insert code here for asking questions
		
		int trys = 0;
		Scanner input = new Scanner(System.in);

		while (trys < 5) {
			
			

			System.out.println("Enter your email : ");
			String username = input.next();

			System.out.println("Enter your Password : ");
			String password = input.next();
		}
		for (User user:users) {
			// insert code here for validating or answering
			
			if (username.equals(username) && password.equals(password)) {

				System.out.println("Welcome: " );
			}

			else if (username.equals(username)) {
				System.out.println("Invalid Password!");
				trys++;
			} else if (password.equals(password)) {
				System.out.println("Invalid Username!");
				trys++;
			} else {
				System.out.println("Invalid login, please try again");
				trys++;
			}

		
			
		}
		
	}
}
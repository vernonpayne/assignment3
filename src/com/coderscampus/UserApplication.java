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
		String username = null;
		String password = null;
		boolean isMatched = false;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			int i = 0;
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] stringArray = line.split(",");
				users[i] = userService.createUser(stringArray[0], stringArray[1], stringArray[2]);
				i++;
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
			if (trys < 5) {
				System.out.println("Enter your email : ");
				username = input.nextLine();
				System.out.println("Enter your Password : ");
				password = input.nextLine();
			}
			for (int j = 0; j < 4; j++) {
				// insert code here for validating or answering
				if (username.toLowerCase().matches(users[j].getUsername().toLowerCase())
						&& password.toLowerCase().matches(users[j].getPassword().toLowerCase())) {
					trys = trys + 500;
					isMatched = true;
					if (isMatched == true) {
						System.out.println("Welcome: " + users[j].getName());
						break;
					}
				}
			}
			if (isMatched == false) {
				if (trys <= 3) {
					System.out.println("Invalid login, please try again");
					isMatched = false;
				}
			}
			trys++;
		}
		if (isMatched == false) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
		input.close();
	}
}
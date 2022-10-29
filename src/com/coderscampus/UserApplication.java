package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserApplication {

	private static Object[] users;

	public static void main(String[] args) {
		UserService userService = new UserService();

		for (int i = 0; i <100; i++) {
			users[i] = userService.createUser("user" + (i+1), "password" + (i+1));
		}
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			
			System.out.println(fileReader.readLine());

			String line = "";
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			{
				System.out.println("Closing file reader");
				fileReader.close();
			}
		}
	}
}

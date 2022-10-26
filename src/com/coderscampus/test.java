package com.coderscampus;

import java.io.File;
import java.util.Scanner;

public class test {

	private static Scanner x;

	public static void main(String[] args) {
		String username9 = "Bob";
		String password9 = "123";
		String filepath9 = "data.txt";
		
		verifyLogin(username9,password9,filepath9);
	}

	public static void verifyLogin(String username9, String password9, String filepath9);

	{
		boolean found = false;
		String tempUsername9 = "";
		String tempPassword9 = "";

		try {
			x = new Scanner(new File(filepath9));
			x.useDelimiter("[,\n]");
			
			while(x.hasNext() && !found) {
				tempUsername9 = x.next();
				tempPassword9 = x.next();
				if(tempUsername9.trim().equals(username9.trim()) && tempPassword9.trim().equals(password9.trim()))
				{
					found = true;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error");

		}
	}
}

package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
// 	D E F I N E D : Importing other classes and files outside of the Java Project

public class UserApplication {
//	D E F I N E D : This is called User Application because it carries the main method.

	private static User[] users = new User[5];
//		D E F I N E D : Declaring five private object.
//			OBJECT INSTANTIATE (Class name) (class nick name) = new (Class Name)
//  		This instantiates an object. Access Modifiers are Private, Public, and Protected. When I instantiate the object, it is like creating a place holder

	public static void main(String[] args) throws IOException {
//		D E F I N E D : call this method from outside of the class you are currently in
//			public: 			Access Modifier is Public
//			static:				When you declare a variable or a method as static, it belongs to the class, rather than a specific instance. This means that only one instance of a static member exists, even if you create multiple objects of the class, or if you don't create any. It will be shared by all objects.
//			void: 				should not have a return value
//			main: 				The main method can contain code to execute or call other methods, and it can be placed in any class that's part of a program.
//			(String[] args):  	an array of sequence of characters (Strings) that are passed to the "main" function
//			throws:	 			For any method that can throw exceptions, it is mandatory to use the throws keyword to list the exceptions that can be thrown.
//			IOException: 		the base class for exceptions thrown while accessing information using streams, files and directories

		UserService userService = new UserService();
//			D E F I N E D : Creating a new object called userService

		BufferedReader fileReader = null;
//			D E F I N E D : null is a reserved word (keyword) in Java for literal values. It is a literal similar to the true and false. In Java, null is a keyword much like the other keywords public, static or final. It is just a value that shows that the object is referring to nothing.

		String username = null;
//			D E F I N E D : “A null String is Java is literally equal to a reserved word “null”. It means the String that does not point to any physical address.” In Java programming language, a “null” String is used to refer to nothing. It also indicates that the String variable is not actually tied to any memory location.

		String password = null;
//			D E F I N E D : “A null String is Java is literally equal to a reserved word “null”. It means the String that does not point to any physical address.” In Java programming language, a “null” String is used to refer to nothing. It also indicates that the String variable is not actually tied to any memory location.

		boolean isMatched = false;
//			D E F I N E D : A variable of the primitive data type boolean can have two values: true and false

		try {
//			D E F I N E D : The try statement allows you to define a block of code to be tested for errors while it is being executed.

			fileReader = new BufferedReader(new FileReader("data.txt"));
//				D E F I N E D : FileReader is a class in the java.io package which can be used to read a stream of characters from the files. This class uses either specified charset or the platform's default charset for decoding from bytes to characters.

			int i = 0;
//				D E F I N E D : BufferedReader is a public Java class that reads text, using buffering to enable large reads at a time for efficiency, storing what is not needed immediately in memory for later use. Buffered readers are preferable for more demanding tasks, such as file and streamed readers.

			String line = "";
//				D E F I N E D : lines() method is a static method which returns out stream of lines extracted from a given multi-line string, separated by line terminators which are as follows:
//								String line declares a variable named line of type String . = "" initializes the variable with an empty string.

			while ((line = fileReader.readLine()) != null) {
//				D E F I N E D : This enables the user to prevent further keyboard input when the ReadLine method is called in a loop.

				String[] stringArray = line.split(",");
//					D E F I N E D : String of characters or numbers separated by commas

				users[i] = userService.createUser(stringArray[0], stringArray[1], stringArray[2]);
//					D E F I N E D : This is placing the information gathered from the data.txt file through the array and giving them the value of stringArray 1, 2, and 3.
//						users[1]: 		taking the 5 private objects around line 12 "private static User[] users = new User[5];" 
//						userService: 	pulling the object called uswerService 
//						.createUser: 	demanding it to create the users in the stringArray
//						(stringArray[0], stringArray[1], stringArray[2]): taking each line 

				i++;
//					D E F I N E D : adding value by 1 in the while loop
//						1) Post-Increment (i++): we use i++ in our statement if we want to use the current value, and then we want to increment the value of i by 1. 
//						2) Pre-Increment(++i): We use ++i in our statement if we want to increment the value of i by 1 and then use it in our statement.

			}
		} finally {
//			D E F I N E D : What Is finally? finally defines a block of code we use along with the try keyword. 
//				It defines code that's always run after the try and any catch block, before the method is completed. 
//				The finally block executes regardless of whether an exception is thrown or caught.

			{
				fileReader.close();
//					D E F I N E D : Closing the file reader.

			}
		}

		int trys = 0;
		Scanner input = new Scanner(System.in);
		while (trys < 5) {
			if (trys < 5) {
				System.out.println("Enter your email : ");
				username = input.nextLine();
				System.out.println("Enter your Password : ");
				password = input.nextLine();
			}
			for (int j = 0; j < 5; j++) {
				if (username.matches(users[j].getUsername()) && password.matches(users[j].getPassword())) {
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
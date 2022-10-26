package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIOExample {

	public static void main(String[] args) throws IOException {

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
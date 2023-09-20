package com.seed;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args){
		
		//uncheckedExample();
		
		try {
			checkedExample();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userDefinedException();

	}
	
	public static void uncheckedExample() {
		int a = 10;
		int b = 10/0;
	}
	
	public static void checkedExample() throws FileNotFoundException {
		String file ="D:\\Ram\\classes\\workspace\\Hibernate\\Sep_18_2023\\00_demo1\\src\\com\\seed\\Test.java";
		FileInputStream fis = new FileInputStream(file);
	}
	
	public static void userDefinedException(){
		int ageOfPerson = 1000;
		if (ageOfPerson > 100) {
			//throw new IllegalArgumentException("Age cannot be greater than 100");
			throw new InvalidAgeException();
		}	
	}
}

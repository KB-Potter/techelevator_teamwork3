package com.techelevator;

public class KataStringCalculator {
	
	public int add(String numbers) {
		
		int result = 0; 
		
		if (!numbers.isEmpty()) { //if the string of numbers isn't empty
			
			String[] temp =  numbers.split(",|\n|;|!"); 
			
			for (String s: temp) {
				int number = Integer.parseInt(s); 
				result += number; 
		}
	}
		return result; 
	}
}
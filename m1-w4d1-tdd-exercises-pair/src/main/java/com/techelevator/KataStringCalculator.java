package com.techelevator;

public class KataStringCalculator {
	
	public int add(String numbers) {
		
		int result = 0; 
		
		if (!numbers.isEmpty()) {
			
			String[] temp =  numbers.split(",|\n|;|!"); 
			
			for (String s: temp) {
				int number = Integer.parseInt(s); 
				result += number; 
		}
	}
		return result; 
	}
}
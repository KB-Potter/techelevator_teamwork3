package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException; 


public class VendingMachineOptions {
	
	File vmOptions = new File("/Users/kpotter/Development/java-week4-pair-exercise/m1-capstone/vendingmachine.csv"); 
	
	Map<String, Item> foodOptions = new LinkedHashMap<String, Item>(); //how we get the names, price, slot number for our food options
	
	public String displayOptions() throws FileNotFoundException { 
	
	String options = ""; 	
		
	try(Scanner fileScanner = new Scanner(vmOptions)) {
	
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine(); 
			options += line + "/n"; 
			
		}
	}
	return options;
	}
}


package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {
		
		public static void main(String[] args) throws FileNotFoundException {
					
				File alice = new File("/Users/kpotter/Development/java-week4-pair-exercise/m1-w4d2-file-io-part1-exercises-pair/alices_adventures_in_wonderland.txt"); 
					
					int wordCount = 0; 
					int sentenceCount = 0;
					
					
			try(Scanner fileScanner = new Scanner(alice)) {
						
						
						while (fileScanner.hasNextLine()) {
							String wordLine = fileScanner.nextLine(); 
							
							if (wordLine.isEmpty()) {
								continue;
							}
							
							String[] temp = wordLine.trim().split("\\s+"); 
							wordCount += temp.length; 
							String[] temp2 = wordLine.split("[!.?]");
							
							sentenceCount += temp2.length - 1; 
							
						}
						
						
					}
					
					System.out.println("The word count is: " + wordCount );
					System.out.println("The sentence count is: " + sentenceCount);

	}

}

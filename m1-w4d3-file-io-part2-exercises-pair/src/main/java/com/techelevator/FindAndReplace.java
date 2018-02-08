package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws FileNotFoundException {
		
		File alice = new File("/Users/sgirard/workspace/pair-exercises/java-week4-pair-exercise/m1-w4d3-file-io-part2-exercises-pair/alices_adventures_in_wonderland.txt"); 
			
			Scanner in = new Scanner(System.in);
			
			//setup destination file
			String basepath = "/Users/sgirard/workspace/pair-exercises/java-week4-pair-exercise/m1-w4d3-file-io-part2-exercises-pair";
			String fakeAlice = basepath + "/newAlice.txt";
			File newAlice = new File(fakeAlice);
			
			if (newAlice.exists() == false) {
				try {
					newAlice.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("Which word are we searching for?");
			String searchWord = in.next();
			
			System.out.println("Which word are we replacing it with?");
			String replaceWord = in.next();
			
			try(Scanner fileScanner = new Scanner(alice)) {
				while (fileScanner.hasNextLine()) {
					String wordLine = fileScanner.nextLine(); 
					
					
					String[] temp = wordLine.split(searchWord); 
					
					//String replaced = "";
					//for (int i = 0; i < temp.length; i++) {
					
					String replaced = temp[0] + replaceWord.trim();// + temp[1];
					
					try (PrintWriter writer = new PrintWriter(newAlice)) {//it's not appeding it's overwriting. open printwriter first and open scanner inside of it. open printwriter as a filewriter and it will append if true. We HAVE to append it
						
						if (wordLine.contains(searchWord)) {
							writer.println(replaced);
						} else {
							writer.print(wordLine);
						}
						writer.flush();
						}
					}
					
				}
				if (alice.getTotalSpace() ==	newAlice.getTotalSpace()) {
							System.out.println("Search word not found!");
				
			}
			

}

}

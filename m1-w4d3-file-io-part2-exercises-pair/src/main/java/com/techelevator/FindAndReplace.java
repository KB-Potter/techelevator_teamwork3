package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		
		File alice = new File("/Users/sgirard/workspace/pair-exercises/java-week4-pair-exercise/m1-w4d3-file-io-part2-exercises-pair/alices_adventures_in_wonderland.txt"); 
			
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the complete file path of the origin file you'd like to search:");
			File originFile = getInputFileFromUser();
			
			//setup destination file
			System.out.println("Please enter a destination path:");
			String destinationPath = in.nextLine();
			
			File destinationFile = new File(destinationPath);
			
			try {
				String fakeAlice = destinationPath + "newAlice.txt";
				File newAlice = new File(fakeAlice);
			} catch (FileNotFoundException e) {
				System.out.println("Invalid destination path");
				break;
			}
			
			
			
			
//			String basepath = "/Users/sgirard/workspace/pair-exercises/java-week4-pair-exercise/m1-w4d3-file-io-part2-exercises-pair";
//			String fakeAlice = basepath + "/newAlice.txt";
//			File newAlice = new File(fakeAlice);
			
			if (originFile.exists() == false) {
				try {
					originFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (destinationFile.exists() == false) {
				try {
					destinationFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("Which word are we searching for?");
			String searchWord = in.next();
			
			System.out.println("Which word are we replacing it with?");
			String replaceWord = in.next();
			
//			try(Scanner fileScanner = new Scanner(alice)) {
//				while (fileScanner.hasNextLine()) {
//					String wordLine = fileScanner.nextLine(); 
//					
//					String replaced = wordLine.replaceAll(searchWord, replaceWord);
//					
//					try (FileWriter writer = new FileWriter(newAlice, true)) {
//						if (wordLine.contains(searchWord)) {
//							writer.write(replaced + "\n");
//						} else {
//							writer.write(wordLine + "\n");
//						}
//						writer.flush();
//						}
//					}
//					
//				}
//				if (alice.getTotalSpace() ==	newAlice.getTotalSpace()) {
//							System.out.println("Search word not found!");
				
			}
			
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}
}



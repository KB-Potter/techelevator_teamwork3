package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws IOException {
		
		File alice = new File("/Users/sgirard/workspace/pair-exercises/java-week4-pair-exercise/m1-w4d3-file-io-part2-exercises-pair/alices_adventures_in_wonderland.txt"); 
			
			Scanner in = new Scanner(System.in);
			File originFile = getInputFileFromUser();
			
			if (originFile.exists() == false) {
				try {
					originFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//setup destination file
			System.out.print("Please enter a destination path: ");
			String addToPath = in.nextLine();
			
			File destinationPath = new File(addToPath);
			
			if (!destinationPath.exists()) {
				System.out.print("Invalid destination path");
				System.exit(0);
			}
			
			File doesItExist = new File (addToPath + "newAlice2.txt");
			Files.deleteIfExists(doesItExist.toPath());
			//doesItExist.delete();
			
			String fakeAlice = addToPath + "newAlice2.txt";
			File newAlice = new File(fakeAlice);
		
			System.out.println("Which word are we searching for?");
			String searchWord = in.next();
			
			System.out.println("Which word are we replacing it with?");
			String replaceWord = in.next();
			int count = 0;
			
			try (FileWriter writer = new FileWriter(newAlice, false)) {
			try(Scanner fileScanner = new Scanner(originFile)) {
				while (fileScanner.hasNextLine()) {
					String wordLine = fileScanner.nextLine(); 
					
					String replaced = wordLine.replaceAll(searchWord, replaceWord);
					
					
						if (wordLine.contains(searchWord)) {
							writer.write(replaced + "\n");
							count++;
						} else {
							writer.write(wordLine + "\n");
						}
						writer.flush();
						}
					}
					
				}
			if (count == 0) {
				System.out.println("Search word not found!");
			}
				
			}
			
	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter the complete file path of the origin file you'd like to search: ");
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



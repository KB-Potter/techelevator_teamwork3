package com.techelevator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.change.MakeChange;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
														   PURCHASE_MENU_OPTION_SELECT_PRODUCT, 
														   PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String FEED_OPTION_1 = "add $1";
	private static final String FEED_OPTION_2 = "add $2";
	private static final String FEED_OPTION_3 = "add $5";
	private static final String FEED_OPTION_4 = "add $10";
	private static final String[] FEED_MENU_OPTIONS = { FEED_OPTION_1, 
													   FEED_OPTION_2, 
													   FEED_OPTION_3, 
													   FEED_OPTION_4};
	
	
	private Menu menu;
	static Scanner in = new Scanner (System.in);
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws FileNotFoundException {
		
		//objects we need access to throughout
		Map<String, MasterItem> foodOptions = new LinkedHashMap<String, MasterItem>(); //creating empty map to fill with items
		VendingMachineOptions VM500 = new VendingMachineOptions();
		for (String s : VM500.getMapOfItems().keySet())  { //populating our local Map with items from the VendingMachineOptions class
			foodOptions.put(s, VM500.getMapOfItems().get(s));
		}
		MakeChange makeChange = new MakeChange();
		
		
		CustomerMoney customerBalance = new CustomerMoney();
		
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items, start here and make this work first
				System.out.println("Slot " + "Item " + "Price " + "Quantity");
				
				for (String y : foodOptions.keySet()) {
					
					System.out.print(foodOptions.get(y).getSlot() + " ");
					System.out.print(foodOptions.get(y).getName() + " ");
					System.out.print("$" + foodOptions.get(y).getPrice() + " ");
					
					if (foodOptions.get(y).getQuantity() != 0) {
					System.out.print(foodOptions.get(y).getQuantity());
					} else {
						System.out.print("SOLD OUT");
					}
					
					System.out.println("");
				}
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				List<String> sounds = new ArrayList<String>();
				
				while(true) {
				System.out.println("Currrent Money Provided: " + "$" + String.format("%.2f",customerBalance.getCurrentMoney())); //add customer money total here
				String choice2 = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				
					if (choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						String choice3 = (String)menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
							if (choice3.equals(FEED_OPTION_1)) {
								customerBalance.addToCurrent(1.0);
							} else if (choice3.equals(FEED_OPTION_2)) {
								customerBalance.addToCurrent(2.0);
							} else if (choice3.equals(FEED_OPTION_3)) {
								customerBalance.addToCurrent(5.0);
							} else { //option 4
								customerBalance.addToCurrent(10.0);
							}
						
					} else if (choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						
						System.out.println("Please enter the product slot to purchase");
						String userChoice = in.nextLine();
						
						if (foodOptions.get(userChoice) == null) {
							System.out.println("Invalid choice. Display Items to see valid choices");
							System.out.println("");
						} else {
							
							System.out.println(foodOptions.get(userChoice).purchaseAndMessage(foodOptions.get(userChoice).getName()));
							if (foodOptions.get(userChoice).getQuantity() != 0) {
							customerBalance.subractFromCurrent(foodOptions.get(userChoice).getPrice());
							sounds.add(foodOptions.get(userChoice).consume());
							}
						}
						
						
					} else if (choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						
						System.out.println("Your change is: " + String.format("%.2f", makeChange.makeChange(customerBalance.getCurrentMoney())));
						customerBalance.subractFromCurrent(customerBalance.getCurrentMoney());
						
						for (String sound : sounds) {
							System.out.println(sound);
						}
						break;
					}
				
					}
			
		}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

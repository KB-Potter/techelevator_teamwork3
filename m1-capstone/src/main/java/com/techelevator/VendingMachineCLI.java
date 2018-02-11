package com.techelevator;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.view.Menu;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws FileNotFoundException {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items, start here and make this work first
				
				VendingMachineOptions VM500 = new VendingMachineOptions(); 
				//Map<String, MasterItem> foodOptions = (Map<String, MasterItem>) VM500.displayOptions();
				Map<String, MasterItem> foodOptions = new LinkedHashMap<String, MasterItem>();
				VM500.displayOptions();
				
				for (String s : VM500.displayOptions().keySet())  { //trying to make it display the vending machine items, but won't convert Map to a String
					System.out.println(foodOptions.get(s).getSlot() + " ");
					System.out.print(foodOptions.get(s).getName() + " ");
					System.out.print(foodOptions.get(s).getPrice() + " ");
					System.out.print(foodOptions.get(s).getQuantity());
				//	System.out.println(x);
				}
				
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

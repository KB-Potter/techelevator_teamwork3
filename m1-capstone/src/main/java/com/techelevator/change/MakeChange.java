package com.techelevator.change;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeChange {
	
	
	

	
	public double makeChange (double currentBalance) {
		Coin[] coins = new Coin[] { 	new Quarter(), new Dime(), new Nickel() };
		currentBalance *= 100;
		double result = 0;
		
		Map<Coin, Integer> change = new HashMap<Coin, Integer>();
		
		for (Coin coin : coins) { //iterating through the coins Array
			
			if (currentBalance <= 0) { break; }
			int cnt = (int)currentBalance / coin.getValue();
			if (cnt > 0) {
				currentBalance = currentBalance % (coin.getValue() * cnt);
				change.put(coin, cnt);
			}
		}
		
		for (Coin coin : change.keySet()) {
			result += (double)coin.getValue();
		}
		result /= 10;
		
		return result;
	}
}

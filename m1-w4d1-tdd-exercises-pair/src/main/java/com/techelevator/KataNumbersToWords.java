package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class KataNumbersToWords {
	
	public String numbersToWords(int numbers) {
		
		String result = "";
		
		if (numbers < 1) {
			return "C'mon, enter a positive number...";
		}
	 
		
		if (numbers < 20) {
			result += this.lessThanTwenty(numbers);
			return result;
			}
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		do {
			array.add(0, numbers % 10);
			numbers /= 10;
			
		} while (numbers > 0);
		
		
			
		for (int i = 0; i < array.size()-1; i++) {
			
			if (array.size() == 5) {
				if (array.get(i) == 1) {
					int added = array.get(i) + array.get(i+1) + 9;
					result += this.lessThanTwenty(added);
					result += " thousand ";
					array.remove(i);
					array.remove(i);
				} else {
					result += this.decades(array.get(i));
						if (array.get(i+1) != 0) { 
							result += "-"; 
							}
					array.remove(i);
				}
			}
			
			if (array.size() == 4) {
				
				result += this.lessThanTwenty(array.get(i));
				result += " thousand ";
				if ((array.get(i+1) == 0) && (array.get(i+2) == 0) && (array.get(i+3) == 0)) { break;}
				array.remove(i);
			}
			
			
			if (array.size() == 3) {
				
				if (array.get(i) == 0 && array.get(i+1) == 0) {
					result += "and ";
					result += this.lessThanTwenty(array.get(i+2)); 
					array.remove(i); 
					array.remove(i+1);
					
					break;
					
					
				} else if (array.get(i) == 0) {
					array.remove(i); 
					
				} else {
					
				result += this.lessThanTwenty(array.get(i));
				result += " hundred ";
				if ((array.get(i+1) == 0) && (array.get(i+2) == 0)) { break;}
				array.remove(i);
				}
				
			}
			
			if (array.size() == 2) {
				
				if (array.get(i) == 0) {
					result += "and ";
					result += this.lessThanTwenty(array.get(i + 1));
					break;
				}
				
				if (array.get(i) == 1) {
					int added = array.get(i) + array.get(i+1) + 9;
					result += this.lessThanTwenty(added);
					break;
				} 
				
				result += this.decades(array.get(i));
				
				if (array.get(i+1) != 0) {
					result += "-";
					result += this.lessThanTwenty(array.get(i+1));
				}
			}
			
		}
		
		return result;
	}
	
	public String lessThanTwenty(int numbers) {
		
		String result = "";
		
		switch (numbers) {
		case 1: result += "one"; break;
		case 2: result += "two"; break;
		case 3: result += "three"; break;
		case 4: result += "four"; break;
		case 5: result += "five"; break;
		case 6: result += "six"; break;
		case 7: result += "seven"; break;
		case 8: result += "eight"; break;
		case 9: result += "nine"; break;
		case 10: result += "ten"; break;
		case 11: result += "eleven"; break;
		case 12: result += "twelve"; break;
		case 13: result += "thirteen"; break;
		case 14: result += "fourteen"; break;
		case 15: result += "fifteen"; break;
		case 16: result += "sixteen"; break;
		case 17: result += "seventeen"; break;
		case 18: result += "eighteen"; break;
		case 19: result += "nineteen"; break;
		default : result += "";
		
		}
		return result;
		
	}
	
	public String decades(int numbers) {
		
		String result = "";  
		
		switch (numbers) {
		case 2: result += "twenty"; break;
		case 3: result += "thirty"; break;
		case 4: result += "forty"; break;
		case 5: result += "fifty"; break;
		case 6: result += "sixty"; break;
		case 7: result += "seventy"; break;
		case 8: result += "eighty"; break;
		case 9: result += "ninety"; break;
		
		default : result += "";
		
		}
		return result;
		
	}

	
}

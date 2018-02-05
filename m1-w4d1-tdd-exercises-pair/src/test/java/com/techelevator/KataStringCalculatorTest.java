package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataStringCalculatorTest {

	KataStringCalculator test; 
	
	@Before
	public void setup() {
		test = new KataStringCalculator(); 
	}

	@Test
	public void return_zero() {
		Assert.assertEquals(0, test.add("")); 
	}
	
	@Test 
	public void return_one_number_for_string_of_one() {
		Assert.assertEquals(3, test.add("3")); 
		Assert.assertEquals(5, test.add("5")); 
		Assert.assertEquals(9, test.add("9")); 
	}
	
	@Test 
	public void add_two_numbers_from_string() {
		Assert.assertEquals(5, test.add("3,2")); 
		Assert.assertEquals(8, test.add("3,5")); 
		Assert.assertEquals(12, test.add("10,2")); 
	
	}
	
	@Test
	public void add_three_numbers_from_string() {
		Assert.assertEquals(15, test.add("5,5,5"));
		Assert.assertEquals(40, test.add("10,20,10"));
		
	}
	
	@Test
	public void add_numbers_without_new_lines() {
		Assert.assertEquals(6, test.add("1\n2,3"));
		Assert.assertEquals(14, test.add("3\n5\n2,4"));
	}
	
	@Test
	public void add_numbers_without_exclamation_or_semi_colon() {
		Assert.assertEquals(3, test.add("1\n1;1"));
		Assert.assertEquals(7 , test.add("4\n3!")); 
	}
	
}
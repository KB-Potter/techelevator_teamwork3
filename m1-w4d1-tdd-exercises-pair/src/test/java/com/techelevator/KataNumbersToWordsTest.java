package com.techelevator;

import org.junit.*;

public class KataNumbersToWordsTest {
	
	KataNumbersToWords test;
	
	@Before
	public void setup() {
		test = new KataNumbersToWords();
	}

	@Test
	public void one_digit_numbers_become_words() {
		Assert.assertEquals("five", test.numbersToWords(5));
		Assert.assertEquals("eight", test.numbersToWords(8));
		Assert.assertEquals("two", test.numbersToWords(2));
		Assert.assertEquals("nine", test.numbersToWords(9));
	}
	
	@Test
	public void two_digit_numbers_become_words() {
		Assert.assertEquals("fifty", test.numbersToWords(50));
		Assert.assertEquals("fifty-three", test.numbersToWords(53));
		Assert.assertEquals("twenty-nine", test.numbersToWords(29));
		Assert.assertEquals("eighty-six", test.numbersToWords(86));
		Assert.assertEquals("eighteen", test.numbersToWords(18));
		Assert.assertEquals("eleven", test.numbersToWords(11));
	}
	
	@Test
	public void three_digit_numbers_become_words() {
		Assert.assertEquals("three hundred ", test.numbersToWords(300));
		Assert.assertEquals("five hundred sixty-nine", test.numbersToWords(569));
		Assert.assertEquals("eight hundred seventy-two", test.numbersToWords(872));
		Assert.assertEquals("eight hundred and two", test.numbersToWords(802));
	}
	
	@Test
	public void four_digit_numbers_become_words() {
		Assert.assertEquals("four thousand ", test.numbersToWords(4000));
		Assert.assertEquals("four thousand and three", test.numbersToWords(4003));
		Assert.assertEquals("four thousand forty", test.numbersToWords(4040));
		Assert.assertEquals("eight thousand nine hundred sixty-seven", test.numbersToWords(8967));
		Assert.assertEquals("one thousand three hundred forty-five", test.numbersToWords(1345));
		}
	
	@Test
	public void five_digit_numbers_become_words() {
		Assert.assertEquals("fifty thousand ", test.numbersToWords(50000));
		Assert.assertEquals("sixty-seven thousand nine hundred eighty", test.numbersToWords(67980));
		Assert.assertEquals("ten thousand seven hundred ", test.numbersToWords(10700));
		Assert.assertEquals("ninety-nine thousand nine hundred ninety-nine", test.numbersToWords(99999));
		Assert.assertEquals("twenty-six thousand and five", test.numbersToWords(26005));
		}
	
	@Test
	public void six_digit_numbers_become_words() {
		Assert.assertEquals("five hundred thousand ", test.numbersToWords(500000));
		Assert.assertEquals("four hundred and two thousand ", test.numbersToWords(402000));
		Assert.assertEquals("seven hundred thousand two hundred ", test.numbersToWords(700200));
		Assert.assertEquals("eight hundred thousand sixty", test.numbersToWords(800060));
		Assert.assertEquals("seven hundred thousand and six", test.numbersToWords(700006));
		Assert.assertEquals("nine hundred and ninety-nine thousand nine hundred ninety-nine", test.numbersToWords(999999));
		}
	
	
	
}

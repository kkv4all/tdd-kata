package com.tdd.romannumbers;

public class RomanNumeral {
	private static final int[]    VALUES  = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static final String[] SYMBOLS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	
	public String getRomanNumber(int number) {
		String result = "";
		for(int i=0; i<VALUES.length; i++) {
			while(number >= VALUES[i]) {
				result += SYMBOLS[i];
				number -= VALUES[i]; 
			}
		}
		return result;
	}

}

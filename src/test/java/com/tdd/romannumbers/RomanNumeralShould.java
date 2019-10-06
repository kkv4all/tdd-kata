package com.tdd.romannumbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author kkv4all
 * @description Roman Numeral 
 * 	- implement method to provide Roman number equivalent to given number
 * 	1 - I
 *  2 - II
 *  4 - IV
 * 	5 - V
 * 	9 - IX
 *  10 - X
 *  40 - XL
 *  50 - L
 *  90 - XC
 *  100 - C
 *  400 - CD
 *  500 - D
 *  900 - CM
 *  1000 - M
 */

public class RomanNumeralShould {

	@Test
	public void return_roman_equivalent_to_number() {
		RomanNumeral roman = new RomanNumeral();
		
		assertEquals(roman.getRomanNumber(1), "I");
		assertEquals(roman.getRomanNumber(2), "II");
		assertEquals(roman.getRomanNumber(3), "III");
		assertEquals(roman.getRomanNumber(5), "V");
		assertEquals(roman.getRomanNumber(6), "VI");
		assertEquals(roman.getRomanNumber(10), "X");
		assertEquals(roman.getRomanNumber(11), "XI");
		assertEquals(roman.getRomanNumber(15), "XV");
		assertEquals(roman.getRomanNumber(16), "XVI");
		assertEquals(roman.getRomanNumber(20), "XX");
		assertEquals(roman.getRomanNumber(35),"XXXV");
		assertEquals(roman.getRomanNumber(37),"XXXVII");
		assertEquals(roman.getRomanNumber(50),"L");
		assertEquals(roman.getRomanNumber(60),"LX");
		assertEquals(roman.getRomanNumber(100),"C");
		assertEquals(roman.getRomanNumber(1903),"MCMIII");
		assertEquals(roman.getRomanNumber(1999),"MCMXCIX");
		assertEquals(roman.getRomanNumber(4497),"MMMMCDXCVII");
	}

}

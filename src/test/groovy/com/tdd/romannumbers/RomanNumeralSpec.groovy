package com.tdd.romannumbers;

import spock.lang.Specification

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

public class RomanNumeralSpec extends Specification {

	def "Roman Numeral should return roman equivalent to number" () {
		given: "Roman Numeral Object"
			def RomanNumeral roman = new RomanNumeral();
		when: "get roman numbers for given number"
			def romanNumber = roman.getRomanNumber(givenNumber)
		then: "roman number got should be equal to expected roman number"
			romanNumber.equals(expectedRomanNumber)
		where:
			givenNumber	|	expectedRomanNumber
			1			|	"I"
			2			|	"II"
			3			|	"III"
			5			|	"V"
			6			|	"VI"
			10			|	"X"
			11			|	"XI"
			15			|	"XV"
			16			|	"XVI"
			20			|	"XX"
			35			|	"XXXV"
			37			|	"XXXVII"
			50			|	"L"
			60			|	"LX"
			100			|	"C"
			110			|	"CX"
			150			|	"CL"
			4			|	"IV"
			9			|	"IX"
			40			|	"XL"
			90			|	"XC"
			400			|	"CD"
			900			|	"CM"
			1903		|	"MCMIII"
			1999		|	"MCMXCIX"
			4497		|	"MMMMCDXCVII"
						
	}
}

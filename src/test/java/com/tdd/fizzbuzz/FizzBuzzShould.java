package com.tdd.fizzbuzz;

/**
 * @author kkv4all
 * @description
 * Problem Definition: A program takes a Number as input. 
 * For multiples of three print “Fizz” instead of the number 
 * and for the multiples of five print “Buzz”. 
 * For numbers which are multiples of both three and five print “FizzBuzz “.
 * For rest of the number it should return the same number back.
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzShould {

	private FizzBuzz fizzbuzz;

	@Before
	public void setUp() throws Exception {
		fizzbuzz = new FizzBuzz();
	}

	@Test
	public void returnsTheSameNumberForRestNumbers () {
		
		assertEquals("1", fizzbuzz.getResult(1));
	}
	
	@Test
	public void returnsFizzForNumberDivisibleByThree() {
		
		assertEquals("Fizz", fizzbuzz.getResult(3));
	}

}

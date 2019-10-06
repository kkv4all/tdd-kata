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

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		FizzBuzz fizzbuzz = new FizzBuzz();
		
		assertEquals("1", fizzbuzz.getResult(1));
	}

}

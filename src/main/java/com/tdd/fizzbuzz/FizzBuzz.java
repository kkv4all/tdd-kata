package com.tdd.fizzbuzz;

/**
 * @author kkv4all
 * @description
 * Problem Definition: A program takes a Number as input. 
 * For multiples of three print "Fizz" instead of the number 
 * and for the multiples of five print "Buzz". 
 * For numbers which are multiples of both three and five print "FizzBuzz".
 * For rest of the number it should return the same number back.
 */

public class FizzBuzz {

	public String getResult(int i) {
		if(i%3==0 && i%5==0)
			return "FizzBuzz";
		else if(i%5==0)
			return "Buzz";
		else if(i%3==0)
			return "Fizz";
		return String.valueOf(i);
	}

}

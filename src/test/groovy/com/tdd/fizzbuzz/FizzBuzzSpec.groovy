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

import spock.lang.Specification

public class FizzBuzzSpec extends Specification{
	
	def setup() {
		
	}
	
	def "return the same number back"(){
		given: ""
			FizzBuzz fizzBuzz = new FizzBuzz();
		when: "FizzBuzz.getResult is called"
			def  result = fizzBuzz.getResult(1)
		then: "result should be same"
			result == "1"
	}
}

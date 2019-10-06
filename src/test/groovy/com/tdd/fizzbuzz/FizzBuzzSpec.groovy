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
	private FizzBuzz fizzBuzz
	
	def setup() {
		fizzBuzz = new FizzBuzz();
	}
	
	def "return the same number back"(){
		given: ""
		when: "FizzBuzz.getResult is called"
			def  result = fizzBuzz.getResult(1)
		then: "result should be same"
			result == "1"
	}
	
	def "returns Fizz For Number Divisible By Three"(){
		given: "A Number input divisible by 3"

		when: "FizzBuzz.getResult is called"
			def  result = fizzBuzz.getResult(number)
		then: "result should be Fizz"
			result == "Fizz"
		where: "numbers are"
			number	| _
			3		| _
			6		| _
	}
}

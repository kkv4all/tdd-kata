/**
 * 
 */
package com.tdd.stack;



import static org.junit.Assert.assertEquals

import spock.lang.Specification;

/**
 * @author kkv4all
 * @description Stack Class implementation for TDD
 *	- Stack should be empty when created.
 *	- Object pushed last should be popped first.
 *	- Pop throws EmptyStackException if stack is empty.
 *	- Stack pops the Object in reverse order of which it is pushed.
 */

public class StackSpec extends Specification {
	
	Stack stack = new Stack();
	
	private static final Object OBJECT_1 = new Object();
	private static final Object OBJECT_2 = new Object();
	
	def "Stack should be empty when created" () {
		given:""
		when: "pop is called"
			stack.pop();
		then: "EmptyStackException is thorwn"
			thrown(EmptyStackException.class)
	}
	
	def "Stack should pop the last object pushed and pop in reverse order" () {
		given:"" 
		
		when:"two objects are pushed and pop called"
			stack.push(OBJECT_1);
			stack.push(OBJECT_2);
			def objectPoped = stack.pop();
			def objectPopedAgain = stack.pop();
		then:"object poped is the last we pushed"
			 objectPoped.equals(OBJECT_2);
			 objectPopedAgain.equals(OBJECT_1);
	}
}

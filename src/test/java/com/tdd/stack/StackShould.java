package com.tdd.stack;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author kkv4all
 * @description Stack Class implementation for TDD
 *	- Stack should be empty when created.
 *	- Object pushed last should be popped first.
 *	- Pop throws EmptyStackException if stack is empty.
 *	- Stack pops the Object in reverse order of which it is pushed.
 */

public class StackShould {

	Stack stack;
	
	private static final Object OBJECT_1 = new Object();
	private static final Object OBJECT_2 = new Object();
	
	@Before
	public void setUp() throws Exception {
		this.stack = new Stack();
	}

	@Test(expected = EmptyStackException.class)
	public void beEmptyWhenCreated() {
		this.stack = new Stack();
		stack.pop();
	}
	
	@Test
	public void popTheLastObjectPushedAndPopInReverseOrder() {
		stack.push(OBJECT_1);
		stack.push(OBJECT_2);
		
		assertEquals(stack.pop(),OBJECT_2);
		assertEquals(stack.pop(),OBJECT_1);
	}
}

package com.tdd.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {

	private List<Object> list = null;

	public Stack() {
		this.list = new ArrayList<>();
	}

	public Object pop() {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}else {
			return list.remove(list.size()-1);
		}
	}

	public void push(Object object) {
		list.add(object);
	}

}

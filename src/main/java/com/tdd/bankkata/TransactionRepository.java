package com.tdd.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	List<Transaction> list = new ArrayList<Transaction>();
	
	public void add(Transaction transaction) {
		list.add(transaction);
	}

	public List<Transaction> getAll() {
		return list;
	}

}

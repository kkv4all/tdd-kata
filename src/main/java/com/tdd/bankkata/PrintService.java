package com.tdd.bankkata;

import java.util.List;
import java.util.ListIterator;

public class PrintService {

	private Console console;

	public PrintService(Console console) {
		this.console = console;
	}

	public void printStatement(List<Transaction> transactionList) {
		int balance = 0;
		console.printLine(" DATE | AMOUNT | BALANCE");
		for(Transaction transaction:transactionList) {
			balance += transaction.getAmount();
		}
		ListIterator<Transaction> iterator = transactionList.listIterator(transactionList.size());
		while(iterator.hasPrevious()) {
			Transaction transaction = iterator.previous();
			console.printLine(String.format(" %s | %d.00 | %d.00",transaction.getDate(),transaction.getAmount(),balance));
			balance -= transaction.getAmount();
		}
	}
	
}

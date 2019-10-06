package com.tdd.bankkata;

import java.util.List;

public class Account {

	private Clock clock;
	private TransactionRepository transactionRepository;
	private PrintService printService;

	public Account(Clock clock, TransactionRepository transactionRepository,PrintService printService) {
		this.clock = clock;
		this.transactionRepository = transactionRepository;
		this.printService = printService;
	}

	public void deposit(int amount) {
		String date = clock.today();
		Transaction deposit = new Transaction(date, amount);
		
		transactionRepository.add(deposit);
	}

	public void withdraw(int amount) {
		String date = clock.today();
		Transaction withdraw = new Transaction(date, -amount);
		
		transactionRepository.add(withdraw);
	}

	public void printStatement() {
	 List<Transaction> list = transactionRepository.getAll();
	 printService.printStatement(list);
	}

}

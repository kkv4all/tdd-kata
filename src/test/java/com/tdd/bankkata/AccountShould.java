package com.tdd.bankkata;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {
	@Mock
	private Clock clock;
	@Mock
	private TransactionRepository transactionRepository;
	@Mock
	private PrintService printService;

	private final String CURRENT_DATE = "22/08/2019";
	private final List<Transaction> LIST = null;

	private Account account;

	@Before
	public void setup() {
		account = new Account(clock, transactionRepository, printService);
	}
	
	
	@Test
	public void store_the_deposit_transaction() {
		int amount = 500;
		Mockito.doReturn(CURRENT_DATE).when(clock).today();
		Transaction deposit = new Transaction(CURRENT_DATE,amount);
		
		account.deposit(amount);
		
		Mockito.verify(transactionRepository).add(deposit);
	}

	@Test
	public void store_the_withdraw_transaction() {
		int amount = 500;
		Mockito.doReturn(CURRENT_DATE).when(clock).today();
		Transaction withdraw = new Transaction(CURRENT_DATE,-amount);
		
		account.withdraw(amount);
		
		Mockito.verify(transactionRepository).add(withdraw);
	}
	
	@Test
	public void print_statement_for_transaction() {
		Mockito.doReturn(LIST).when(transactionRepository).getAll();
		
		account.printStatement();
		
		Mockito.verify(printService).printStatement(LIST);
	}
}

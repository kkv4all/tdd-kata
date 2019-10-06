package com.tdd.bankkata;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrintingWorkflow {
	@Mock
	private Clock clock;
	@Mock
	private Console console;
	
	private TransactionRepository repository;
	private PrintService printService;

	private Account account;

	@Before
	public void setup() {
		repository = new TransactionRepository();
		printService = new PrintService(console);
		account = new Account(clock, repository, printService);
	}
	
	@Test
	public void should_print_statement_containing_all_transactions() {
		given(clock.today()).willReturn("01/04/2019","05/04/2019","10/04/2019");
		account.deposit(1000);
		account.withdraw(100);
		account.deposit(500);
		
		account.printStatement();
		
		verify(console).printLine(" DATE | AMOUNT | BALANCE");
		verify(console).printLine(" 10/04/2019 | 500.00 | 1400.00");
		verify(console).printLine(" 05/04/2019 | -100.00 | 900.00");
		verify(console).printLine(" 01/04/2019 | 1000.00 | 1000.00");
	}

}

package com.tdd.bankkata

import spock.lang.Specification

class StatmentPrintingFeature extends Specification {
	
	def console = Mock(Console.class)
	def clock = Mock(Clock.class)
	
	Account account;
	
	def DATE_3 = "10/04/2019"
	def DATE_2 = "02/04/2019"
	def DATE_1 = "01/04/2019"
	
	def setup() {
		def transactionRepository = new TransactionRepository();
		def statementPrinter = new PrintService(console);
		account = new Account(clock,transactionRepository,statementPrinter)
	}
	
	def "print statement after some withdraw and deposits"(){
		given: "Instance of account service"
			clock.today()>>>[DATE_1,DATE_2,DATE_3]
			account.deposit(1000);
			account.withdraw(100);
			account.deposit(500);
			
		when: "statement is printed"
			account.printStatement();
		then: "print statement should be as expected"
			with(console){
				1 * console.printLine(" DATE | AMOUNT | BALANCE")
				1 * console.printLine(" 10/04/2019 | 500.00 | 1400.00")
				1 * console.printLine(" 02/04/2019 | -100.00 | 900.00")
				1 * console.printLine(" 01/04/2019 | 1000.00 | 1000.00")
			}
	}

}

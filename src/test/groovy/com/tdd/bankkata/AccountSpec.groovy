package com.tdd.bankkata

import spock.lang.Specification

class AccountSpec extends Specification {
	
	def TransactionRepository transactionRepository = Mock()
	def Clock clock = Mock()
	def PrintService printService=Mock()
	
	private Account account
	
	def setup() {
		account = new Account(clock, transactionRepository, printService);
	}
	
	def DATE_1 = "01/04/2019"
	
	def "deposit the amount"(){
		given: "amount to deposit"
			def amount = 500;
			clock.today()>>DATE_1
			def Transaction transaction = new Transaction(DATE_1,amount)
		when: "the amount deposited"
			account.deposit(amount)
		then: "account repositiory called with provided value"
			1 * transactionRepository.add(transaction)
	}
	
	def "withdraw the amount"(){
		given: "amount to withdraw"
			def amount = 500;
			clock.today()>>DATE_1
			def Transaction transaction = new Transaction(DATE_1,-amount)
		when: "the amount withdrawn"
			account.withdraw(amount)
		then: "account repositiory called with provided value"
			1 * transactionRepository.add(transaction)
	}
}

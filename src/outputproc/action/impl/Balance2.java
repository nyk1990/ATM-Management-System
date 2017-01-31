package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.Balance;

/**
 * This is a action class for output processor
 */
public class Balance2 extends Balance {

	private Account2Data data;

	public Balance2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void displayBalance() {
		int balance = data.getBalance();
		System.out.println("Balance amount = $" + balance);
		System.out.println();
	}
}

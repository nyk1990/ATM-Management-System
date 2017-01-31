package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.BelowMinBalance;

/**
 * This is a action class for output processor
 */
public class BelowMinBalance1 extends BelowMinBalance {

	private Account1Data data;

	public BelowMinBalance1(Account1Data data) {
		this.data = data;
	}

	@Override
	public void displayBelowMinBalance() {
		System.out.println("Current Balance of $" + data.getBalance() + " is below Minimum balance amount of $"
				+ data.getMinBalance());
	}
}

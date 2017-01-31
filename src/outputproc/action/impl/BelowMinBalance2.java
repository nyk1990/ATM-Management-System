package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.BelowMinBalance;

/**
 * This is a action class for output processor
 * 
 */
public class BelowMinBalance2 extends BelowMinBalance {

	private Account2Data data;

	public BelowMinBalance2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void displayBelowMinBalance() {
		System.out.println("Current Balance of $" + data.getBalance() + " is below/equal to Minimum balance amount of $"
				+ data.getMinBalance());
	}
}

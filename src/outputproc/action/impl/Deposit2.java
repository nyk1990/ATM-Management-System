package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.Deposit;

/**
 * This is a action class for output processor
 */

public class Deposit2 extends Deposit {

	private Account2Data data;

	public Deposit2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void makeDeposit() {
		int d = data.getDeposit();
		if (d > 0) {
			int b = data.getBalance();
			b = b + d;
			data.setBalance(b);
		}
	}
}

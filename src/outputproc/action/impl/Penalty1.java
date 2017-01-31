package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.Penalty;

/**
 * This is a action class for output processor
 */
public class Penalty1 extends Penalty {

	private Account1Data data;

	public Penalty1(Account1Data data) {
		this.data = data;
	}

	@Override
	public void chargePenalty() {
		int penalty = data.getPenalty();
		float balance = data.getBalance();
		balance = balance - penalty;
		data.setBalance(balance);
		System.out.println("Penalty of $" + penalty + " is Applied");
	}
}

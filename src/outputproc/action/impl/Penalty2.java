package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.Penalty;

/**
 * This is a action class for output processor
 */
public class Penalty2 extends Penalty {

	private Account2Data data;

	public Penalty2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void chargePenalty() {
		int penalty = data.getPenalty();
		if (penalty > 0) {
			int balance = data.getBalance();
			balance = balance - penalty;
			data.setBalance(balance);
			System.out.println("Penalty of $" + penalty + " is Applied");
		}
	}
}

package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.Withdraw;

/**
 * This is a action class for output processor
 */
public class Withdraw2 extends Withdraw {

	private Account2Data data;

	public Withdraw2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void makeWithdraw() {
		int w = data.getWithdraw();
		if (w > 0) {
			int b = data.getBalance();
			b = b - w;
			data.setBalance(b);
		}
	}
}

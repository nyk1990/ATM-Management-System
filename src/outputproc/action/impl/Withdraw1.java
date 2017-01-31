package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.Withdraw;

/**
 * This is a action class for output processor
 */
public class Withdraw1 extends Withdraw {

	private Account1Data data;

	public Withdraw1(Account1Data data) {
		this.data = data;
	}

	@Override
	public void makeWithdraw() {
		float w = data.getWithdraw();
		if (w > 0.0) {
			float b = data.getBalance();
			b = b - w;
			data.setBalance(b);
		}
	}
}

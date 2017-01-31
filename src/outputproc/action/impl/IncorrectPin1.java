package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.IncorrectPin;

/**
 * This is a action class for output processor
 */
public class IncorrectPin1 extends IncorrectPin {

	private Account1Data data;

	public IncorrectPin1(Account1Data data) {
		this.data = data;
	}

	@Override
	public void displayIncorrectPin() {
		System.out.println("Pin # is not correct, please try again");
	}
}

package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.IncorrectPin;

/**
 * This is a action class for output processor
 */
public class IncorrectPin2 extends IncorrectPin {

	private Account2Data data;

	public IncorrectPin2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void displayIncorrectPin() {
		System.out.println("Pin # is not correct, please try again");
	}
}

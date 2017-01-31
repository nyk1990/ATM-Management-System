package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.IncorrectId;

/**
 * This is a action class for output processor
 */
public class IncorrectId2 extends IncorrectId {

	private Account2Data data;

	public IncorrectId2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void displayIncorrectId() {
		System.out.println("User Id # is not correct, please try again");
	}
}

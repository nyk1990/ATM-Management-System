package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.IncorrectId;

/**
 * This is a action class for output processor
 */
public class IncorrectId1 extends IncorrectId {

	private Account1Data data;

	public IncorrectId1(Account1Data data) {
		this.data = data;
	}

	@Override
	public void displayIncorrectId() {
		System.out.println("User Id # is not correct, please try again");
	}
}

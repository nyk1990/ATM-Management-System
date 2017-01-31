package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.TooManyAttempts;

/**
 * This class is used for
 */
public class TooManyAttempts1 extends TooManyAttempts {

	private Account1Data data;

	public TooManyAttempts1(Account1Data data) {
		this.data = data;
	}

	@Override
	public void displayTooManyAttempts() {
		System.out.println("Exceeded maximum number of incorrect attempts " + "(" + data.getMaxInvalidAttempts() + ")");
	}
}

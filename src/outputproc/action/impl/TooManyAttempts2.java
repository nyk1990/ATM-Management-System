package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.TooManyAttempts;

/**
 * This class is used for
 */
public class TooManyAttempts2 extends TooManyAttempts {

	private Account2Data data;

	public TooManyAttempts2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void displayTooManyAttempts() {
		System.out.println("Exceeded maximum number of incorrect attempts " + "(" + data.getMaxInvalidAttempts() + ")");
	}
}

package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.EnterPin;

/**
 * This is a action class for output processor
 */
public class EnterPin2 extends EnterPin {

	private Account2Data data;

	public EnterPin2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void displayEnterPin() {
		System.out.println("Select Option 2 from Menu to Enter Pin#");
	}
}

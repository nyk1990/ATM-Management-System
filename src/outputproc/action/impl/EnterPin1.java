package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.EnterPin;

/**
 * This is a action class for output processor
 */
public class EnterPin1 extends EnterPin {

	private Account1Data data;

	public EnterPin1(Account1Data data) {
		this.data = data;
	}

	@Override
	public void displayEnterPin() {
		System.out.println("Select Option 2 from Menu to Enter Pin#");
	}
}

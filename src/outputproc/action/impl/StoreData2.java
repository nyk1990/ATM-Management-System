package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.StoreData;

/**
 * This is a action class for output processor
 */
public class StoreData2 extends StoreData {

	private Account2Data data;

	public StoreData2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void storeData() {
		// store card details
		data.setPin(data.getPinInput());
		data.setUserId(data.getUserIdInput());
		data.setBalance(data.getBalanceInput());
	}
}

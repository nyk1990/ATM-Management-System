package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.Menu;

/**
 * This is a action class for output processor
 */
public class Menu2 extends Menu {

	private Account2Data data;

	public Menu2(Account2Data data) {
		this.data = data;
	}

	@Override
	public void displayMenu() {
		System.out.println("~~~TRANSACTION MENU~~~");
		System.out.println("DEPOSIT");
		System.out.println("WITHDRAW");
		System.out.println("BALANCE");
		System.out.println();
	}
}

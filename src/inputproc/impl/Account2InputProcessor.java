package inputproc.impl;

import java.util.Scanner;
import constant.OperationEnum;
import data.Account2Data;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import mdaefsm.state.IdleState;
import mdaefsm.state.SuspendedState;

/**
 * This class is InputProcessor for Account 2 Component
 */
public class Account2InputProcessor extends InputProcessor {

	/* Data specific to Account-1 */
	private Account2Data acctData;
	private boolean flag = true;
	/* MDA-EFSM Class */
	private MdaEfsm model;

	public Account2InputProcessor(Account2Data acctData, MdaEfsm model) {
		this.model = model;
		this.acctData = acctData;
	}

	@Override
	public void handleInput() {
		process();
	}

	/**
	 * open an account where p is a pin, y is an user’s identification #, and a
	 * is a balance
	 *
	 * @param p
	 * @param y
	 * @param a
	 */
	public void OPEN(int p, int y, int a) {
		if (p > 0 && y > 0 && a >= 0) {
			acctData.setPinInput(p);
			acctData.setUserIdInput(y);
			acctData.setBalanceInput(a);

			model.open();
		} else {
			println("Invalid Input");
		}
	}

	/**
	 * provides pin #
	 *
	 * @param x
	 */
	public void PIN(int x) {
		int pin = acctData.getPin();
		int max = acctData.getMaxInvalidAttempts();

		if (x == pin) {
			// correct pin
			model.correctPin();

			int minBalance = acctData.getMinBalance();
			int balance = acctData.getBalance();

			if (balance > minBalance) {
				model.aboveMinBalance();
			} else {
				model.belowMinBalance();
			}
		} else {
			model.incorrectPin(max);
			if(model.getNumOfAttempts()>2)
			{
				System.out.println("Please Select Login Again");
			}
		}
	}

	/**
	 * deposit amount d in the account
	 *
	 * @param d
	 */
	public void DEPOSIT(int d) {
		if (d > 0) {
			acctData.setDeposit(d);
			// deposit the amount
			model.deposit();

			// Check balance status wrt Min balance
			int balance = acctData.getBalance();
			int minBalance = acctData.getMinBalance();
			if (balance > minBalance) {
				model.aboveMinBalance();
			} else {
				model.belowMinBalanceWithPenalty();
			}
		} else {
			println("Deposit Amount should be greater than 0");
		}
	}

	/**
	 * Withdraw amount w from the account
	 *
	 * @param w
	 */
	public void WITHDRAW(int w) {
		if (w > 0) {
			acctData.setWithdraw(w);
			model.withdraw();

			// check for overdrawn condition
			int balance = acctData.getBalance();
			int minBalance = acctData.getMinBalance();
			if (balance > minBalance) {
				model.aboveMinBalance();
			} else {
				model.belowMinBalanceWithPenalty();
			}
		} else {
			println("Withdraw Amount should be greater than 0");
		}
	}

	public void BALANCE() {
		int balance = acctData.getBalance();
		if(balance == 0){
			System.out.println("No Funds Available");
		}else{
			model.balance();
		}
	}

	public void LOGIN(int y) {
		int userId = acctData.getUserId();
		if (y == userId) {
			// correct login
			model.login();
		} else {
			// incorrect login
			model.invalidLogin();
		}
	}

	public void LOGOUT() {
		model.logout();
	}

	public void suspend() {
		model.suspend();
		System.out.println("Account Suspended");
	}

	public void activate() {
		model.activate();
		System.out.println("Account Activated");
	}

	public void close() {
		model.getOutputProcessor().setStoreData(null);
		model.close();
		System.out.println("Account Closed");
	}

	public void process() {

		
		OperationEnum opcode = null;

		// Display Menu
		displayOperations();

		while (flag) {
			Scanner in = new Scanner(System.in);
			println();
			println("Select Operation:");
			println("0 - OPEN ,1- LOGIN ,2 - PIN ,3 - DEPOSIT ,4 - WITHDRAW,"
					+ "5 - BALANCE,6 - LOGOUT,9 - SUSPEND, 10 - ACTIVATE, 11 - CLOSE, 12 - QUIT");

			try {
				int option = getIntInput(in, null);
				opcode = OperationEnum.value(option);

				switch (opcode) {
				case OPEN:
					int p = printOperationGetIntInput(in, "open(p,y,a)", "P(pin)):");
					int y = getIntOperationInput(in, "y(userid):");
					int a = getIntOperationInput(in, "a(balance):");

					OPEN(p, y, a);
					break;

				case LOGIN:
					int userId = printOperationGetIntInput(in, "login(int y)", "y(userid):");
					LOGIN(userId);
					break;

				case PIN:
					int pin = printOperationGetIntInput(in, "pin(int x)", "x(pin):");
					PIN(pin);
					break;

				case SUSPEND:
					printOperation("Account suspended");
					suspend();
					break;

				case ACTIVATE:
					printOperation("Account activated");
					activate();
					break;

		
				case BALANCE:
					// printOperation("balance()");
					if (!(model.getCurrentState() instanceof SuspendedState||model.getCurrentState() instanceof IdleState)) {
						BALANCE();
					} else {
						System.out.println("This operation is not possible");
					}
					break;

				case DEPOSIT:
					if (!(model.getCurrentState() instanceof SuspendedState|| model.getCurrentState() instanceof IdleState)) {
						int d = printOperationGetIntInput(in, "deposit(int d)", "d(Deposit amount):");
						DEPOSIT(d);
					} else {
						System.out.println("This operation is not possible");
					}
					break;

				case WITHDRAW:
					if (!(model.getCurrentState() instanceof SuspendedState|| model.getCurrentState() instanceof IdleState)) {
						int withdraw = printOperationGetIntInput(in, "withdraw(int w)", "w(Withdraw amount):");
						WITHDRAW(withdraw);
					} else {
						System.out.println("This operation is not possible");
					}
					break;

				case LOGOUT:
					printOperation("Logged off");
					System.out.println("You need to login to proceed further");
					LOGOUT();
					break;

				case CLOSE:
					// printOperation("Account closed");
					close();
					flag=false;
					break;

				case QUIT:
					flag = false;
					break;

				default:
					println("Invalid option");
					break;
				}
				println();
			} catch (Exception e) {
				// ignore the exception.
			}
		}
		println("Exiting Account - 2. Thank You");
	}

	public void displayOperations() {
		println();
		println(" ACCOUNT-2");
		println(" MENU of Operations");
		println("0. OPEN(int,int,int)");
		println("1. LOGIN(int)");
		println("2. PIN(int)");
		println("3. DEPOSIT(int)");
		println("4. WITHDRAW(int)");
		println("5. BALANCE()");
		println("6. LOGOUT()");
		println("7. suspend(int)");
		println("8. activate(int)");
		println("9. close(int)");
		println("10. Exit Account -2");
	}
}

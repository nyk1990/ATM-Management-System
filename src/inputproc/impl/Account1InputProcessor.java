package inputproc.impl;

import constant.OperationEnum;
import data.Account1Data;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import mdaefsm.state.IdleState;
import mdaefsm.state.LockedState;
import java.util.Scanner;

/**
 * This class is InputProcessor for Account 1 Component
 *
 */
public class Account1InputProcessor extends InputProcessor {

	/* Data specific to Account-1 */
	private Account1Data acctData;

	/* MDA-EFSM Class */
	private MdaEfsm model;
	public Account1InputProcessor(Account1Data acctData, MdaEfsm model) {
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
	public void open(String p, String y, float a) {
		if (isNonEmpty(p) && isNonEmpty(y) && a >= 0) {
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
	public void pin(String x) {
		String pin = acctData.getPin();
		int max = acctData.getMaxInvalidAttempts();

		if (x != null && x.equals(pin)) {
			model.correctPin();

			float minBalance = acctData.getMinBalance();
			float balance = acctData.getBalance();

			if (balance > minBalance) {
				model.aboveMinBalance();
			} else {
				model.belowMinBalance();
			}
		} else {
			model.incorrectPin(max);
			if(model.getNumOfAttempts()>3)
			{
				System.out.println("Plese Select Login Again");
			}
		}
	}

	/**
	 * deposit amount d in the account
	 *
	 * @param d
	 */
	public void deposit(float d) {
		if (d > 0) {
			acctData.setDeposit(d);

			// deposit the amount
			model.deposit();
		} else {
			println("Deposit Amount should be greater than 0");
		}
	}

	/**
	 * Withdraw amount w from the account
	 *
	 * @param w
	 */
	public void withdraw(float w) {
		if (w > 0) {
			acctData.setWithdraw(w);
			model.withdraw();

			// check for overdrawn condition
			float balance = acctData.getBalance();
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

	public void balance() {
		float balance = acctData.getBalance();
		if(balance == 0.00){
			System.out.println("No Funds Available");
		}else{
			model.balance();
		}
	}

	public void login(String y) {
		String userId = acctData.getUserId();
		if (y != null && y.equals(userId)) {
			// correct login
			model.login();
		} else {
			// incorrect login
			model.invalidLogin();
		}

	}

	public void logout() {
		model.logout();
	}

	public void lock(String x) {
		String pin = acctData.getPin();

		// correct pin
		if (x != null && x.equals(pin)) {
			model.lock();
			System.out.println("Account Locked");
		} else {
			model.incorrectLock();
		}
	}

	public void unlock(String x) {
		String pin = acctData.getPin();

		// correct pin
		if (x != null && x.equals(pin)) {
			model.unlock();
			checkMinBalance();
			System.out.println("Account Unlocked");
		} else {
			model.incorrectUnlock();
		}
	}

	private void checkMinBalance() {
		// Check balance status w.r.t. Min. balance
		float balance = acctData.getBalance();
		int minBalance = acctData.getMinBalance();
		if (balance > minBalance) {
			model.aboveMinBalance();
		} else {
			model.belowMinBalance();
		}
	}

	public void process() {

		
		OperationEnum opcode = null;

		// Display Menu
		displayOperations();
		boolean flag = true;
		
		while (flag) {
			Scanner in = new Scanner(System.in);
			println();
			println("Select Operation:");
			println("0 - OPEN ,1- LOGIN ,2 - PIN ,3 - DEPOSIT ,4 - WITHDRAW,"
					+ "5 - BALANCE,6 - LOGOUT,7 - LOCK, 8 - UNLOCK, 12 - QUIT");

			try {
				int option = getIntInput(in, null);
				opcode = OperationEnum.value(option);

				switch (opcode) {
				case OPEN:
					String p = printOperationGetStringInput(in, "open(p,y,a)", "p(pin)):");
					String y = getStringOperationInput(in, "y(userid):");
					float a = getFloatOperationInput(in, "a(balance):");

					open(p, y, a);
					break;

				case LOGIN:
					String userId = printOperationGetStringInput(in, "login(String y)", "y(userid):");
					login(userId);
					break;

				case PIN:
					String pin = printOperationGetStringInput(in, "pin(String x)", "x(pin):");

					pin(pin);
					break;

				case LOCK:
					String pin1 = printOperationGetStringInput(in, "lock(String x)", "lock(pin):");
					lock(pin1);
					break;

				case UNLOCK:
					String pin2 = printOperationGetStringInput(in, "unlock(String x)", "unlock(pin):");

					unlock(pin2);
					break;

				case BALANCE:
					if (!(model.getCurrentState() instanceof LockedState
							|| model.getCurrentState() instanceof IdleState)) {
						printOperation("balance()");
						balance();
					} else {
						System.out.println("This operation is not possible");
					}
					break;

				case DEPOSIT:
					if (!(model.getCurrentState() instanceof LockedState
							|| model.getCurrentState() instanceof IdleState)) {
						float d = printOperationGetFloatInput(in, "deposit(float d)", "d(Deposit amount):");
						deposit(d);
						float balance = acctData.getBalance();
						int minBalance = acctData.getMinBalance();
						if (balance > minBalance) {
							model.aboveMinBalance();
						} else {
							model.belowMinBalanceWithPenalty();
						}
					} else {
						System.out.println("This operation is not possible");
					}
					break;

				case WITHDRAW:
					if (!(model.getCurrentState() instanceof LockedState
							|| model.getCurrentState() instanceof IdleState)) {
						float withdraw = printOperationGetFloatInput(in, "withdraw(float w)", "w(Withdraw amount):");
						withdraw(withdraw);
					} else {
						System.out.println("This operation is not possible");
					}
					break;

				case LOGOUT:
					printOperation("Logged off");
					System.out.println("You need to login to proceed further");
					logout();
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
		println("Exiting Account - 1. Thank You");
	}

	public void displayOperations() {
		println();
		println(" ACCOUNT-1");
		println(" MENU of Operations");
		println("0. open(string,string,float)");
		println("1. login(string)");
		println("2. pin(string)");
		println("3. deposit(float)");
		println("4. withdraw(float)");
		println("5. balance()");
		println("6. logout()");
		println("7. lock(string)");
		println("8. unlock(string)");
		println("9. Exit Account -1");
	}

}

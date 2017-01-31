package data;

/**
 * This class represents Temporary data store for Account-2 component.
 *
 */
public class Account2Data extends AccountData {

	/* pin for the account */
	private int pin;

	/* user’s identification */
	private int userId;

	/* balance in the account */
	private int balance;

	private int deposit;

	private int withdraw;

	/* Input pin for the account */
	private int pinInput;

	/* Input User Id */
	private int userIdInput;

	/* Input balance in the account */
	private int balanceInput;

	public Account2Data() {
		super();
		maxInvalidAttempts = 2;
		minBalance = 0;
		penalty = 0;
	}

	public int getPinInput() {
		return pinInput;
	}

	public void setPinInput(int pinInput) {
		this.pinInput = pinInput;
	}

	public int getUserIdInput() {
		return userIdInput;
	}

	public void setUserIdInput(int userIdInput) {
		this.userIdInput = userIdInput;
	}

	public int getBalanceInput() {
		return balanceInput;
	}

	public void setBalanceInput(int balanceInput) {
		this.balanceInput = balanceInput;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
}

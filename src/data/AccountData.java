package data;

/**
 * This is an abstract class for representing Temporary data store for Account
 * component.
 */
public abstract class AccountData {

	/* maximum invalid pin attempts */
	protected int maxInvalidAttempts;

	/* Minimum balance Amount to be maintained in the account */
	protected int minBalance;

	/* Penalty if account is overdrawn */
	protected int penalty;

	/* Locked Status */
	protected boolean locked;

	/* Suspended Status */
	protected boolean suspended;

	public AccountData() {
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(int minBalance) {
		this.minBalance = minBalance;
	}

	public int getMaxInvalidAttempts() {
		return maxInvalidAttempts;
	}

	public void setMaxInvalidAttempts(int maxInvalidAttempts) {
		this.maxInvalidAttempts = maxInvalidAttempts;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
}

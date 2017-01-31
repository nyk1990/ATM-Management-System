package constant;

/**
 * This enum defines account option types
 *
 */
public enum OperationEnum {
	OPEN(0), LOGIN(1), PIN(2), DEPOSIT(3), WITHDRAW(4), BALANCE(5), LOGOUT(6), LOCK(7), UNLOCK(8), SUSPEND(9), ACTIVATE(
			10), CLOSE(11), QUIT(12);

	private int id;

	private OperationEnum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static OperationEnum value(int code) {
		final OperationEnum[] enums = OperationEnum.class.getEnumConstants();
		for (OperationEnum operationEnum : enums) {
			if (operationEnum.id == code) {
				return operationEnum;
			}
		}
		return null;
	}
}
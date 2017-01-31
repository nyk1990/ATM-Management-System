package exception;

/**
 * This class is used for defining exceptions for Account system.
 *
 */
@SuppressWarnings("serial")
public class AccountException extends RuntimeException {

	public AccountException() {
	}

	public AccountException(String message) {
		super(message);
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountException(Throwable cause) {
		super(cause);
	}
}

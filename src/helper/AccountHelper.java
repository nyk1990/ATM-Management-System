package helper;

import constant.AccountEnum;
import data.AccountData;
import exception.AccountException;
import factory.AbstractAccountFactory;
import factory.Account1Factory;
import factory.Account2Factory;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import static constant.AccountEnum.ACCOUNT_1;
import static constant.AccountEnum.ACCOUNT_2;

/**
 * This class is used for delegating Account Services.
 */
public class AccountHelper {

	private static AccountHelper ourInstance = new AccountHelper();

	public static AccountHelper getInstance() {
		return ourInstance;
	}

	private AccountHelper() {
	}

	/**
	 * This method is used for initializing the selected account service
	 */
	public void service(AccountEnum accountEnum) {

		// Get the factory implementation for the selected account.
		final AbstractAccountFactory accountFactory = createAccountFactory(accountEnum);

		// Create and initialize Account Data for the selected Account
		final AccountData accountData = accountFactory.createAccountData();

		// Create and initialize OutputProcessor for the selected Account
		OutputProcessor op = accountFactory.createOutputProcessor(accountData);

		// Initialize MDA-EFSM Model
		MdaEfsm model = new MdaEfsm(op);

		// Create and initialize InputProcessor for the selected Account
		InputProcessor inputProcessor = accountFactory.createInputProcessor(accountData, model);

		// Call the input processor for the selected Account
		inputProcessor.handleInput();
	}

	/**
	 * This method returns the factory implementation.
	 */
	public static AbstractAccountFactory createAccountFactory(AccountEnum accountEnum) {
		if (ACCOUNT_1.equals(accountEnum)) {
			return new Account1Factory();
		} else if (ACCOUNT_2.equals(accountEnum)) {
			return new Account2Factory();
		} else {
			throw new AccountException("Invalid Account Type");
		}
	}
}

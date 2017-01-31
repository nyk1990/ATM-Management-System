package factory;

import data.Account1Data;
import data.AccountData;
import inputproc.impl.Account1InputProcessor;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import outputproc.action.*;
import outputproc.action.impl.*;

/**
 * This is a Abstract Factory class for Account 1 Component
 */
public class Account1Factory extends AbstractAccountFactory {

	public AccountData createAccountData() {
		return new Account1Data();
	}

	public InputProcessor createInputProcessor(AccountData data, MdaEfsm mdaefsm) {
		return new Account1InputProcessor((Account1Data) data, mdaefsm);
	}

	public Balance createBalance(AccountData data) {
		return new Balance1((Account1Data) data);
	}

	public BelowMinBalance createBelowMinBalance(AccountData data) {
		return new BelowMinBalance1((Account1Data) data);
	}

	public Deposit createDeposit(AccountData data) {
		return new Deposit1((Account1Data) data);
	}

	public EnterPin createDisplayEnterPin(AccountData data) {
		return new EnterPin1((Account1Data) data);
	}

	public IncorrectId createIncorrectId(AccountData data) {
		return new IncorrectId1((Account1Data) data);
	}

	public IncorrectPin createIncorrectPin(AccountData data) {
		return new IncorrectPin1((Account1Data) data);
	}

	public Menu createMenu(AccountData data) {
		return new Menu1((Account1Data) data);
	}

	public Penalty createPenalty(AccountData data) {
		return new Penalty1((Account1Data) data);
	}

	public StoreData createStoreData(AccountData data) {
		return new StoreData1((Account1Data) data);
	}

	public TooManyAttempts createTooManyAttempts(AccountData data) {
		return new TooManyAttempts1((Account1Data) data);
	}

	public Withdraw createWithdraw(AccountData data) {
		return new Withdraw1((Account1Data) data);
	}
}